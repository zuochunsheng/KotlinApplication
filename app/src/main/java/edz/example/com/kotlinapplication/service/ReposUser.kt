package edz.example.com.kotlinapplication.service

import com.google.gson.annotations.SerializedName

/**
 * @author： zcs
 * @time：2019/11/7 on 15:42
 * @description：
 */
class ReposUser {

    /**
     * id : 170908616
     * node_id : MDEwOlJlcG9zaXRvcnkxNzA5MDg2MTY=
     * name : .github
     * full_name : google/.github
     * private : false
     * owner : {"login":"google","id":1342004,"node_id":"MDEyOk9yZ2FuaXphdGlvbjEzNDIwMDQ=","avatar_url":"https://avatars1.githubusercontent.com/u/1342004?v=4","gravatar_id":"","url":"https://api.github.com/users/google","html_url":"https://github.com/google","followers_url":"https://api.github.com/users/google/followers","following_url":"https://api.github.com/users/google/following{/other_user}","gists_url":"https://api.github.com/users/google/gists{/gist_id}","starred_url":"https://api.github.com/users/google/starred{/owner}{/repo}","subscriptions_url":"https://api.github.com/users/google/subscriptions","organizations_url":"https://api.github.com/users/google/orgs","repos_url":"https://api.github.com/users/google/repos","events_url":"https://api.github.com/users/google/events{/privacy}","received_events_url":"https://api.github.com/users/google/received_events","type":"Organization","site_admin":false}
     * html_url : https://github.com/google/.github
     * description : default configuration for @google repos
     * fork : false
     * url : https://api.github.com/repos/google/.github
     * forks_url : https://api.github.com/repos/google/.github/forks
     * keys_url : https://api.github.com/repos/google/.github/keys{/key_id}
     * collaborators_url : https://api.github.com/repos/google/.github/collaborators{/collaborator}
     * teams_url : https://api.github.com/repos/google/.github/teams
     * hooks_url : https://api.github.com/repos/google/.github/hooks
     * issue_events_url : https://api.github.com/repos/google/.github/issues/events{/number}
     * events_url : https://api.github.com/repos/google/.github/events
     * assignees_url : https://api.github.com/repos/google/.github/assignees{/user}
     * branches_url : https://api.github.com/repos/google/.github/branches{/branch}
     * tags_url : https://api.github.com/repos/google/.github/tags
     * blobs_url : https://api.github.com/repos/google/.github/git/blobs{/sha}
     * git_tags_url : https://api.github.com/repos/google/.github/git/tags{/sha}
     * git_refs_url : https://api.github.com/repos/google/.github/git/refs{/sha}
     * trees_url : https://api.github.com/repos/google/.github/git/trees{/sha}
     * statuses_url : https://api.github.com/repos/google/.github/statuses/{sha}
     * languages_url : https://api.github.com/repos/google/.github/languages
     * stargazers_url : https://api.github.com/repos/google/.github/stargazers
     * contributors_url : https://api.github.com/repos/google/.github/contributors
     * subscribers_url : https://api.github.com/repos/google/.github/subscribers
     * subscription_url : https://api.github.com/repos/google/.github/subscription
     * commits_url : https://api.github.com/repos/google/.github/commits{/sha}
     * git_commits_url : https://api.github.com/repos/google/.github/git/commits{/sha}
     * comments_url : https://api.github.com/repos/google/.github/comments{/number}
     * issue_comment_url : https://api.github.com/repos/google/.github/issues/comments{/number}
     * contents_url : https://api.github.com/repos/google/.github/contents/{+path}
     * compare_url : https://api.github.com/repos/google/.github/compare/{base}...{head}
     * merges_url : https://api.github.com/repos/google/.github/merges
     * archive_url : https://api.github.com/repos/google/.github/{archive_format}{/ref}
     * downloads_url : https://api.github.com/repos/google/.github/downloads
     * issues_url : https://api.github.com/repos/google/.github/issues{/number}
     * pulls_url : https://api.github.com/repos/google/.github/pulls{/number}
     * milestones_url : https://api.github.com/repos/google/.github/milestones{/number}
     * notifications_url : https://api.github.com/repos/google/.github/notifications{?since,all,participating}
     * labels_url : https://api.github.com/repos/google/.github/labels{/name}
     * releases_url : https://api.github.com/repos/google/.github/releases{/id}
     * deployments_url : https://api.github.com/repos/google/.github/deployments
     * created_at : 2019-02-15T18:14:38Z
     * updated_at : 2019-10-22T08:58:07Z
     * pushed_at : 2019-09-09T15:35:22Z
     * git_url : git://github.com/google/.github.git
     * ssh_url : git@github.com:google/.github.git
     * clone_url : https://github.com/google/.github.git
     * svn_url : https://github.com/google/.github
     * homepage :
     * size : 2
     * stargazers_count : 5
     * watchers_count : 5
     * language : null
     * has_issues : true
     * has_projects : false
     * has_downloads : true
     * has_wiki : false
     * has_pages : false
     * forks_count : 23
     * mirror_url : null
     * archived : false
     * disabled : false
     * open_issues_count : 1
     * license : null
     * forks : 23
     * open_issues : 1
     * watchers : 5
     * default_branch : master
     */

