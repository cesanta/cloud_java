/*
 * GENERATED FILE DO NOT EDIT
 * This file is automatically generated with miot clubbygen.
 *
 * Copyright (c) 2016 Cesanta Software Limited
 * All rights reserved
 */

package com.cesanta.cloud;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import com.cesanta.clubby.lib.Clubby;
import com.cesanta.clubby.lib.ClubbyOptions;
import com.cesanta.clubby.lib.CmdListener;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Blob service provides basic key-value store. Keys are arrays of strings. First component of the key must be either your ID or ID of a project you have access to.
 */
public final class BlobService {

    private final Clubby clubby;
    private ClubbyOptions defaultOpts;

    public static BlobService createInstance(Clubby clubby) {
        return new BlobService(clubby);
    }

    private BlobService(Clubby clubby) {
        this.clubby = clubby;
        this.defaultOpts = clubby.getOptions();
    }


    //-- Delete {{{

    /**
     * Deletes the given keys.
     *
     * @param opts
     *      Options instance which will override current default options. If
     *      there is a need to override defaults, use {@link
     *      BlobService#getOptions() getOptions()} to get current defaults, and then
     *      modify received options object in some way.
     */
    public void delete(
            BlobService.DeleteArgs args,
            CmdListener<BlobService.DeleteResponse> listener,
            ClubbyOptions opts
            ) {
        clubby.callBackend(
                "/v1/Blob.Delete",
                args,
                listener,
                BlobService.DeleteResponse.class,
                opts
                );
    }

    /**
     * Deletes the given keys.
     */
    public void delete(
            BlobService.DeleteArgs args,
            CmdListener<BlobService.DeleteResponse> listener
            ) {
        delete(args, listener, defaultOpts);
    }

    //-- args {{{

    /**
     * Arguments for the {@link com.cesanta.cloud.BlobService#delete delete} method.
     */
    public static final class DeleteArgs  {

        /**
         * Keys to delete.
         */
        @JsonProperty("keys")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private List<List<String>> keys = new ArrayList<List<String>>();


        /**
         * Add an item to the keys to delete.
         */
        public DeleteArgs key(List<String> key) {
            this.keys.add(key);
            return this;
        }

    }


    // }}}

    //-- response {{{

    /**
     * Response of the {@link com.cesanta.cloud.BlobService#delete delete} method.
     */
    public static final class DeleteResponse  {


    }


    // }}}

    // }}}

    //-- Get {{{

    /**
     * Retrieves data at a given key.

     *
     * @param opts
     *      Options instance which will override current default options. If
     *      there is a need to override defaults, use {@link
     *      BlobService#getOptions() getOptions()} to get current defaults, and then
     *      modify received options object in some way.
     */
    public void get(
            BlobService.GetArgs args,
            CmdListener<Object> listener,
            ClubbyOptions opts
            ) {
        clubby.callBackend(
                "/v1/Blob.Get",
                args,
                listener,
                Object.class,
                opts
                );
    }

    /**
     * Retrieves data at a given key.

     */
    public void get(
            BlobService.GetArgs args,
            CmdListener<Object> listener
            ) {
        get(args, listener, defaultOpts);
    }

    //-- args {{{

    /**
     * Arguments for the {@link com.cesanta.cloud.BlobService#get get} method.
     */
    public static final class GetArgs  {

        /**
         * Key to fetch the value for.
         */
        @JsonProperty("key")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private List<String> key = new ArrayList<String>();


        /**
         * Add an item to the key to fetch the value for.
         */
        public GetArgs key(String key) {
            this.key.add(key);
            return this;
        }

    }


    // }}}

    //-- response {{{

    // }}}

    // }}}

    //-- List {{{

    /**
     * Returns a list of all keys with a given prefix.
Within that prefix, items can be iterated from a specific
start key (inclusive), up to an optional end key (non inclusive).
If inclusive is false (true by default), then the start key is non
inclusive. The result can be limited to a given number of items with
the limit parameter.

     *
     * @param opts
     *      Options instance which will override current default options. If
     *      there is a need to override defaults, use {@link
     *      BlobService#getOptions() getOptions()} to get current defaults, and then
     *      modify received options object in some way.
     */
    public void list(
            BlobService.ListArgs args,
            CmdListener<BlobService.ListResponse> listener,
            ClubbyOptions opts
            ) {
        clubby.callBackend(
                "/v1/Blob.List",
                args,
                listener,
                BlobService.ListResponse.class,
                opts
                );
    }

    /**
     * Returns a list of all keys with a given prefix.
Within that prefix, items can be iterated from a specific
start key (inclusive), up to an optional end key (non inclusive).
If inclusive is false (true by default), then the start key is non
inclusive. The result can be limited to a given number of items with
the limit parameter.

     */
    public void list(
            BlobService.ListArgs args,
            CmdListener<BlobService.ListResponse> listener
            ) {
        list(args, listener, defaultOpts);
    }

