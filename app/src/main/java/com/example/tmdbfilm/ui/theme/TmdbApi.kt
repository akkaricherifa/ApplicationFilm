package com.example.tmdbfilm.ui.theme

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TmdbApi {
    @GET("trending/movie/week")
    suspend fun lastmovies(@Query("api_key") api_key: String): TmdbMovieResult
    @GET ("movie/{id}")
    suspend fun movieInfo (@Path("id") id: String,@Query("api_key")apikey: String,@Query("append_to_response")append_to_response:String):Movie
    @GET("trending/person/week")
    suspend fun getActors(@Query("api_key") api_key: String): TmdbPersonneResult

    @GET("trending/tv/week")
    suspend fun lastTv(@Query("api_key") api_key: String): TmdbTvResult
    @GET ("tv/{id}")
    suspend fun SerieInfo (@Path("id") id: String,@Query("api_key")apikey: String,@Query("append_to_response")append_to_response:String):Serie

    @GET("search/movie")
    suspend fun searchmovies(@Query("api_key") api_key: String,
                             @Query("query") searchtext: String): TmdbMovieResult
    @GET("search/person")
    suspend fun searchactors(@Query("api_key") api_key: String,
                             @Query("query") searchtext: String): TmdbPersonneResult
    @GET("search/tv")
    suspend fun searchtv(@Query("api_key") api_key: String,
                         @Query("query") searchtext: String): TmdbTvResult}