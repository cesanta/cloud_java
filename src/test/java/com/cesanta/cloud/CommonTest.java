
package com.cesanta.cloud;

import com.neovisionaries.ws.client.WebSocketException;

import java.io.IOException;

import com.cesanta.clubby.lib.Clubby;
import com.cesanta.clubby.lib.ClubbyAdapter;
import com.cesanta.clubby.lib.ClubbyListener;
import com.cesanta.clubby.lib.ClubbyState;

import java.util.UUID;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.fail;

public class CommonTest {
    private Object s = new Object();
    private boolean ok = false;
    private String errMsg = null;

    public Clubby createClubby() throws IOException {

        // read psk from file
        String psk = new String(
                Files.readAllBytes(Paths.get("/secrets/ourci/docker-agent")),
                "UTF-8"
                );
        // cut the newline character
        psk = psk.substring(0, psk.length() - 1);

        Clubby clubby = new Clubby.Builder()
            .serverAddress("wss://api-ci.cesanta.com")
            .backend("//api-ci.cesanta.com")
            .id("build-docker-agent." + UUID.randomUUID().toString())
            .psk(psk)
            .timeout(20)
            .build();
        clubby.addListener(clubbyListener);

        setOk(false);
        clubby.connect();
        // wait until connected or failed to connect
        // TODO(dfrank): eliminate race condition (if connection succeed or
        // failed earlier than waitForTest() is called, it will wait forever)
        waitForTest();
        if (!isOk()) {
            fail("Failed to establish Clubby connection");
        }

        return clubby;
    }

    public void destroyClubby(Clubby clubby) {
        clubby.disconnect();
        clubby.removeListener(clubbyListener);
    }

    public void waitForTest() {
        synchronized (s) {
            try {
                s.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void notifyTest() {
        synchronized (s) {
            s.notify();
        }
    }

    public void setOk(boolean ok, String errMsg) {
        this.ok = ok;
        this.errMsg = errMsg;
    }

    public void setOk(boolean ok) {
        setOk(ok, null);
    }

    public boolean isOk() {
        return this.ok;
    }

    public String errorMsg() {
        return this.errMsg;
    }

    private ClubbyListener clubbyListener = new ClubbyAdapter() {
        @Override
        public void onConnected(Clubby clubby) {
            //System.out.println("Connected to server");
        }

        @Override
        public void onDataSending(Clubby clubby, String text) {
            //System.out.println("Sending text data: " + text);
        }

        @Override
        public void onDataReceived(Clubby clubby, String text) {
            //System.out.println("Received text data: " + text);
        }

        @Override
        public void onDisconnected(Clubby clubby) {
            //System.out.println("Disconnected from server");
            clubby = null;
        }

        @Override
        public void onStateChanged(Clubby clubby, ClubbyState newState) {
            if (newState == ClubbyState.CONNECTED) {
                setOk(true);
                notifyTest();
            }
        }

        @Override
        public void onConnectError(Clubby clubby, WebSocketException cause)
        {
            System.out.println("Connect error: " + cause);
            notifyTest();
        }
    };
}
