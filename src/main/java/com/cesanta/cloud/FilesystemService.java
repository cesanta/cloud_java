// This is a generated file. Not intended for manual editing.
//
// GENERATED FILE DO NOT EDIT
// This file is automatically generated with clubbygen.
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
 * The FileSystem service exposes a filesystem-like interface for cloud storage. All relative paths are interpreted as path in the home directory of the caller.
 */
public final class FilesystemService {

    private final Clubby clubby;
    private ClubbyOptions defaultOpts;

    public static FilesystemService createInstance(Clubby clubby) {
        return new FilesystemService(clubby);
    }

    private FilesystemService(Clubby clubby) {
        this.clubby = clubby;
        this.defaultOpts = clubby.getOptions();
    }


    //-- Delete {{{

    /**
     * Deletes the given file or directory.

     *
     * @param opts
     *      Options instance which will override current default options. If
     *      there is a need to override defaults, use {@link
     *      FilesystemService#getOptions() getOptions()} to get current defaults, and then
     *      modify received options object in some way.
     */
    public void delete(
            FilesystemService.DeleteArgs args,
            CmdListener<FilesystemService.DeleteResponse> listener,
            ClubbyOptions opts
            ) {
        clubby.callBackend(
                "/v1/Filesystem.Delete",
                args,
                listener,
                FilesystemService.DeleteResponse.class,
                opts
                );
    }

    /**
     * Deletes the given file or directory.

     */
    public void delete(
            FilesystemService.DeleteArgs args,
            CmdListener<FilesystemService.DeleteResponse> listener
            ) {
        delete(args, listener, defaultOpts);
    }

    //-- args {{{

    /**
     * Arguments for the {@link com.cesanta.cloud.FilesystemService#delete delete} method.
     */
    public static final class DeleteArgs  {

        /**
         * File path.
         */
        @JsonProperty("path")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private String path;

        /**
         * If path points to a directory, delete its contents recursively.
         */
        @JsonProperty("recursive")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private Boolean recursive;


        /**
         * Set file path.
         */
        public DeleteArgs path(String path) {
            this.path = path;
            return this;
        }

        /**
         * Set if path points to a directory, delete its contents recursively.
         */
        public DeleteArgs recursive(boolean recursive) {
            this.recursive = recursive;
            return this;
        }

    }


    // }}}

    //-- response {{{

    /**
     * Response of the {@link com.cesanta.cloud.FilesystemService#delete delete} method.
     */
    public static final class DeleteResponse  {


    }


    // }}}

    // }}}

    //-- List {{{

    /**
     * Lists a directory.

     *
     * @param opts
     *      Options instance which will override current default options. If
     *      there is a need to override defaults, use {@link
     *      FilesystemService#getOptions() getOptions()} to get current defaults, and then
     *      modify received options object in some way.
     */
    public void list(
            FilesystemService.ListArgs args,
            CmdListener<FilesystemService.ListResponse> listener,
            ClubbyOptions opts
            ) {
        clubby.callBackend(
                "/v1/Filesystem.List",
                args,
                listener,
                FilesystemService.ListResponse.class,
                opts
                );
    }

    /**
     * Lists a directory.

     */
    public void list(
            FilesystemService.ListArgs args,
            CmdListener<FilesystemService.ListResponse> listener
            ) {
        list(args, listener, defaultOpts);
    }

    //-- args {{{

    /**
     * Arguments for the {@link com.cesanta.cloud.FilesystemService#list list} method.
     */
    public static final class ListArgs  {

        /**
         * Directory path.
         */
        @JsonProperty("path")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private String path;


        /**
         * Set directory path.
         */
        public ListArgs path(String path) {
            this.path = path;
            return this;
        }

    }


    // }}}

    //-- response {{{

    /**
     * Response of the {@link com.cesanta.cloud.FilesystemService#list list} method.
     */
    public static final class ListResponse extends ArrayList<String> {

        static final long serialVersionUID = 1;


    }


    // }}}

    // }}}

    //-- Mkdir {{{

    /**
     * Creates a directory.

     *
     * @param opts
     *      Options instance which will override current default options. If
     *      there is a need to override defaults, use {@link
     *      FilesystemService#getOptions() getOptions()} to get current defaults, and then
     *      modify received options object in some way.
     */
    public void mkdir(
            FilesystemService.MkdirArgs args,
            CmdListener<FilesystemService.MkdirResponse> listener,
            ClubbyOptions opts
            ) {
        clubby.callBackend(
                "/v1/Filesystem.Mkdir",
                args,
                listener,
                FilesystemService.MkdirResponse.class,
                opts
                );
    }

