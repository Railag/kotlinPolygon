package com.firrael.kotlinpolygon

import android.util.Log
import retrofit.Callback
import retrofit.Response
import retrofit.Retrofit

/**
 * Created by Railag on 11.01.2016.
 */

class RepoCallback : Callback<Owner> {

    override fun onResponse(response: Response<Owner>, retrofit: Retrofit) {
        Log.e("TEST", response.toString())
    }

    override fun onFailure(t:Throwable) {
        t.printStackTrace()
    }
}