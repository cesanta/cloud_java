
package com.cesanta.cloud;

// GENERATED FILE DO NOT EDIT
// This file is automatically generated with clubbygen.

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
 * A workspace is a place where the user stores her code. The Cloud IDE and Build services operate on workspaces. The actual content of the workspace is stored in the blobstore. The Workspace service provides operation for creating, listing and downloading workspaces, which are the core operations that an IDE an a build worker need.
 */
public final class WorkspaceService {

    private final Clubby clubby;
    private ClubbyOptions defaultOpts;

    public static WorkspaceService createInstance(Clubby clubby) {
        return new WorkspaceService(clubby);
    }

    private WorkspaceService(Clubby clubby) {
        this.clubby = clubby;
        this.defaultOpts = clubby.getOptions();
    }


    //-- Create {{{

    /**
     * Create new workspace filled with a skeleton project, or cloned from existing workspace
     *
     * @param opts
     *      Options instance which will override current default options. If
     *      there is a need to override defaults, use {@link
     *      WorkspaceService#getOptions() getOptions()} to get current defaults, and then
     *      modify received options object in some way.
     */
    public void create(
            WorkspaceService.CreateArgs args,
            CmdListener<WorkspaceService.CreateResponse> listener,
            ClubbyOptions opts
            ) {
        clubby.callBackend(
                "/v1/Workspace.Create",
                args,
                listener,
                WorkspaceService.CreateResponse.class,
                opts
                );
    }

    /**
     * Create new workspace filled with a skeleton project, or cloned from existing workspace
     */
    public void create(
            WorkspaceService.CreateArgs args,
            CmdListener<WorkspaceService.CreateResponse> listener
            ) {
        create(args, listener, defaultOpts);
    }

    //-- args {{{

    /**
     * Arguments for the {@link com.cesanta.cloud.WorkspaceService#create create} method.
     */
    public static final class CreateArgs  {

        /**
         * Optionally, description of the workspace to clone from
         */
        @JsonProperty("cloneFrom")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private CreateArgsCloneFrom cloneFrom = new CreateArgsCloneFrom();

        /**
         * Optional ID of the workspace. Must be unique within a project. Useful to create well known workspaces.
         */
        @JsonProperty("id")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private String id;

        /**
         * Project name
         */
        @JsonProperty("project")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private String project;

        /**
         * optional skeleton template
         */
        @JsonProperty("template")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private String template;


        /**
         * Set optionally, description of the workspace to clone from
         */
        public CreateArgs cloneFrom(CreateArgsCloneFrom cloneFrom) {
            this.cloneFrom = cloneFrom;
            return this;
        }

        /**
         * Set optional ID of the workspace. Must be unique within a project. Useful to create well known workspaces.
         */
        public CreateArgs id(String id) {
            this.id = id;
            return this;
        }

        /**
         * Set project name
         */
        public CreateArgs project(String project) {
            this.project = project;
            return this;
        }

        /**
         * Set optional skeleton template
         */
        public CreateArgs template(String template) {
            this.template = template;
            return this;
        }

    }


    public static final class CreateArgsCloneFrom  {

        /**
         * ID of the workspace in the source project to clone
         */
        @JsonProperty("id")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private String id;

        /**
         * Name of the project to clone workspace from
         */
        @JsonProperty("project")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private String project;


        /**
         * Set ID of the workspace in the source project to clone
         */
        public CreateArgsCloneFrom id(String id) {
            this.id = id;
            return this;
        }

        /**
         * Set name of the project to clone workspace from
         */
        public CreateArgsCloneFrom project(String project) {
            this.project = project;
            return this;
        }

    }


    // }}}

    //-- response {{{

    /**
     * Response of the {@link com.cesanta.cloud.WorkspaceService#create create} method.
     */
    public static final class CreateResponse extends ArrayList<String> {

        static final long serialVersionUID = 1;


    }


    // }}}

    // }}}

    //-- Delete {{{

    /**
     * Delete a workspace.
     *
     * @param opts
     *      Options instance which will override current default options. If
     *      there is a need to override defaults, use {@link
     *      WorkspaceService#getOptions() getOptions()} to get current defaults, and then
     *      modify received options object in some way.
     */
    public void delete(
            WorkspaceService.DeleteArgs args,
            CmdListener<WorkspaceService.DeleteResponse> listener,
            ClubbyOptions opts
            ) {
        clubby.callBackend(
                "/v1/Workspace.Delete",
                args,
                listener,
                WorkspaceService.DeleteResponse.class,
                opts
                );
    }

    /**
     * Delete a workspace.
     */
    public void delete(
            WorkspaceService.DeleteArgs args,
            CmdListener<WorkspaceService.DeleteResponse> listener
            ) {
        delete(args, listener, defaultOpts);
    }

    //-- args {{{

    /**
     * Arguments for the {@link com.cesanta.cloud.WorkspaceService#delete delete} method.
     */
    public static final class DeleteArgs  {

        /**
         * ID of the workspace in the source project to delete
         */
        @JsonProperty("id")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private String id;

        /**
         * Project name to delete the workspace from
         */
        @JsonProperty("project")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private String project;


        /**
         * Set ID of the workspace in the source project to delete
         */
        public DeleteArgs id(String id) {
            this.id = id;
            return this;
        }

