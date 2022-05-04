package com.salem.onebible.app.networking

import com.example.architecture.test.themoviedb.model.Failure
import com.example.architecture.test.themoviedb.model.Success

/**
 * Holds decoupled logic for all the API calls for OneBible endpoint
 */

const val BASE_URL = "https://api.themoviedb.org/3/movie/now_playing/"

class RemoteApi(private val apiService: RemoteApiService) {

    fun getAudioBookInfoSynchronously() = try {

        val call = apiService.getAudioBookInfoSynchronously("e23ece4da67144877ca7da9d18c13b37",
        "es-ES", 1)

        //Synchronously Execution
        val a = call.execute()

        //getting the response object
        val responseData = a.body()

        Success(responseData?.toString())

    } catch (error: Throwable) {
        Failure(error)
    }
//
//    suspend fun getAudioBookInfo(audioBookRequest: AudioBookRequest) = try {
//
//        val signUpResponse = apiService.getAudioBookInfo(audioBookRequest.translation,
//            audioBookRequest.book_id, audioBookRequest.book_abbr, audioBookRequest.chapter)
//
//        Success(signUpResponse.url)
//
//    } catch (error: Throwable) {
//        Failure(error)
//    }
//
//    fun registerUser(signUpRequest: SignUpRequest) = try {
//
//        val signUpResponse = apiService.registerUser(signUpRequest)
//
//        Success(signUpResponse.text)
//
//    } catch (error: Throwable) {
//        Failure(error)
//    }
//
//    suspend fun loginUser(loginRequest: LoginRequest) = try {
//
//        val loginResponse = apiService.loginUser(loginRequest)
//
//        Success(loginResponse.user.message)
//
//    } catch (error: Throwable) {
//        Failure(error)
//    }

}