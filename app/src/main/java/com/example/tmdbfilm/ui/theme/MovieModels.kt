package com.example.tmdbfilm.ui.theme

class TmdbMovieResult(
    var page: Int = 0,
    val results: List<TmdbMovie> = listOf()
)

class TmdbMovie(
    var overview: String = "",
    val release_date: String = "",
    val id: Int,
    val title: String = "",
    val original_title: String = "",
    val backdrop_path: String? = "",
    val genre_ids: List<Int> = listOf(),
    val poster_path: String? = "",
    val vote_average:Double
)


class TmdbPersonneResult(
    val page: Int=0,
    val results: List<TmdbActors> = listOf()
)

class TmdbActors(
    val adult: Boolean,
    val gender: Int,
    val id: Int,
    val known_for_department: String,
    val media_type: String,
    val name: String,
    val original_name: String,
    val popularity: Double,
    val profile_path: String
)


class TmdbTvResult(
    var page: Int = 0,
    val results: List<TmdbTv> = listOf()
)

class TmdbTv(
    var overview: String = "",
    val id: String = "",
    val name: String = "",
    val first_air_date: String = "",

    val original_title: String = "",
    val backdrop_path: String? = "",
    val genre_ids: List<Int> = listOf(),
    val poster_path: String? = "",
    val vote_average:Double

)
data class Serie(
    val adult: Boolean,
    val backdrop_path: String,
    val belongs_to_collection: Any,
    val budget: Int,
    val credits: CreditsM,
    val genres: List<Genre>,
    val homepage: String,
    val id: Int,
    val imdb_id: String,
    val overview: String,
    val popularity: Double,

    val poster_path: String,
    val production_companies: List<ProductionCompany>,
    val production_countries: List<ProductionCountry>,
    val first_air_date: String,
    val revenue: Int,
    val runtime: Int,
    val spoken_languages: List<SpokenLanguage>,
    val status: String,
    val tagline: String,
    val original_name: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
)

data class Movie(
    val adult: Boolean,
    val backdrop_path: String,
    val belongs_to_collection: Any,
    val budget: Int,
    val credits: CreditsM,
    val genres: List<Genre>,
    val homepage: String,
    val id: Int,
    val imdb_id: String,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val production_companies: List<ProductionCompany>,
    val production_countries: List<ProductionCountry>,
    val release_date: String,
    val revenue: Int,
    val runtime: Int,
    val spoken_languages: List<SpokenLanguage>,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
)
data class CreditsM(
    val cast: List<CastM>,
    val crew: List<CrewM>
)
data class CastM(
    val adult: Boolean,
    val cast_id: Int,
    val character: String,
    val credit_id: String,
    val gender: Int,
    val id: Int,
    val known_for_department: String,
    val name: String,
    val order: Int,
    val original_name: String,
    val popularity: Double,
    val profile_path: String
)
data class CrewM(
    val adult: Boolean,
    val credit_id: String,
    val department: String,
    val gender: Int,
    val id: Int,
    val job: String,
    val known_for_department: String,
    val name: String,
    val original_name: String,
    val popularity: Double,
    val profile_path: String
)





data class Genre(
    val id: Int,
    val name: String
)

/**
 * ProductionCountry data Class
 */
data class ProductionCompany(
    val id: Int,
    val logo_path: Any,
    val name: String,
    val origin_country: String
)

/**
 * ProductionCountry data Class
 */
data class ProductionCountry(
    val iso_3166_1: String,
    val name: String
)

/**
 * SpokenLanguage data Class
 */
data class SpokenLanguage(
    val english_name: String,
    val iso_639_1: String,
    val name: String
)

/**
 *Credits data Class
 */
data class Credits(
    val cast: List<Cast> = listOf(),
)

/**
 * Cast data Class
 */
data class Cast(
    val adult: Boolean,
    val cast_id: Int,
    val character: String,
    val credit_id: String,
    val gender: Int,
    val id: Int,
    val known_for_department: String,
    val name: String,
    val order: Int,
    val original_name: String,
    val popularity: Double,
    val profile_path: String
)

data class HorrorMoviesResponse(
    val page: Int = 0,
    val results: List<HorrorMovie> = listOf()  // Liste des films d'horreur (HorrorMovie)
)


data class HorrorMovie(
    var overview: String = "",
    val release_date: String = "",
    val id: Int,
    val title: String = "",
    val original_title: String = "",
    val backdrop_path: String? = "",
    val genre_ids: List<Int> = listOf(),
    val poster_path: String? = "",
    val vote_average: Double
)


