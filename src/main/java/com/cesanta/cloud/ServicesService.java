// This is a generated file. Not intended for manual editing.
//
// GENERATED FILE DO NOT EDIT
// This file is automatically generated with miot clubbygen.
//
//
// Copyright (c) 2016 Cesanta Software Limited
// All rights reserved
//

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
 * Services service provides support for introspection.
 */
public final class ServicesService {

    private final Clubby clubby;
    private ClubbyOptions defaultOpts;

    public static ServicesService createInstance(Clubby clubby) {
        return new ServicesService(clubby);
    }

    private ServicesService(Clubby clubby) {
        this.clubby = clubby;
        this.defaultOpts = clubby.getOptions();
    }


    //-- List {{{

    /**
     * Get returns definitions of all services provided by the server.
     *
     * @param opts
     *      Options instance which will override current default options. If
     *      there is a need to override defaults, use {@link
     *      ServicesService#getOptions() getOptions()} to get current defaults, and then
     *      modify received options object in some way.
     */
    public void list(
            ServicesService.ListArgs args,
            CmdListener<ServicesService.ListResponse> listener,
            ClubbyOptions opts
            ) {
        clubby.callBackend(
                "/v1/Services.List",
                args,
                listener,
                ServicesService.ListResponse.class,
                opts
                );
    }

    /**
     * Get returns definitions of all services provided by the server.
     */
    public void list(
            ServicesService.ListArgs args,
            CmdListener<ServicesService.ListResponse> listener
            ) {
        list(args, listener, defaultOpts);
    }

    //-- args {{{

    /**
     * Arguments for the {@link com.cesanta.cloud.ServicesService#list list} method.
     */
    public static final class ListArgs  {


    }


    // }}}

    //-- response {{{

    /**
     * Response of the {@link com.cesanta.cloud.ServicesService#list list} method.
     */
    public static final class ListResponse extends HashMap<String, Object> {

        static final long serialVersionUID = 1;


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

