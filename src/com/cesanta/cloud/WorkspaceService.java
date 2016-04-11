
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
 * A workspace is a place where the user stores her code. The Cloud IDE and Build services operate on workspaces. The actual content of the workspace is stored in the blobstore. The Workspace service provides operation for creating, listing and downloading workspaces, which are the core operations that an IDE an a build worker need.
 */
public final class WorkspaceService {

    private final Clubby clubby;

    public static WorkspaceService createInstance(Clubby clubby) {
        return new WorkspaceService(clubby);
    }

    private WorkspaceService(Clubby clubby) {
        this.clubby = clubby;
    }


    //-- Create {{{

    /**
     * Create new workspace filled with a skeleton project.
     */
    public void create(
            WorkspaceService.CreateArgs args,
            CmdListener<WorkspaceService.CreateResponse> listener
            ) {
        clubby.callBackend(
                "/v1/Workspace.Create",
                args,
                listener,
                WorkspaceService.CreateResponse.class
                );
    }

    //-- args {{{

    /**
     * Arguments for the {@link com.cesanta.cloud.WorkspaceService#create create} method.
     */
    public static final class CreateArgs  {

        /**
         * Optional ID of the workspace. Must be unique within a project. Useful to create well known workspaces.
         */
        @JsonProperty("id")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private String id;

        /**
         * ID of the project
         */
        @JsonProperty("projectid")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private String projectid;

        /**
         * optional skeleton template
         */
        @JsonProperty("template")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private String template;


        /**
         * Set optional ID of the workspace. Must be unique within a project. Useful to create well known workspaces.
         */
        public CreateArgs id(String id) {
            this.id = id;
            return this;
        }

        /**
         * Set ID of the project
         */
        public CreateArgs projectid(String projectid) {
            this.projectid = projectid;
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
     */
    public void delete(
            WorkspaceService.DeleteArgs args,
            CmdListener<WorkspaceService.DeleteResponse> listener
            ) {
        clubby.callBackend(
                "/v1/Workspace.Delete",
                args,
                listener,
                WorkspaceService.DeleteResponse.class
                );
    }

    //-- args {{{

    /**
     * Arguments for the {@link com.cesanta.cloud.WorkspaceService#delete delete} method.
     */
    public static final class DeleteArgs  {

        @JsonProperty("path")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private List<String> path = new ArrayList<String>();


        /**
         * Add an item to the path
         */
        public DeleteArgs path(String path) {
            this.path.add(path);
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
     * Pack the workspace in a zip and provide the raw bytes
     */
    public void download(
            WorkspaceService.DownloadArgs args,
            CmdListener<Object> listener
            ) {
        clubby.callBackend(
                "/v1/Workspace.Download",
                args,
                listener,
                Object.class
                );
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
     */
    public void list(
            WorkspaceService.ListArgs args,
            CmdListener<WorkspaceService.ListResponse> listener
            ) {
        clubby.callBackend(
                "/v1/Workspace.List",
                args,
                listener,
                WorkspaceService.ListResponse.class
                );
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
         * List only builds matching workspaces belonging to a given project. Regardless of this filter, the result will only contain workspaces visible to the caller.
         */
        @JsonProperty("projectid")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private String projectid;


        /**
         * Set list only builds matching workspaces belonging to a given project. Regardless of this filter, the result will only contain workspaces visible to the caller.
         */
        public ListArgsFilter projectid(String projectid) {
            this.projectid = projectid;
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
     */
    public void listTemplates(
            WorkspaceService.ListTemplatesArgs args,
            CmdListener<WorkspaceService.ListTemplatesResponse> listener
            ) {
        clubby.callBackend(
                "/v1/Workspace.ListTemplates",
                args,
                listener,
                WorkspaceService.ListTemplatesResponse.class
                );
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


}

