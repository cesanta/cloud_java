
package com.cesanta.cloud;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cesanta.clubby.lib.Clubby;
import com.cesanta.clubby.lib.CmdAdapter;
import com.cesanta.clubby.lib.CmdListener;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
                listener,
                HelloResponse.class
                );
    }

    //-- args {{{
    public static final class HelloArgs {
    }
    // }}}

    //-- listener {{{

    public static interface HelloListener extends CmdListener<HelloResponse> {
    }

    public static class HelloAdapter extends CmdAdapter<HelloResponse> implements HelloListener {
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
                listener,
                RouteStatsResponse.class
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

    public static interface RouteStatsListener extends CmdListener<RouteStatsResponse> {
    }

    public static class RouteStatsAdapter extends CmdAdapter<RouteStatsResponse> implements RouteStatsListener {
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