    //-- args {{{

    /**
     * Arguments for the {@link com.cesanta.cloud.BlobService#list list} method.
     */
    public static final class ListArgs  {

        /**
         * If set, only keys that compare before this key will be returned.
         */
        @JsonProperty("end")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private List<String> end = new ArrayList<String>();

        /**
         * Set this to `false` to omit key equal to `start` in the result.
         */
        @JsonProperty("inclusive")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private Boolean inclusive;

        /**
         * Maximum number of entries to return.
         */
        @JsonProperty("limit")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private Long limit;

        /**
         * Key prefix (few first components) to list keys under.
         */
        @JsonProperty("prefix")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private List<String> prefix = new ArrayList<String>();

        /**
         * If set, only keys that compare after or equal to this key will be returned.
         */
        @JsonProperty("start")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private List<String> start = new ArrayList<String>();


        /**
         * Add an item to the if set, only keys that compare before this key will be returned.
         */
        public ListArgs end(String end) {
            this.end.add(end);
            return this;
        }

        /**
         * Set set this to `false` to omit key equal to `start` in the result.
         */
        public ListArgs inclusive(boolean inclusive) {
            this.inclusive = inclusive;
            return this;
        }

        /**
         * Set maximum number of entries to return.
         */
        public ListArgs limit(long limit) {
            this.limit = limit;
            return this;
        }

        /**
         * Add an item to the key prefix (few first components) to list keys under.
         */
        public ListArgs prefix(String prefix) {
            this.prefix.add(prefix);
            return this;
        }

        /**
         * Add an item to the if set, only keys that compare after or equal to this key will be returned.
         */
        public ListArgs start(String start) {
            this.start.add(start);
            return this;
        }

    }


    // }}}

    //-- response {{{

    /**
     * Response of the {@link com.cesanta.cloud.BlobService#list list} method.
     */
    public static final class ListResponse extends ArrayList<List<String>> {

        static final long serialVersionUID = 1;


    }


    // }}}

    // }}}

    //-- Set {{{

    /**
     * Stores data at a given key.
If binary flag is set, value must be an array of numbers in 0-255 range.

     *
     * @param opts
     *      Options instance which will override current default options. If
     *      there is a need to override defaults, use {@link
     *      BlobService#getOptions() getOptions()} to get current defaults, and then
     *      modify received options object in some way.
     */
    public void set(
            BlobService.SetArgs args,
            CmdListener<BlobService.SetResponse> listener,
            ClubbyOptions opts
            ) {
        clubby.callBackend(
                "/v1/Blob.Set",
                args,
                listener,
                BlobService.SetResponse.class,
                opts
                );
    }

    /**
     * Stores data at a given key.
If binary flag is set, value must be an array of numbers in 0-255 range.

     */
    public void set(
            BlobService.SetArgs args,
            CmdListener<BlobService.SetResponse> listener
            ) {
        set(args, listener, defaultOpts);
    }

    //-- args {{{

    /**
     * Arguments for the {@link com.cesanta.cloud.BlobService#set set} method.
     */
    public static final class SetArgs  {

        /**
         * If set to `true`, `value` will be stored in a binary form (not JSON). Only works if the value is an array of numbers in 0-255 range, each number is interpreted as a byte value.
         */
        @JsonProperty("binary")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private Boolean binary;

        /**
         * Key to set value for.
         */
        @JsonProperty("key")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private List<String> key = new ArrayList<String>();

        /**
         * Value to store: object, array or a string.
         */
        @JsonProperty("value")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private Object value = null;


        /**
         * Set if set to `true`, `value` will be stored in a binary form (not JSON). Only works if the value is an array of numbers in 0-255 range, each number is interpreted as a byte value.
         */
        public SetArgs binary(boolean binary) {
            this.binary = binary;
            return this;
        }

        /**
         * Add an item to the key to set value for.
         */
        public SetArgs key(String key) {
            this.key.add(key);
            return this;
        }

        /**
         * Set value to store: object, array or a string.
         */
        public SetArgs value(Object value) {
            this.value = value;
            return this;
        }

    }


    // }}}

    //-- response {{{

    /**
     * Response of the {@link com.cesanta.cloud.BlobService#set set} method.
     */
    public static final class SetResponse  {


    }


    // }}}

    // }}}


    public void setDefaultOptions(ClubbyOptions opts) {
        this.defaultOpts = ClubbyOptions.createFrom(opts);
    }

    public ClubbyOptions getOptions() {
        return ClubbyOptions.createFrom(defaultOpts);
    }
}

