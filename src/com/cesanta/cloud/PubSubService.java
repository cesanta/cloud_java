
package com.cesanta.cloud;

// GENERATED FILE DO NOT EDIT
// This file is automatically generated with clubbygen.

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import com.cesanta.clubby.lib.Clubby;
import com.cesanta.clubby.lib.CmdListener;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * PubSub service.
 */
public final class PubSubService {

    private final Clubby clubby;

    public static PubSubService createInstance(Clubby clubby) {
        return new PubSubService(clubby);
    }

    private PubSubService(Clubby clubby) {
        this.clubby = clubby;
    }


    //-- Ack {{{

    /**
     * Acknowledge one or more messages.
     */
    public void ack(
            PubSubService.AckArgs args,
            CmdListener<PubSubService.AckResponse> listener
            ) {
        clubby.callBackend(
                "/v1/PubSub.Ack",
                args,
                listener,
                PubSubService.AckResponse.class
                );
    }

    //-- args {{{

    /**
     * Arguments for the {@link com.cesanta.cloud.PubSubService#ack ack} method.
     */
    public static final class AckArgs  {

        /**
         * List of message IDs to acknowledge.
         */
        @JsonProperty("ids")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private List<String> ids = new ArrayList<String>();

        /**
         * Name of the subscription.
         */
        @JsonProperty("subscription")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private String subscription;


        /**
         * Add an item to the list of message IDs to acknowledge.
         */
        public AckArgs id(String id) {
            this.ids.add(id);
            return this;
        }

        /**
         * Set name of the subscription.
         */
        public AckArgs subscription(String subscription) {
            this.subscription = subscription;
            return this;
        }

    }


    // }}}

    //-- response {{{

    /**
     * Response of the {@link com.cesanta.cloud.PubSubService#ack ack} method.
     */
    public static final class AckResponse  {


    }


    // }}}

    // }}}

    //-- CreateSubscription {{{

    /**
     * Creates a new subscription to a given topic. If messages are not acknowledged in `deadline` seconds they will be resent.
     */
    public void createSubscription(
            PubSubService.CreateSubscriptionArgs args,
            CmdListener<PubSubService.CreateSubscriptionResponse> listener
            ) {
        clubby.callBackend(
                "/v1/PubSub.CreateSubscription",
                args,
                listener,
                PubSubService.CreateSubscriptionResponse.class
                );
    }

    //-- args {{{

    /**
     * Arguments for the {@link com.cesanta.cloud.PubSubService#createSubscription createSubscription} method.
     */
    public static final class CreateSubscriptionArgs  {

        /**
         * Deadline in seconds for message delivery.
         */
        @JsonProperty("deadline")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private Double deadline;

        /**
         * Name of subscription.
         */
        @JsonProperty("name")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private String name;

        /**
         * Name of the topic.
         */
        @JsonProperty("topic")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private String topic;


        /**
         * Set deadline in seconds for message delivery.
         */
        public CreateSubscriptionArgs deadline(double deadline) {
            this.deadline = deadline;
            return this;
        }

        /**
         * Set name of subscription.
         */
        public CreateSubscriptionArgs name(String name) {
            this.name = name;
            return this;
        }

        /**
         * Set name of the topic.
         */
        public CreateSubscriptionArgs topic(String topic) {
            this.topic = topic;
            return this;
        }

    }


    // }}}

    //-- response {{{

    /**
     * Response of the {@link com.cesanta.cloud.PubSubService#createSubscription createSubscription} method.
     */
    public static final class CreateSubscriptionResponse  {


    }


    // }}}

    // }}}

    //-- CreateTopic {{{

    /**
     * Creates a new topic.
     */
    public void createTopic(
            PubSubService.CreateTopicArgs args,
            CmdListener<PubSubService.CreateTopicResponse> listener
            ) {
        clubby.callBackend(
                "/v1/PubSub.CreateTopic",
                args,
                listener,
                PubSubService.CreateTopicResponse.class
                );
    }

    //-- args {{{

    /**
     * Arguments for the {@link com.cesanta.cloud.PubSubService#createTopic createTopic} method.
     */
    public static final class CreateTopicArgs  {

        /**
         * Name of the topic.
         */
        @JsonProperty("name")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private String name;


        /**
         * Set name of the topic.
         */
        public CreateTopicArgs name(String name) {
            this.name = name;
            return this;
        }

    }


    // }}}

    //-- response {{{

    /**
     * Response of the {@link com.cesanta.cloud.PubSubService#createTopic createTopic} method.
     */
    public static final class CreateTopicResponse  {


    }


    // }}}

    // }}}

    //-- DeleteSubscription {{{

    /**
     * Deletes a new subscription.
     */
    public void deleteSubscription(
            PubSubService.DeleteSubscriptionArgs args,
            CmdListener<PubSubService.DeleteSubscriptionResponse> listener
            ) {
        clubby.callBackend(
                "/v1/PubSub.DeleteSubscription",
                args,
                listener,
                PubSubService.DeleteSubscriptionResponse.class
                );
    }

    //-- args {{{

    /**
     * Arguments for the {@link com.cesanta.cloud.PubSubService#deleteSubscription deleteSubscription} method.
     */
    public static final class DeleteSubscriptionArgs  {

        /**
         * Name of the subscription.
         */
        @JsonProperty("name")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private String name;


        /**
         * Set name of the subscription.
         */
        public DeleteSubscriptionArgs name(String name) {
            this.name = name;
            return this;
        }

    }


    // }}}

    //-- response {{{