    /**
     * Creates a directory.

     */
    public void mkdir(
            FilesystemService.MkdirArgs args,
            CmdListener<FilesystemService.MkdirResponse> listener
            ) {
        mkdir(args, listener, defaultOpts);
    }

    //-- args {{{

    /**
     * Arguments for the {@link com.cesanta.cloud.FilesystemService#mkdir mkdir} method.
     */
    public static final class MkdirArgs  {

        /**
         * Create intermediate directories as required. Default false.
         */
        @JsonProperty("create_intermediate_dirs")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private Boolean create_intermediate_dirs;

        /**
         * Directory path.
         */
        @JsonProperty("path")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private String path;


        /**
         * Set create intermediate directories as required. Default false.
         */
        public MkdirArgs create_intermediate_dirs(boolean create_intermediate_dirs) {
            this.create_intermediate_dirs = create_intermediate_dirs;
            return this;
        }

        /**
         * Set directory path.
         */
        public MkdirArgs path(String path) {
            this.path = path;
            return this;
        }

    }


    // }}}

    //-- response {{{

    /**
     * Response of the {@link com.cesanta.cloud.FilesystemService#mkdir mkdir} method.
     */
    public static final class MkdirResponse  {


    }


    // }}}

    // }}}

    //-- Read {{{

    /**
     * Reads a file.

     *
     * @param opts
     *      Options instance which will override current default options. If
     *      there is a need to override defaults, use {@link
     *      FilesystemService#getOptions() getOptions()} to get current defaults, and then
     *      modify received options object in some way.
     */
    public void read(
            FilesystemService.ReadArgs args,
            CmdListener<FilesystemService.ReadResponse> listener,
            ClubbyOptions opts
            ) {
        clubby.callBackend(
                "/v1/Filesystem.Read",
                args,
                listener,
                FilesystemService.ReadResponse.class,
                opts
                );
    }

    /**
     * Reads a file.

     */
    public void read(
            FilesystemService.ReadArgs args,
            CmdListener<FilesystemService.ReadResponse> listener
            ) {
        read(args, listener, defaultOpts);
    }

    //-- args {{{

    /**
     * Arguments for the {@link com.cesanta.cloud.FilesystemService#read read} method.
     */
    public static final class ReadArgs  {

        /**
         * Result encoding. Valid values are:
  `none`: the data will be returned as a string, with best effort quoting
  of binary data as permitted by the JSON standard.
  `base64`: the data will be encoded with base64, as defined in RFC 4648.

  If omitted `none` is assumed.

         */
        @JsonProperty("enc")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private String enc;

        /**
         * Length of chunk to read. If omitted, all available data until the EOF
will be read. If (offset + len) is larger than the file size, no
error will be returned, and only available data until the EOF will be
read.

         */
        @JsonProperty("len")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private Long len;

        /**
         * Offset from the beginning of the file to start reading from.
If omitted, 0 is assumed. If the given offset is larger than the file
size, no error is returned, and the returned data will be null.

         */
        @JsonProperty("offset")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private Long offset;

        /**
         * File path.
         */
        @JsonProperty("path")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private String path;


        /**
         * Set result encoding. Valid values are:
  `none`: the data will be returned as a string, with best effort quoting
  of binary data as permitted by the JSON standard.
  `base64`: the data will be encoded with base64, as defined in RFC 4648.

  If omitted `none` is assumed.

         */
        public ReadArgs enc(String enc) {
            this.enc = enc;
            return this;
        }

        /**
         * Set length of chunk to read. If omitted, all available data until the EOF
will be read. If (offset + len) is larger than the file size, no
error will be returned, and only available data until the EOF will be
read.

         */
        public ReadArgs len(long len) {
            this.len = len;
            return this;
        }

        /**
         * Set offset from the beginning of the file to start reading from.
If omitted, 0 is assumed. If the given offset is larger than the file
size, no error is returned, and the returned data will be null.

         */
        public ReadArgs offset(long offset) {
            this.offset = offset;
            return this;
        }

        /**
         * Set file path.
         */
        public ReadArgs path(String path) {
            this.path = path;
            return this;
        }

    }


    // }}}

    //-- response {{{

    public static final class ReadResponse  {

        /**
         * Encoded data read from the file.
         */
        @JsonProperty("data")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        public String data;

        /**
         * Number of bytes left in the file past the read chunk of data.
         */
        @JsonProperty("left")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        public Long left;


    }


    // }}}

    // }}}

    //-- Stat {{{

