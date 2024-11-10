package com.example.tmdbfilm.ui.theme
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import com.example.tmdbfilm.R
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.CutCornerShape


@Composable
fun HomePage(
    windowClass: WindowSizeClass,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {

        when (windowClass.widthSizeClass) {
            WindowWidthSizeClass.Compact -> {
                LayoutVert(navController)
            }

            else -> {
                Row(
                    Modifier.fillMaxSize().padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            painter = painterResource(id = R.drawable.photo1),
                            contentDescription = null,
                            modifier = Modifier
                                .size(200.dp)
                                .clip(CircleShape)
                        )
                        textes("Akkari Chérifa")
                        Column {
                            texte("Étudiante en 4ème année - FIE4")
                            texte("École d'ingénieur ISIS - INU Champollion")
                        }
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        ContactInfoRow(R.drawable.enveloppe, "akkaricherifa@gmail.com")
                        ContactInfoRow(R.drawable.linkedin, "www.linkedin.com/akkaricherifa")
                        button(navController, contenu = "C'est l'heure du popcorn !")
                    }
                }
            }
        }
    }
}

@Composable

fun LayoutVert(navController:NavController) {

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize(),
    ) {

        Column(

            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally


        ) {
            Image(
                painter = painterResource(id = R.drawable.photo1),
                contentDescription = stringResource(id = R.string.app_name),
                modifier = Modifier
                    .size(220.dp)
                    .clip(CutCornerShape(16.dp))
            )

            textes("Akkari Chérifa")
            Column {
                texte(contenu = " 'Etudiante en 4éme Année-FIE4' ")
                texte(contenu = " 'Ecole d'ingénieur ISIS - INU Champollion' ")

            }
            Column {
                Row (verticalAlignment = Alignment.CenterVertically)
                {
                    Image(painter = painterResource(id = R.drawable.enveloppe),
                        contentDescription = stringResource(id = R.string.app_name),
                        modifier = Modifier.size(30.dp) )


                    Text (
                        text = "akkaricherifa@gmail.com",
                        modifier = Modifier.padding(start = 8.dp)
                    )


                }
                Row (verticalAlignment = Alignment.CenterVertically)
                {
                    Image(painter = painterResource(id = R.drawable.linkedin), contentDescription = stringResource(id = R.string.app_name), modifier = Modifier
                        .size(30.dp) )
                    Text (
                        text = "www.linkedin.com/akkaricherifa",
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }

            button(navController,contenu = "C'est l'heure du popcorn !")

        }
    }
}

@Composable
fun ContactInfoRow(iconId: Int, text: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = iconId),
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = text,
            color = Color.Black,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

@Composable
fun texte(contenu:String){
    Text(
        text=contenu,
        color = Color.Black
    )
}
@Composable
fun textes(contenu:String){
    val offset = Offset(5.0f, 10.0f)

    Text(
        text=contenu,fontSize = 40.sp, style = TextStyle(
            fontSize = 24.sp,
                color = Color.Blue,))
}

@Composable
fun button(navController: NavController, contenu: String) {
    Button(
        colors = ButtonDefaults.buttonColors(Color.Blue),
        onClick = { navController.navigate("films") },
        modifier = Modifier.padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(id = R.drawable.popcorn),
                contentDescription = "Popcorn Icon",
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = contenu,
                color = Color.White
            )
        }
    }
}


