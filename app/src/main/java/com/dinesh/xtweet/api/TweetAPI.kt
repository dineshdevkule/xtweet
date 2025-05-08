package com.dinesh.xtweet.api

import com.dinesh.xtweet.models.Tweet
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface TweetAPI {


    @GET("v3/b/67cf21eb8561e97a50e97c4e?meta=false")
    suspend fun getTweets(@Header("X-JSON-Path") category: String): Response<List<Tweet>>

    @GET("v3/b/67cf21eb8561e97a50e97c4e?meta=false")
    @Headers("X-JSON-Path:tweets..category")
    suspend fun getCategories(): Response<List<String>>

}