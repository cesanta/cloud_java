
package com.cesanta.cloud;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cesanta.clubby.lib.Clubby;
import com.cesanta.clubby.lib.CmdAdapter;
import com.cesanta.clubby.lib.CmdListener;
import com.cesanta.clubby.lib.CmdListenerWrapper;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class DispatcherService {

    private final Clubby clubby;

    public static DispatcherService createInstance(Clubby clubby) {
        return new DispatcherService(clubby);
    }

    private DispatcherService(Clubby clubby) {
        this.clubby = clubby;
    }


    //-- Hello {{{

    public void hello(HelloArgs args, HelloListener listener) {
        clubby.callBackend(
                "/v1/Dispatcher.Hello",
                args,
                new HelloListenerWrapper(listener)
                );
    }

    //-- args {{{
    public static final class HelloArgs {
    }
    // }}}

    //-- listener {{{

    public static interface HelloListener extends CmdListener {
        public void onResponse(HelloResponse response);
    }

    public static class HelloAdapter extends CmdAdapter implements HelloListener {
        @Override
        public void onResponse(HelloResponse response) {}
    }

    public static class HelloListenerWrapper extends CmdListenerWrapper {

        /*
         * NOTE: hides the `CmdListenerWrapper.listener` field
         */
        HelloListener listener;

        HelloListenerWrapper(HelloListener listener) {
            this.listener = listener;

            /*
             * Since `listener` field hides the one of superclass, we need
             * to set the superclass' field explicitly
             */
            super.listener = listener;
        }

        @Override
        protected void onResponseGeneric(ObjectMapper mapper, String respStr) throws IOException {
            this.listener.onResponse(
                    mapper.readValue(
                        respStr, DispatcherService.HelloResponse.class
                        )
                    );
        }
    }

    // }}}

    //-- response {{{

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class HelloResponse {
    }

    // }}}

    // }}}

    //-- RouteStats {{{

    public void routeStats(RouteStatsArgs args, RouteStatsListener listener) {
        clubby.callBackend(
                "/v1/Dispatcher.RouteStats",
                args,
                new RouteStatsListenerWrapper(listener)
                );
    }

    //-- args {{{

    public static final class RouteStatsArgs {
        public List<String> ids;

        public RouteStatsArgs(List<String> ids) {
            this.ids = ids;
        }

        public RouteStatsArgs(String id) {
            this.ids = new ArrayList<String>();
            this.ids.add(id);
        }
    }

    // }}}

    //-- listener {{{

    public static interface RouteStatsListener extends CmdListener {
        public void onResponse(RouteStatsResponse response);
    }

    public static class RouteStatsAdapter extends CmdAdapter implements RouteStatsListener {
        @Override
        public void onResponse(RouteStatsResponse response) {}
    }

    public static class RouteStatsListenerWrapper extends CmdListenerWrapper {

        /*
         * NOTE: hides the `CmdListenerWrapper.listener` field
         */
        RouteStatsListener listener;

        RouteStatsListenerWrapper(RouteStatsListener listener) {
            this.listener = listener;

            /*
             * Since `listener` field hides the one of superclass, we need
             * to set the superclass' field explicitly
             */
            super.listener = listener;
        }

        @Override
        protected void onResponseGeneric(ObjectMapper mapper, String respStr) throws IOException {
            this.listener.onResponse(
                    mapper.readValue(
                        respStr, DispatcherService.RouteStatsResponse.class
                        )
                    );
        }
    }

    // }}}

    //-- response {{{

    public static final class RouteStatsResponse extends HashMap<String, RouteStatsResponseItem> {
        static final long serialVersionUID = 1;
    }

    public static final class RouteStatsResponseItem {
        public List<String> channels;
        public double created;
        public double numSent;
        public double lastUsed;
    }

    // }}}

    // }}}

}

