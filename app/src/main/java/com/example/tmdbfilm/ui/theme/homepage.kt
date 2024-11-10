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
                        button(navController, contenu = "Choisissez Vos Films")
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
                    .size(200.dp) // Ajustez la taille de l'image selon vos besoins
                    .clip(CircleShape)
            )

            textes("Akkari Chérifa")
            Column {
                texte(contenu = "Etudiante en 4éme Année-FIE4")
                texte(contenu = "Ecole d'ingénieur ISIS - INU Champollion")
            }
            Column {
                Row (verticalAlignment = Alignment.CenterVertically)
                {
                    Image(painter = painterResource(id = R.drawable.enveloppe), contentDescription = stringResource(id = R.string.app_name), modifier = Modifier
                        .size(30.dp) )


                    texte(contenu = "akkaricherifa@gmail.com")

                }
                Row (verticalAlignment = Alignment.CenterVertically)
                {
                    Image(painter = painterResource(id = R.drawable.linkedin), contentDescription = stringResource(id = R.string.app_name), modifier = Modifier
                        .size(30.dp) )
                    texte(contenu = "www.linkedin.com/akkaricherifa")

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
            // Affichez l'icône de popcorn avant le texte
            Image(
                painter = painterResource(id = R.drawable.popcorn), // Assurez-vous que l'icône est dans 'res/drawable'
                contentDescription = "Popcorn Icon",
                modifier = Modifier.size(24.dp) // Vous pouvez ajuster la taille de l'icône ici
            )
            Spacer(modifier = Modifier.width(8.dp)) // Espacement entre l'icône et le texte
            Text(
                text = contenu,
                color = Color.White
            )
        }
    }
}


