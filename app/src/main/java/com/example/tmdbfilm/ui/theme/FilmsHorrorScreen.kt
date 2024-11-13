package com.example.tmdbfilm.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.text.style.TextOverflow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilmsHorrorScreen(
    mainViewModel: MainViewModel,
    navController: NavController
) {
    // Collecte des films d'horreur depuis le ViewModel
    val horrorMovies = mainViewModel.horrorMovies.collectAsState().value

    // Charger les films d'horreur lors du premier affichage de l'écran
    LaunchedEffect(key1 = true) {
        mainViewModel.fetchHorrorMovies()  // Appel pour récupérer les films
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Films d'Horreur") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = null)
                    }
                }
            )
        },
        content = { padding ->
            Column(modifier = Modifier.fillMaxSize().padding(padding)) {
                if (horrorMovies.isNotEmpty()) {
                    LazyColumn(modifier = Modifier.fillMaxSize()) {
                        items(horrorMovies) { horrorMovie ->
                            HorrorMovieItem(horrorMovie = horrorMovie, navController = navController)
                        }
                    }
                } else {
                    // Affiche un message si aucun film d'horreur n'est disponible
                    Text(text = "Aucun film d'horreur disponible", modifier = Modifier.padding(16.dp))
                }
            }
        }
    )
}

@Composable
fun HorrorMovieItem(horrorMovie: HorrorMovie, navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

            Text(
                text = horrorMovie.title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(8.dp))


            Text(
                text = horrorMovie.overview,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(8.dp))


            Button(
                onClick = {

                    navController.navigate("movie/${horrorMovie.id}")
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Voir les détails")
            }
        }
    }
}


