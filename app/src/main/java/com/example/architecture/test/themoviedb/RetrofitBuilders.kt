package com.salem.onebible.app.networking

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Builds retrofit dependencies.
 */

private const val HEADER_AUTHORIZATION = "Authorization"
private const val REMOTE_ACCESS_TOKEN = "remote_access_token"

fun buildClient(): OkHttpClient =
    OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply {
          level = HttpLoggingInterceptor.Level.BODY
        })
        .addInterceptor(buildAuthorizationInterceptor())
        .build()

fun buildAuthorizationInterceptor() = object : Interceptor {
  override fun intercept(chain: Interceptor.Chain): Response {
    val originalRequest = chain.request()

    val new = originalRequest.newBuilder()
//        .addHeader(HEADER_AUTHORIZATION, "Basic ZGFjOnJvbWFuczgyOA==")
//        .addHeader(REMOTE_ACCESS_TOKEN, "DFHLOF45RtXBI5syUN")
        .build()

    return chain.proceed(new)
  }
}

fun buildRetrofit(): Retrofit {

  return Retrofit.Builder()
      .client(buildClient())
      .baseUrl(BASE_URL)
      .addConverterFactory(GsonConverterFactory.create())
      .build()
}

fun buildApiService(): RemoteApiService =
    buildRetrofit().create(RemoteApiService::class.java)