    /**
     * Response of the {@link com.cesanta.cloud.PubSubService#deleteSubscription deleteSubscription} method.
     */
    public static final class DeleteSubscriptionResponse  {


    }


    // }}}

    // }}}

    //-- DeleteTopic {{{

    /**
     * Deletes a topic.
     */
    public void deleteTopic(
            PubSubService.DeleteTopicArgs args,
            CmdListener<PubSubService.DeleteTopicResponse> listener
            ) {
        clubby.callBackend(
                "/v1/PubSub.DeleteTopic",
                args,
                listener,
                PubSubService.DeleteTopicResponse.class
                );
    }

    //-- args {{{

    /**
     * Arguments for the {@link com.cesanta.cloud.PubSubService#deleteTopic deleteTopic} method.
     */
    public static final class DeleteTopicArgs  {

        /**
         * Name of the topic.
         */
        @JsonProperty("name")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private String name;


        /**
         * Set name of the topic.
         */
        public DeleteTopicArgs name(String name) {
            this.name = name;
            return this;
        }

    }


    // }}}

    //-- response {{{

    /**
     * Response of the {@link com.cesanta.cloud.PubSubService#deleteTopic deleteTopic} method.
     */
    public static final class DeleteTopicResponse  {


    }


    // }}}

    // }}}

    //-- ExtendDeadline {{{

    /**
     * Extend ack deadline for one or more messages. The new deadline is measured relative the this command. The deadline, measured in seconds, must be >= 0.
     */
    public void extendDeadline(
            PubSubService.ExtendDeadlineArgs args,
            CmdListener<PubSubService.ExtendDeadlineResponse> listener
            ) {
        clubby.callBackend(
                "/v1/PubSub.ExtendDeadline",
                args,
                listener,
                PubSubService.ExtendDeadlineResponse.class
                );
    }

    //-- args {{{

    /**
     * Arguments for the {@link com.cesanta.cloud.PubSubService#extendDeadline extendDeadline} method.
     */
    public static final class ExtendDeadlineArgs  {

        /**
         * Number of seconds since now for the new deadline.
         */
        @JsonProperty("deadline")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private Double deadline;

        /**
         * List of message IDs to extend deadline for.
         */
        @JsonProperty("ids")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private List<String> ids = new ArrayList<String>();

        /**
         * Name of the subscription.
         */
        @JsonProperty("subscription")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private String subscription;


        /**
         * Set number of seconds since now for the new deadline.
         */
        public ExtendDeadlineArgs deadline(double deadline) {
            this.deadline = deadline;
            return this;
        }

        /**
         * Add an item to the list of message IDs to extend deadline for.
         */
        public ExtendDeadlineArgs id(String id) {
            this.ids.add(id);
            return this;
        }

        /**
         * Set name of the subscription.
         */
        public ExtendDeadlineArgs subscription(String subscription) {
            this.subscription = subscription;
            return this;
        }

    }


    // }}}

    //-- response {{{

    /**
     * Response of the {@link com.cesanta.cloud.PubSubService#extendDeadline extendDeadline} method.
     */
    public static final class ExtendDeadlineResponse  {


    }


    // }}}

    // }}}

    //-- Publish {{{

    /**
     * Publish a message to a topic.
     */
    public void publish(
            PubSubService.PublishArgs args,
            CmdListener<PubSubService.PublishResponse> listener
            ) {
        clubby.callBackend(
                "/v1/PubSub.Publish",
                args,
                listener,
                PubSubService.PublishResponse.class
                );
    }

    //-- args {{{

    /**
     * Arguments for the {@link com.cesanta.cloud.PubSubService#publish publish} method.
     */
    public static final class PublishArgs  {

        /**
         * Message to publish.
         */
        @JsonProperty("data")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private Object data = null;

        /**
         * Name of the topic.
         */
        @JsonProperty("topic")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private String topic;


        /**
         * Set message to publish.
         */
        public PublishArgs data(Object data) {
            this.data = data;
            return this;
        }

        /**
         * Set name of the topic.
         */
        public PublishArgs topic(String topic) {
            this.topic = topic;
            return this;
        }

    }


    // }}}

    //-- response {{{

    /**
     * Response of the {@link com.cesanta.cloud.PubSubService#publish publish} method.
     */
    public static final class PublishResponse  {


    }


    // }}}

    // }}}

    //-- Pull {{{

    /**
     * Pull messages from a subscription.
     */
    public void pull(
            PubSubService.PullArgs args,
            CmdListener<PubSubService.PullResponse> listener
            ) {
        clubby.callBackend(
                "/v1/PubSub.Pull",
                args,
                listener,
                PubSubService.PullResponse.class
                );
    }

    //-- args {{{

    /**
     * Arguments for the {@link com.cesanta.cloud.PubSubService#pull pull} method.
     */
    public static final class PullArgs  {

        /**
         * Name of the subscription.
         */
        @JsonProperty("subscription")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private String subscription;


        /**
         * Set name of the subscription.
         */
        public PullArgs subscription(String subscription) {
            this.subscription = subscription;
            return this;
        }

    }


    // }}}

    //-- response {{{

    /**
     * Response of the {@link com.cesanta.cloud.PubSubService#pull pull} method.
     */
    public static final class PullResponse extends ArrayList<PullResponseItem> {

        static final long serialVersionUID = 1;


    }


    public static final class PullResponseItem  {

        @JsonProperty("ackID")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        public String ackID;

        @JsonProperty("message")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        public PullResponseItemMessage message;


    }


    public static final class PullResponseItemMessage  {

        @JsonProperty("data")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        public Object data = null;


    }


    // }}}

    // }}}


}