    var id: Int = 0
    var node_id: String? = null
    var name: String? = null
    var full_name: String? = null
    @SerializedName("private")
    var isPrivateX: Boolean = false
    var owner: OwnerBean? = null
    var html_url: String? = null
    var description: String? = null
    var isFork: Boolean = false
    var url: String? = null
    var forks_url: String? = null
    var keys_url: String? = null
    var collaborators_url: String? = null
    var teams_url: String? = null
    var hooks_url: String? = null
    var issue_events_url: String? = null
    var events_url: String? = null
    var assignees_url: String? = null
    var branches_url: String? = null
    var tags_url: String? = null
    var blobs_url: String? = null
    var git_tags_url: String? = null
    var git_refs_url: String? = null
    var trees_url: String? = null
    var statuses_url: String? = null
    var languages_url: String? = null
    var stargazers_url: String? = null
    var contributors_url: String? = null
    var subscribers_url: String? = null
    var subscription_url: String? = null
    var commits_url: String? = null
    var git_commits_url: String? = null
    var comments_url: String? = null
    var issue_comment_url: String? = null
    var contents_url: String? = null
    var compare_url: String? = null
    var merges_url: String? = null
    var archive_url: String? = null
    var downloads_url: String? = null
    var issues_url: String? = null
    var pulls_url: String? = null
    var milestones_url: String? = null
    var notifications_url: String? = null
    var labels_url: String? = null
    var releases_url: String? = null
    var deployments_url: String? = null
    var created_at: String? = null
    var updated_at: String? = null
    var pushed_at: String? = null
    var git_url: String? = null
    var ssh_url: String? = null
    var clone_url: String? = null
    var svn_url: String? = null
    var homepage: String? = null
    var size: Int = 0
    var stargazers_count: Int = 0
    var watchers_count: Int = 0
    var language: Any? = null
    var isHas_issues: Boolean = false
    var isHas_projects: Boolean = false
    var isHas_downloads: Boolean = false
    var isHas_wiki: Boolean = false
    var isHas_pages: Boolean = false
    var forks_count: Int = 0
    var mirror_url: Any? = null
    var isArchived: Boolean = false
    var isDisabled: Boolean = false
    var open_issues_count: Int = 0
    var license: Any? = null
    var forks: Int = 0
    var open_issues: Int = 0
    var watchers: Int = 0
    var default_branch: String? = null

    class OwnerBean {
        /**
         * login : google
         * id : 1342004
         * node_id : MDEyOk9yZ2FuaXphdGlvbjEzNDIwMDQ=
         * avatar_url : https://avatars1.githubusercontent.com/u/1342004?v=4
         * gravatar_id :
         * url : https://api.github.com/users/google
         * html_url : https://github.com/google
         * followers_url : https://api.github.com/users/google/followers
         * following_url : https://api.github.com/users/google/following{/other_user}
         * gists_url : https://api.github.com/users/google/gists{/gist_id}
         * starred_url : https://api.github.com/users/google/starred{/owner}{/repo}
         * subscriptions_url : https://api.github.com/users/google/subscriptions
         * organizations_url : https://api.github.com/users/google/orgs
         * repos_url : https://api.github.com/users/google/repos
         * events_url : https://api.github.com/users/google/events{/privacy}
         * received_events_url : https://api.github.com/users/google/received_events
         * type : Organization
         * site_admin : false
         */

        var login: String? = null
        var id: Int = 0
        var node_id: String? = null
        var avatar_url: String? = null
        var gravatar_id: String? = null
        var url: String? = null
        var html_url: String? = null
        var followers_url: String? = null
        var following_url: String? = null
        var gists_url: String? = null
        var starred_url: String? = null
        var subscriptions_url: String? = null
        var organizations_url: String? = null
        var repos_url: String? = null
        var events_url: String? = null
        var received_events_url: String? = null
        var type: String? = null
        var isSite_admin: Boolean = false
    }
}
