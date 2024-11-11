package com.example.tmdbfilm.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.tmdbfilm.R

@Composable
fun DetailsScreenSerie(id: String, viewModel: MainViewModel, navController: NavController) {

    val serie by viewModel.serie.collectAsState()

    viewModel.serieDetails(id)
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth(),

        color = Color.White
    ) {
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.Blue
                        )
                    }

                }
                TitreSerie(serie)
                Spacer(modifier = Modifier.height(16.dp))
                PosterSeriie(serie)
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    SmallPoster(serie)
                    Spacer(modifier = Modifier.width(16.dp))
                    Column {
                        DateSerie(serie)
                        Spacer(modifier = Modifier.height(8.dp))
                        TypeSerie(serie)
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                TextsSynops(serie)
                Spacer(modifier = Modifier.height(16.dp))
                Acteurs(serie)
            }
        }
    }
}

@Composable
fun TitreSerie(serie: Serie?) {
    if (serie != null) {
        Text(
            text = serie.original_name,
            fontFamily = FontFamily.Serif,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            modifier = Modifier.background(Color.Transparent)
        )
    }
}

@Composable
fun PosterSeriie(serie: Serie?) {
    if (serie != null) {
        AsyncImage(
            model = "https://image.tmdb.org/t/p/w1280/" + serie.backdrop_path,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
                .clip(RoundedCornerShape(38.dp))
        )
    }
}

@Composable
fun SmallPoster(serie: Serie?) {
    if (serie != null) {
        AsyncImage(
            model = "https://image.tmdb.org/t/p/w300/" + serie.poster_path,
            contentDescription = "Ma super image",
            modifier = Modifier
                .size(130.dp)
                .clip(RoundedCornerShape(8.dp))
        )
    }
}

@Composable
fun DateSerie(serie: Serie?) {
    if (serie != null) {
        Text(
            text = serie.first_air_date,
            fontWeight = FontWeight.W300,
            fontStyle = FontStyle.Italic,
            fontSize = 20.sp,
            color = Color.Black,
            )
    }
}
@Composable
fun TypeSerie(serie: Serie?){
    if(serie!=null){
        LazyColumn(modifier = Modifier.height(70.dp)){
            items(serie.genres){
                    genre ->
                Text(
                    text = genre.name,
                    fontStyle = FontStyle.Italic,
                    color = Color.Black,

                    )
            }
        }

    }
}

@Composable
fun TextsSynops(serie: Serie?) {
    if (serie != null) {
        Text(
            text = "Synopsis : ",
            modifier = Modifier.padding(5.dp),
            fontWeight = FontWeight.Bold,
            color = Color.DarkGray,
            fontSize = 20.sp,

            )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = serie.overview,
            modifier = Modifier.padding(6.dp),
            color = Color.Black,

            )
    }
}

@Composable
fun Acteurs(serie: Serie?) {
    if (serie != null) {
        Text(
            text = "Têtes D'affiche : ",
            fontWeight = FontWeight.Bold,
            color = Color.DarkGray,
            fontSize = 20.sp,
        )
        Spacer(modifier = Modifier.height(10.dp))
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        ) {
            items(serie.credits.cast) { actor ->
                ActeurList(actor)
            }
        }
    }
}
@Composable
fun ActeurList(actor: CastM) {
    Spacer(modifier = Modifier.height(16.dp))
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        // Box to add shadow and frame around the image
        Box(
            modifier = Modifier
                .size(130.dp) // Slightly larger than the image size for shadow effect
                .clip(RoundedCornerShape(8.dp))
                .shadow(
                    elevation = 8.dp, // Shadow size
                    shape = RoundedCornerShape(8.dp),
                    ambientColor = Color.Black.copy(alpha = 0.2f), // Adjust transparency
                    spotColor = Color.Black.copy(alpha = 0.1f) // Soft shadow
                )
                .background(Color.Transparent) // Background for shadow effect
                .border(
                    BorderStroke(2.dp, Color.Gray), // Frame with gray color and 2.dp thickness
                    shape = RoundedCornerShape(8.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            AsyncImage(
                model = "https://image.tmdb.org/t/p/w300/" + actor.profile_path,
                contentDescription = null,
                modifier = Modifier
                    .size(120.dp)
                    .clip(RoundedCornerShape(8.dp)) // Clip the image within the frame and shadow
            )
        }

        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = actor.name,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = actor.character,
            fontWeight = FontWeight.W300,
            color = Color.Black,
        )
    }
}
