package com.example.architecture.test.themoviedb.model

// To parse the JSON, install kotlin's serialization plugin and do:
//
// val json      = Json(JsonConfiguration.Stable)
// val movieData = json.parse(MovieData.serializer(), jsonString)

import kotlinx.serialization.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

@Serializable
data class MovieData (
    val dates: Dates,
    val page: Long,
    val results: List<Result>,

    @SerialName("total_pages")
    val totalPages: Long,

    @SerialName("total_results")
    val totalResults: Long
)

@Serializable
data class Dates (
    val maximum: String,
    val minimum: String
)

@Serializable
data class Result (
    val adult: Boolean,

    @SerialName("backdrop_path")
    val backdropPath: String,

    @SerialName("genre_ids")
    val genreIDS: List<Long>,

    val id: Long,

    @SerialName("original_language")
    val originalLanguage: OriginalLanguage,

    @SerialName("original_title")
    val originalTitle: String,

    val overview: String,
    val popularity: Double,

    @SerialName("poster_path")
    val posterPath: String,

    @SerialName("release_date")
    val releaseDate: String,

    val title: String,
    val video: Boolean,

    @SerialName("vote_average")
    val voteAverage: Double,

    @SerialName("vote_count")
    val voteCount: Long
)

@Serializable
enum class OriginalLanguage(val value: String) {
    En("en"),
    Es("es"),
    Fr("fr");

    companion object : KSerializer<OriginalLanguage> {
        override val descriptor: SerialDescriptor get() {
            return PrimitiveSerialDescriptor("quicktype.OriginalLanguage", PrimitiveKind.STRING)
        }
        override fun deserialize(decoder: Decoder): OriginalLanguage = when (val value = decoder.decodeString()) {
            "en" -> En
            "es" -> Es
            "fr" -> Fr
            else -> throw IllegalArgumentException("OriginalLanguage could not parse: $value")
        }
        override fun serialize(encoder: Encoder, value: OriginalLanguage) {
            return encoder.encodeString(value.value)
        }
    }
}
