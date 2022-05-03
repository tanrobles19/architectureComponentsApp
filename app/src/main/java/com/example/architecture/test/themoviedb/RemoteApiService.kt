package com.salem.onebible.app.networking

import com.example.architecture.test.themoviedb.model.MovieData
import retrofit2.Call
import retrofit2.http.*
import retrofit2.http.GET

/**
 * Holds the API calls for the OneBible App.
 */
interface RemoteApiService {

//  @GET("audio")
//  suspend fun getAudioBookInfo(
//      @Query("translation") translation: String,
//      @Query("book_id") book_id: String,
//      @Query("book_abbr") book_abbr: String,
//      @Query("chapter") chapter: String,
//  ): AudioBookResponse

//  @POST("users/sign_up")
//  fun registerUser(@Body request: SignUpRequest): SignUpResponse

//  @POST("users/login")
//  suspend fun loginUser(@Body request: LoginRequest): LoginResponse

    @GET("audio")
    fun getAudioBookInfoSynchronously(
        @Query("api_key") api_key: String,
        @Query("language") language: String,
        @Query("page") page: Int
    ): Call<MovieData>

}