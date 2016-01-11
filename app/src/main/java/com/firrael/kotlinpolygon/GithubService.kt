package com.firrael.kotlinpolygon

import retrofit.http.GET
import retrofit.http.Path
import retrofit.Call

/**
 * Created by Railag on 28.12.2015.
 */

interface GitHubService {
    @GET("users/{user}")
    fun listRepos(@Path("user") user:String): Call<Owner>
}