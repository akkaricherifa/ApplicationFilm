package com.example.tmdbfilm.ui.theme


import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tmdbfilm.R
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.IconButton


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FindInPage

import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Surface
import androidx.compose.material3.TextField
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import coil.compose.AsyncImage


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "SuspiciousIndentation")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Films(windowClass: WindowSizeClass,mainViewModel: MainViewModel,navController: NavController) {
    val movies by mainViewModel.movies.collectAsState()
    var active by remember { mutableStateOf(false) }
    var text by remember { mutableStateOf("") }

    Scaffold {

        SearchBar(query = text, onQueryChange = { text = it },
            modifier = Modifier.fillMaxWidth(),

            onSearch = {
                if (text=="") {

                }
                active = false
            },
            active = active,
            onActiveChange = {
                active = it
            },
            placeholder = {

                Text(text = "Recherche")
            },
            leadingIcon = {
                Icon(
                    Icons.Filled.FindInPage,
                    contentDescription = null
                )
            }
        )
        {

        }

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.White


        ) {
            when (windowClass.widthSizeClass) {

                WindowWidthSizeClass.Compact -> {

                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2),

                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        verticalArrangement = Arrangement.spacedBy(20.dp)
                    ) {




                        items(movies) {

                                movie ->
                            val url = "https://image.tmdb.org/t/p/w780" + movie.poster_path
                            val title_movie = movie.title
                            val score = movie.vote_average
                            val date = movie.release_date
                            val ids=movie.id

                            Box(

                                contentAlignment = Alignment.Center,
                                modifier = Modifier.fillMaxSize(),
                            ) {
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center,
                                ) {

                                    Card(
                                        colors = CardDefaults.cardColors(
                                            containerColor = MaterialTheme.colorScheme.surfaceVariant,
                                        ),
                                    ) {


                                        Text(
                                            date,
                                            textAlign = TextAlign.Center,
                                            modifier = Modifier.background(color = Color.Blue)
                                                .fillMaxWidth().padding(10.dp),
                                            color = Color.Black,


                                            )

                                        Box(contentAlignment = Alignment.TopStart) {
                                            AsyncImage(
                                                model = url,
                                                modifier = Modifier.fillMaxSize().clickable(
                                                    onClick =   { navController.navigate("movie/"+ ids) }
                                                )
                                                ,
                                                contentDescription = "Image du film",
                                                contentScale = ContentScale.Fit
                                            )
                                            Row(
                                                modifier = Modifier.fillMaxWidth(),
                                                horizontalArrangement = Arrangement.SpaceBetween
                                            ) {
                                                Image(
                                                    painter = painterResource(id = R.drawable.star),
                                                    contentDescription = stringResource(id = R.string.app_name),
                                                    modifier = Modifier
                                                        .size(50.dp)

                                                )

                                                Row(
                                                    Modifier
                                                        .background(Color.Black.copy(alpha = 0.4f))//50% opacity

                                                        .size(40.dp)


                                                ) {
                                                    Text(

                                                        score.toInt().toString(),

                                                        color = Color.Black


                                                    )
                                                    Image(
                                                        painter = painterResource(id = R.drawable.star),
                                                        contentDescription = stringResource(id = R.string.app_name),
                                                        modifier = Modifier
                                                            .size(24.dp)

                                                    )

                                                }

                                            }


                                        }

                                    }

                                    Text(
                                        title_movie,
                                        modifier = Modifier.padding(16.dp), // Ajouter de l'espace autour du texte
                                        textAlign = TextAlign.Center,
                                        color = Color.Black

                                    )
                                }
                            }


                        }
                    }
                }

                else -> {
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(3),
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        verticalArrangement = Arrangement.spacedBy(13.dp)
                    ) {
                        items(movies) {

                                Result ->
                            val url = "https://image.tmdb.org/t/p/w780" + Result.poster_path
                            val title_movie = Result.title
                            val score = Result.vote_average
                            val date = Result.release_date
                            Box(

                                contentAlignment = Alignment.Center,
                                modifier = Modifier.fillMaxSize().clickable(onClick = {  }),
                            ) {
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center,
                                ) {
                                    Card(
                                        colors = CardDefaults.cardColors(
                                            containerColor = MaterialTheme.colorScheme.surfaceVariant,
                                        ),
                                    ) {


                                        Text(
                                            date,
                                            textAlign = TextAlign.Center,
                                            modifier = Modifier.background(color = Color.Blue)
                                                .fillMaxWidth().padding(10.dp),
                                            color = Color.Green,


                                            )
                                        Box(contentAlignment = Alignment.TopStart) {
                                            AsyncImage(
                                                model = url,
                                                modifier = Modifier.fillMaxSize(),
                                                contentDescription = "Image du film",
                                                contentScale = ContentScale.Fit
                                            )
                                            Row(
                                                modifier = Modifier.fillMaxWidth(),
                                                horizontalArrangement = Arrangement.SpaceBetween
                                            ) {
                                                Image(
                                                    painter = painterResource(id = R.drawable.photo1),
                                                    contentDescription = stringResource(id = R.string.app_name),
                                                    modifier = Modifier
                                                        .size(50.dp)

                                                )

                                                Row(
                                                    Modifier
                                                        .background(Color.Black.copy(alpha = 0.4f))//50% opacity

                                                        .size(40.dp)


                                                ) {
                                                    Text(

                                                        score.toInt().toString(),

                                                        color = Color.White


                                                    )
                                                    Image(
                                                        painter = painterResource(id = R.drawable.enveloppe),
                                                        contentDescription = stringResource(id = R.string.app_name),
                                                        modifier = Modifier
                                                            .size(24.dp)

                                                    )

                                                }

                                            }


                                        }

                                    }
                                    Text(
                                        title_movie,
                                        modifier = Modifier.padding(16.dp), // Ajouter de l'espace autour du texte
                                        textAlign = TextAlign.Center,
                                        color = Color.Cyan

                                    )

                                }


                            }
                        }
                    }
                }
            }






        }}
}