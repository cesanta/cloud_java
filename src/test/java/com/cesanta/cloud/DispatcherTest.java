
package com.cesanta.cloud;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.io.IOException;

import com.cesanta.cloud.DispatcherService;
import com.cesanta.cloud.DispatcherService.RouteStatsResponseItem;

import com.cesanta.clubby.lib.Clubby;
import com.cesanta.clubby.lib.CmdAdapter;

public class DispatcherTest extends CommonTest {
    private Clubby clubby;
    private DispatcherService dispatcher = null;

    @Before
    public void setUp() throws IOException
    {
        clubby = createClubby();
        dispatcher = DispatcherService.createInstance(clubby);
    }

    @After
    public void tearDown()
    {
        destroyClubby(clubby);
        clubby = null;
        dispatcher = null;
    }

    @Test
    public void helloTest() {

        setOk(false);
        dispatcher.hello(
                new DispatcherService.HelloArgs(),
                new CmdAdapter<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println("Got response on Dispatcher.Hello: OK");
                        setOk(true);
                        notifyTest();
                    }

                    @Override
                    public void onError(int status, String status_msg) {
                        System.out.println("Error: Status: " + status + ", msg: " + status_msg);
                        notifyTest();
                    }
                }
                );

        waitForTest();

        if (!isOk()) {
            fail("Did not receive a positive response on Dispatcher.Hello");
        }
    }
}
