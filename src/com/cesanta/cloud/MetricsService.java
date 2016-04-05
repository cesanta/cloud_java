
package com.cesanta.cloud;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cesanta.clubby.lib.Clubby;
import com.cesanta.clubby.lib.CmdAdapter;
import com.cesanta.clubby.lib.CmdListener;
import com.cesanta.clubby.lib.CmdListenerWrapper;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class MetricsService {

    private final Clubby clubby;

    public static MetricsService createInstance(Clubby clubby) {
        return new MetricsService(clubby);
    }

    private MetricsService(Clubby clubby) {
        this.clubby = clubby;
    }

    //-- Publish {{{

    public void publish(PublishArgs args, PublishListener listener) {
        clubby.call(
                "/v1/Metrics.Publish",
                args,
                new PublishListenerWrapper(listener)
                );
    }

    //-- args {{{

    public static final class PublishArgs {
        @JsonInclude(JsonInclude.Include.NON_NULL)
        public List<PublishArgsVar> vars = new ArrayList<PublishArgsVar>();

        @JsonInclude(JsonInclude.Include.NON_NULL)
        public Integer timestamp;

        public PublishArgs var(PublishArgsVar var) {
            this.vars.add(var);
            return this;
        }

        public PublishArgs timestamp(int timestamp) {
            this.timestamp = timestamp;
            return this;
        }
    }

    @JsonFormat(shape = JsonFormat.Shape.ARRAY)
    public static final class PublishArgsVar {

        @JsonProperty("0")
        public PublishArgsVarFirst first;

        @JsonProperty("1")
        public double second;

        public PublishArgsVar(PublishArgsVarFirst first, double second) {
            this.first = first;
            this.second = second;
        }
    }

    public static final class PublishArgsVarFirst extends HashMap<String, String> {
        static final long serialVersionUID = 1;

        public PublishArgsVarFirst(String __name__) {
            this.put("__name__", __name__);
        }

        public PublishArgsVarFirst add(String key, String value) {
            super.put(key, value);
            return this;
        }
    }

    // }}}

    //-- listener {{{

    public static interface PublishListener extends CmdListener {
        public void onResponse(PublishResponse response);
    }

    public static class PublishAdapter extends CmdAdapter implements PublishListener {
        @Override
        public void onResponse(PublishResponse response) {}
    }

    public static class PublishListenerWrapper extends CmdListenerWrapper {

        /*
         * NOTE: hides the `CmdListenerWrapper.listener` field
         */
        PublishListener listener;

        PublishListenerWrapper(PublishListener listener) {
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
                        respStr, MetricsService.PublishResponse.class
                        )
                    );
        }
    }

    // }}}

    //-- response {{{

    public static final class PublishResponse {
    }

    // }}}

    // }}}
}

