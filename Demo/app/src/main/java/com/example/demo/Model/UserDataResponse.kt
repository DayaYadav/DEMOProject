package com.example.demo.Model

data class UserDataResponse(

    val login: String,
    val id: Long,
    val nodeId: String,
    val avatarUrl: String,
    val gravatarId: String,
    val url: String,
    val htmlUrl: String,
    val followersUrl: String,
    val followingUrl: String,
    val gistsUrl: String,
    val starredUrl: String,
    val subscriptionsUrl: String,
    val organizationsUrl: String,
    val reposUrl: String,
    val eventsUrl: String,
    val receivedEventsUrl: String,
    val type: String,
    val userViewType: String,
    val siteAdmin: Boolean,
    val name: String,
    val company: String,
    val blog: String,
    val location: String,
    val email: Any?,
    val hireable: Any?,
    val bio: Any?,
    val twitterUsername: Any?,
    val publicRepos: Long,
    val publicGists: Long,
    val followers: Long,
    val following: Long,
    val createdAt: String,
    val updatedAt: String,

) {

}
