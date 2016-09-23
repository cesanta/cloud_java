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
 * AuthToken service allows to manipulate per-user auth tokens given out to 3rd-party apps.
 */
public final class AuthTokenService {

    private final Clubby clubby;
    private ClubbyOptions defaultOpts;

    public static AuthTokenService createInstance(Clubby clubby) {
        return new AuthTokenService(clubby);
    }

    private AuthTokenService(Clubby clubby) {
        this.clubby = clubby;
        this.defaultOpts = clubby.getOptions();
    }


    //-- Generate {{{

    /**
     * Returns auth token for the given app.
     *
     * @param opts
     *      Options instance which will override current default options. If
     *      there is a need to override defaults, use {@link
     *      AuthTokenService#getOptions() getOptions()} to get current defaults, and then
     *      modify received options object in some way.
     */
    public void generate(
            AuthTokenService.GenerateArgs args,
            CmdListener<AuthTokenService.GenerateResponse> listener,
            ClubbyOptions opts
            ) {
        clubby.callBackend(
                "/v1/AuthToken.Generate",
                args,
                listener,
                AuthTokenService.GenerateResponse.class,
                opts
                );
    }

    /**
     * Returns auth token for the given app.
     */
    public void generate(
            AuthTokenService.GenerateArgs args,
            CmdListener<AuthTokenService.GenerateResponse> listener
            ) {
        generate(args, listener, defaultOpts);
    }

    //-- args {{{

    /**
     * Arguments for the {@link com.cesanta.cloud.AuthTokenService#generate generate} method.
     */
    public static final class GenerateArgs  {

        /**
         * Hostname of the app.
         */
        @JsonProperty("host")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private String host;


        /**
         * Set hostname of the app.
         */
        public GenerateArgs host(String host) {
            this.host = host;
            return this;
        }

    }


    // }}}

    //-- response {{{

    public static final class GenerateResponse  {

        @JsonProperty("token")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        public String token;


    }


    // }}}

    // }}}

    //-- Get {{{

    /**
     * Returns auth token for the given app.
     *
     * @param opts
     *      Options instance which will override current default options. If
     *      there is a need to override defaults, use {@link
     *      AuthTokenService#getOptions() getOptions()} to get current defaults, and then
     *      modify received options object in some way.
     */
    public void get(
            AuthTokenService.GetArgs args,
            CmdListener<AuthTokenService.GetResponse> listener,
            ClubbyOptions opts
            ) {
        clubby.callBackend(
                "/v1/AuthToken.Get",
                args,
                listener,
                AuthTokenService.GetResponse.class,
                opts
                );
    }

    /**
     * Returns auth token for the given app.
     */
    public void get(
            AuthTokenService.GetArgs args,
            CmdListener<AuthTokenService.GetResponse> listener
            ) {
        get(args, listener, defaultOpts);
    }

    //-- args {{{

    /**
     * Arguments for the {@link com.cesanta.cloud.AuthTokenService#get get} method.
     */
    public static final class GetArgs  {

        /**
         * Hostname of the app.
         */
        @JsonProperty("host")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private String host;


        /**
         * Set hostname of the app.
         */
        public GetArgs host(String host) {
            this.host = host;
            return this;
        }

    }


    // }}}

    //-- response {{{

    public static final class GetResponse  {

        /**
         * `true` if token for the app was generated previously.
         */
        @JsonProperty("exist")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        public Boolean exist;

        /**
         * Token value. Not present if `exist` is `false`.
         */
        @JsonProperty("token")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        public String token;


    }


    // }}}

    // }}}

    //-- List {{{

    /**
     * Returns the list of apps for which tokens were generated.
     *
     * @param opts
     *      Options instance which will override current default options. If
     *      there is a need to override defaults, use {@link
     *      AuthTokenService#getOptions() getOptions()} to get current defaults, and then
     *      modify received options object in some way.
     */
    public void list(
            AuthTokenService.ListArgs args,
            CmdListener<AuthTokenService.ListResponse> listener,
            ClubbyOptions opts
            ) {
        clubby.callBackend(
                "/v1/AuthToken.List",
                args,
                listener,
                AuthTokenService.ListResponse.class,
                opts
                );
    }

    /**
     * Returns the list of apps for which tokens were generated.
     */
    public void list(
            AuthTokenService.ListArgs args,
            CmdListener<AuthTokenService.ListResponse> listener
            ) {
        list(args, listener, defaultOpts);
    }

    //-- args {{{

    /**
     * Arguments for the {@link com.cesanta.cloud.AuthTokenService#list list} method.
     */
    public static final class ListArgs  {


    }


    // }}}

    //-- response {{{

    /**
     * Response of the {@link com.cesanta.cloud.AuthTokenService#list list} method.
     */
    public static final class ListResponse extends ArrayList<ListResponseItem> {

        static final long serialVersionUID = 1;


    }


    public static final class ListResponseItem  {

        @JsonProperty("host")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        public String host;


    }


    // }}}

    // }}}

    //-- Revoke {{{

    /**
     * Revokes auth token for the given app.
     *
     * @param opts
     *      Options instance which will override current default options. If
     *      there is a need to override defaults, use {@link
     *      AuthTokenService#getOptions() getOptions()} to get current defaults, and then
     *      modify received options object in some way.
     */
    public void revoke(
            AuthTokenService.RevokeArgs args,
            CmdListener<AuthTokenService.RevokeResponse> listener,
            ClubbyOptions opts
            ) {
        clubby.callBackend(
                "/v1/AuthToken.Revoke",
                args,
                listener,
                AuthTokenService.RevokeResponse.class,
                opts
                );
    }

    /**
     * Revokes auth token for the given app.
     */
    public void revoke(
            AuthTokenService.RevokeArgs args,
            CmdListener<AuthTokenService.RevokeResponse> listener
            ) {
        revoke(args, listener, defaultOpts);
    }

    //-- args {{{

    /**
     * Arguments for the {@link com.cesanta.cloud.AuthTokenService#revoke revoke} method.
     */
    public static final class RevokeArgs  {

        /**
         * Hostname of the app.
         */
        @JsonProperty("host")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private String host;


        /**
         * Set hostname of the app.
         */
        public RevokeArgs host(String host) {
            this.host = host;
            return this;
        }

    }


    // }}}

    //-- response {{{

    /**
     * Response of the {@link com.cesanta.cloud.AuthTokenService#revoke revoke} method.
     */
    public static final class RevokeResponse  {


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

