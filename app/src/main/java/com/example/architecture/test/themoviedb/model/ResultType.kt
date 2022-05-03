package com.example.architecture.test.themoviedb.model

/**
 * Represents the Success and Failure cases from the Remote API.
 */
sealed class ResultType<out T : Any>

data class Success<out T : Any>(val data: String?) : ResultType<T>()

data class Failure(val error: Throwable?) : ResultType<String>()