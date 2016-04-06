
package com.cesanta.cloud;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cesanta.clubby.lib.Clubby;
import com.cesanta.clubby.lib.CmdAdapter;
import com.cesanta.clubby.lib.CmdListener;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

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
        clubby.callBackend(
                "/v1/Metrics.Publish",
                args,
                listener,
                PublishResponse.class
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

    public static interface PublishListener extends CmdListener<PublishResponse> {
    }

    public static class PublishAdapter extends CmdAdapter<PublishResponse> implements PublishListener {
    }

    // }}}

    //-- response {{{

    public static final class PublishResponse {
    }

    // }}}

    // }}}
}