    /**
     * Returns file metadata.

     *
     * @param opts
     *      Options instance which will override current default options. If
     *      there is a need to override defaults, use {@link
     *      FilesystemService#getOptions() getOptions()} to get current defaults, and then
     *      modify received options object in some way.
     */
    public void stat(
            FilesystemService.StatArgs args,
            CmdListener<FilesystemService.StatResponse> listener,
            ClubbyOptions opts
            ) {
        clubby.callBackend(
                "/v1/Filesystem.Stat",
                args,
                listener,
                FilesystemService.StatResponse.class,
                opts
                );
    }

    /**
     * Returns file metadata.

     */
    public void stat(
            FilesystemService.StatArgs args,
            CmdListener<FilesystemService.StatResponse> listener
            ) {
        stat(args, listener, defaultOpts);
    }

    //-- args {{{

    /**
     * Arguments for the {@link com.cesanta.cloud.FilesystemService#stat stat} method.
     */
    public static final class StatArgs  {

        /**
         * File/dir path.
         */
        @JsonProperty("path")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private String path;


        /**
         * Set file/dir path.
         */
        public StatArgs path(String path) {
            this.path = path;
            return this;
        }

    }


    // }}}

    //-- response {{{

    public static final class StatResponse  {

        /**
         * True if a directory.
         */
        @JsonProperty("is_dir")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        public Boolean is_dir;

        /**
         * Size in bytes.
         */
        @JsonProperty("size")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        public Long size;


    }


    // }}}

    // }}}

    //-- Write {{{

    /**
     * Writes a file.

     *
     * @param opts
     *      Options instance which will override current default options. If
     *      there is a need to override defaults, use {@link
     *      FilesystemService#getOptions() getOptions()} to get current defaults, and then
     *      modify received options object in some way.
     */
    public void write(
            FilesystemService.WriteArgs args,
            CmdListener<FilesystemService.WriteResponse> listener,
            ClubbyOptions opts
            ) {
        clubby.callBackend(
                "/v1/Filesystem.Write",
                args,
                listener,
                FilesystemService.WriteResponse.class,
                opts
                );
    }

    /**
     * Writes a file.

     */
    public void write(
            FilesystemService.WriteArgs args,
            CmdListener<FilesystemService.WriteResponse> listener
            ) {
        write(args, listener, defaultOpts);
    }

    //-- args {{{

    /**
     * Arguments for the {@link com.cesanta.cloud.FilesystemService#write write} method.
     */
    public static final class WriteArgs  {

        /**
         * If true, and if the file with the given filename already exists, the
data will be appended to it. Otherwise, the file will be overwritten
or created.

         */
        @JsonProperty("append")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private Boolean append;

        /**
         * Create intermediate directories as required. Default false.
         */
        @JsonProperty("create_intermediate_dirs")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private Boolean create_intermediate_dirs;

        /**
         * File contents.
         */
        @JsonProperty("data")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private String data;

        /**
         * Input encoding. Valid values are:
  `none`: the data will be parsed as a string, with best effort quoting
  of binary data as permitted by the JSON standard.
  `base64`: the data will be parsed as (padded) base64, as defined in RFC 4648.

  If omitted `none` is assumed.

         */
        @JsonProperty("enc")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private String enc;

        /**
         * File path.
         */
        @JsonProperty("path")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private String path;


        /**
         * Set if true, and if the file with the given filename already exists, the
data will be appended to it. Otherwise, the file will be overwritten
or created.

         */
        public WriteArgs append(boolean append) {
            this.append = append;
            return this;
        }

        /**
         * Set create intermediate directories as required. Default false.
         */
        public WriteArgs create_intermediate_dirs(boolean create_intermediate_dirs) {
            this.create_intermediate_dirs = create_intermediate_dirs;
            return this;
        }

        /**
         * Set file contents.
         */
        public WriteArgs data(String data) {
            this.data = data;
            return this;
        }

        /**
         * Set input encoding. Valid values are:
  `none`: the data will be parsed as a string, with best effort quoting
  of binary data as permitted by the JSON standard.
  `base64`: the data will be parsed as (padded) base64, as defined in RFC 4648.

  If omitted `none` is assumed.

         */
        public WriteArgs enc(String enc) {
            this.enc = enc;
            return this;
        }

        /**
         * Set file path.
         */
        public WriteArgs path(String path) {
            this.path = path;
            return this;
        }

    }


    // }}}

    //-- response {{{

    /**
     * Response of the {@link com.cesanta.cloud.FilesystemService#write write} method.
     */
    public static final class WriteResponse  {


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