        /**
         * Set project name to delete the workspace from
         */
        public DeleteArgs project(String project) {
            this.project = project;
            return this;
        }

    }


    // }}}

    //-- response {{{

    /**
     * Response of the {@link com.cesanta.cloud.WorkspaceService#delete delete} method.
     */
    public static final class DeleteResponse  {


    }


    // }}}

    // }}}

    //-- Download {{{

    /**
     * Pack the workspace (or a workspace subdirectory) in a zip and provide the raw bytes
     *
     * @param opts
     *      Options instance which will override current default options. If
     *      there is a need to override defaults, use {@link
     *      WorkspaceService#getOptions() getOptions()} to get current defaults, and then
     *      modify received options object in some way.
     */
    public void download(
            WorkspaceService.DownloadArgs args,
            CmdListener<Object> listener,
            ClubbyOptions opts
            ) {
        clubby.callBackend(
                "/v1/Workspace.Download",
                args,
                listener,
                Object.class,
                opts
                );
    }

    /**
     * Pack the workspace (or a workspace subdirectory) in a zip and provide the raw bytes
     */
    public void download(
            WorkspaceService.DownloadArgs args,
            CmdListener<Object> listener
            ) {
        download(args, listener, defaultOpts);
    }

    //-- args {{{

    /**
     * Arguments for the {@link com.cesanta.cloud.WorkspaceService#download download} method.
     */
    public static final class DownloadArgs  {

        @JsonProperty("path")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private List<String> path = new ArrayList<String>();


        /**
         * Add an item to the path
         */
        public DownloadArgs path(String path) {
            this.path.add(path);
            return this;
        }

    }


    // }}}

    //-- response {{{

    // }}}

    // }}}

    //-- List {{{

    /**
     * List workspaces
     *
     * @param opts
     *      Options instance which will override current default options. If
     *      there is a need to override defaults, use {@link
     *      WorkspaceService#getOptions() getOptions()} to get current defaults, and then
     *      modify received options object in some way.
     */
    public void list(
            WorkspaceService.ListArgs args,
            CmdListener<WorkspaceService.ListResponse> listener,
            ClubbyOptions opts
            ) {
        clubby.callBackend(
                "/v1/Workspace.List",
                args,
                listener,
                WorkspaceService.ListResponse.class,
                opts
                );
    }

    /**
     * List workspaces
     */
    public void list(
            WorkspaceService.ListArgs args,
            CmdListener<WorkspaceService.ListResponse> listener
            ) {
        list(args, listener, defaultOpts);
    }

    //-- args {{{

    /**
     * Arguments for the {@link com.cesanta.cloud.WorkspaceService#list list} method.
     */
    public static final class ListArgs  {

        @JsonProperty("filter")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private ListArgsFilter filter = new ListArgsFilter();


        /**
         * Set filter
         */
        public ListArgs filter(ListArgsFilter filter) {
            this.filter = filter;
            return this;
        }

    }


    public static final class ListArgsFilter  {

        /**
         * List only builds matching workspaces belonging to a given project name. Regardless of this filter, the result will only contain workspaces visible to the caller.
         */
        @JsonProperty("project")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private String project;


        /**
         * Set list only builds matching workspaces belonging to a given project name. Regardless of this filter, the result will only contain workspaces visible to the caller.
         */
        public ListArgsFilter project(String project) {
            this.project = project;
            return this;
        }

    }


    // }}}

    //-- response {{{

    /**
     * Response of the {@link com.cesanta.cloud.WorkspaceService#list list} method.
     */
    public static final class ListResponse extends ArrayList<ListResponseItem> {

        static final long serialVersionUID = 1;


    }


    public static final class ListResponseItem  {

        /**
         * Workspace path
         */
        @JsonProperty("path")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        public List<String> path;


    }


    // }}}

    // }}}

    //-- ListTemplates {{{

    /**
     * List templates. All templates visible to the given caller will be listed
     *
     * @param opts
     *      Options instance which will override current default options. If
     *      there is a need to override defaults, use {@link
     *      WorkspaceService#getOptions() getOptions()} to get current defaults, and then
     *      modify received options object in some way.
     */
    public void listTemplates(
            WorkspaceService.ListTemplatesArgs args,
            CmdListener<WorkspaceService.ListTemplatesResponse> listener,
            ClubbyOptions opts
            ) {
        clubby.callBackend(
                "/v1/Workspace.ListTemplates",
                args,
                listener,
                WorkspaceService.ListTemplatesResponse.class,
                opts
                );
    }

    /**
     * List templates. All templates visible to the given caller will be listed
     */
    public void listTemplates(
            WorkspaceService.ListTemplatesArgs args,
            CmdListener<WorkspaceService.ListTemplatesResponse> listener
            ) {
        listTemplates(args, listener, defaultOpts);
    }

    //-- args {{{

    /**
     * Arguments for the {@link com.cesanta.cloud.WorkspaceService#listTemplates listTemplates} method.
     */
    public static final class ListTemplatesArgs  {


    }


    // }}}

    //-- response {{{

    /**
     * Response of the {@link com.cesanta.cloud.WorkspaceService#listTemplates listTemplates} method.
     */
    public static final class ListTemplatesResponse extends ArrayList<String> {

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

