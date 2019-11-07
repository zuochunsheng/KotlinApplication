package com.example.edz.kotlinapplication.data

/**
 * @author： zcs
 * @time：2019/11/7 on 19:20
 * @description：
 */

data class OwnerBean constructor(var login: String? = null,
                                 var id: Int = 0,
                                 var node_id: String? = null,
                                 var avatar_url: String? = null,
                                 var gravatar_id: String? = null,
                                 var url: String? = null,
                                 var html_url: String? = null,
                                 var followers_url: String? = null,
                                 var following_url: String? = null,
                                 var gists_url: String? = null,
                                 var starred_url: String? = null,
                                 var subscriptions_url: String? = null,
                                 var organizations_url: String? = null,
                                 var repos_url: String? = null,
                                 var events_url: String? = null,
                                 var received_events_url: String? = null,
                                 var type: String? = null,
                                 var isSite_admin: Boolean = false)