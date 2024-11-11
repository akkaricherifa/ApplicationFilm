package com.example.tmdbfilm.ui.theme
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


class MainViewModel : ViewModel() {
    private val filmId:String = ""

    val moviiess = MutableStateFlow<List<Movie>>(listOf())
    val actors= MutableStateFlow<List<TmdbActors>>(listOf())
    val movie=MutableStateFlow<Movie?>(null)
    val movies = MutableStateFlow<List<TmdbMovie>>(listOf())
    val serie=MutableStateFlow<Serie?>(null)
    val append_to_response="credits"
    val TV= MutableStateFlow<List<TmdbTv>>(listOf())
    val api_key = "24714091346b3079a0414fe486ba3858"
    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build();
    val api = retrofit.create(TmdbApi::class.java)
    init {
        getMovies()
        getActors()
        getTv()
    }
    fun getMovies() {
        viewModelScope.launch {
            movies.value = api.lastmovies(api_key).results
        }
    }
    fun movieDetails(id: String) {
        viewModelScope.launch {
            movie.value = api.movieInfo(id, api_key, append_to_response)
        }
    }
    fun serieDetails(id: String) {
        viewModelScope.launch {
            serie.value = api. SerieInfo(id, api_key, append_to_response)
        }
    }
    fun getTv() {
        viewModelScope.launch {
            TV.value = api.lastTv(api_key).results
        }
    }
    fun getActors() {
        viewModelScope.launch {
            actors.value = api.getActors(api_key).results
        }
    }
    fun searchMovies(query: String) {
        viewModelScope.launch {
            try {
                val response = api.searchmovies(api_key, query)
                movies.value = response.results
            } catch (e: Exception) {
            }
        }
    }
    fun searchActors(query: String) {
        viewModelScope.launch {
            try {
                val response = api.searchactors(api_key, query)
                actors.value = response.results
            } catch (e: Exception) {
            }
        }
    }
    fun searchSeries(query: String) {
        viewModelScope.launch {
            try {
                val response = api.searchtv(api_key, query)
                TV.value = response.results
            } catch (e: Exception) {
            }
        }
    }
}