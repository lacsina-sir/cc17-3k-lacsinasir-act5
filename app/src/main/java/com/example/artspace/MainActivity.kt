package com.example.artspace

import android.content.res.Configuration
import android.os.Bundle
import androidx.annotation.DrawableRes
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtspaceTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
                    ArtSpaceScreen()
                }
            }
        }
    }
}

class ArtspaceTheme(function: @Composable () -> Unit) {

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtspaceTheme {
        ArtSpaceScreen()
    }
}

@Composable
fun ArtSpaceScreen(modifier: Modifier = Modifier) {
    val firstArtwork = R.drawable.arthurtnery
    val secondArtwork = R.drawable.dr_strange
    val thirdArtwork = R.drawable.naruto
    val fourthArtwork = R.drawable.red_little
    val fifthArtwork = R.drawable.wed

    var title by remember {
        mutableIntStateOf(R.string.arhurtnery)
    }
    var artist by remember {
        mutableIntStateOf(R.string.arthur_artst)
    }

    var year by remember {
        mutableIntStateOf(R.string.arthur_year)
    }

    var currentArtwork by remember {
        mutableIntStateOf(firstArtwork)
    }

    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        ArtworkDisplay(currentArtwork = currentArtwork)
        Spacer(modifier = modifier.size(16.dp))
        ArtworkTitle(title = title, year = year, artist = artist)
        Spacer(modifier = modifier.size(25.dp))
        Row(
            modifier = modifier.padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)
        ) {
            Button(
                onClick = {
                    when (currentArtwork) {
                        firstArtwork -> {
                            currentArtwork = fifthArtwork
                            title = R.string.arhurtnery
                            artist = R.string.arthur_artst
                            year = R.string.arthur_year
                        }

                        secondArtwork -> {
                            currentArtwork = firstArtwork
                            title = R.string.dr_strange
                            artist = R.string.dr_strange_artst
                            year = R.string.dr_strange_year
                        }

                        thirdArtwork -> {
                            currentArtwork = secondArtwork
                            title = R.string.naruto
                            artist = R.string.naruto_artst
                            year = R.string.naruto_year
                        }

                        fourthArtwork -> {
                            currentArtwork = thirdArtwork
                            title = R.string.red_little
                            artist = R.string.red_little_artst
                            year = R.string.red_little_year
                        }

                        else -> {
                            currentArtwork = fourthArtwork
                            title = R.string.wed_art
                            artist = R.string.wed_artst
                            year = R.string.wed_year
                        }
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White
                ),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 1.dp,
                    pressedElevation = 0.dp,
                    focusedElevation = 0.dp
                )
            ) {
                Text(
                    text = "Previous",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.purple_700)
                )
            }

            Button(
                onClick = {
                    when (currentArtwork) {
                        firstArtwork -> {
                            currentArtwork = secondArtwork
                            title = R.string.arhurtnery
                            artist = R.string.arthur_artst
                            year = R.string.arthur_year
                        }

                        secondArtwork -> {
                            currentArtwork = thirdArtwork
                            title = R.string.dr_strange
                            artist = R.string.dr_strange_artst
                            year = R.string.dr_strange_year
                        }

                        thirdArtwork -> {
                            currentArtwork = fourthArtwork
                            title = R.string.naruto
                            artist = R.string.naruto_artst
                            year = R.string.naruto_year
                        }

                        fourthArtwork -> {
                            currentArtwork = fifthArtwork
                            title = R.string.red_little
                            artist = R.string.red_little_artst
                            year = R.string.red_little_year
                        }

                        else -> {
                            currentArtwork = firstArtwork
                            title = R.string.wed_art
                            artist = R.string.wed_artst
                            year = R.string.wed_year
                        }
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.purple_700)
                ),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 1.dp,
                    pressedElevation = 0.dp,
                    focusedElevation = 0.dp
                )
            ) {
                Text(
                    text = "     Next    ",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(
                        id = R.color.black
                    )

                )
            }

        }
    }
}


@Composable
fun ArtworkDisplay(
    modifier: Modifier = Modifier,
    @DrawableRes currentArtwork: Int
) {
    Image(
        painter = painterResource(currentArtwork),
        contentDescription = stringResource(id = R.string.arhurtnery),
        modifier = modifier.fillMaxWidth()
            .height(550.dp)
    )

}

@Composable
fun ArtworkTitle(
    @StringRes title: Int,
    @StringRes artist: Int,
    @StringRes year: Int
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = title),
            fontSize = 32.sp,
            fontWeight = FontWeight.ExtraLight,
            fontStyle = FontStyle.Italic,
            color = colorResource(id = R.color.black)
        )

        Text(
            text = stringResource(id = artist),
            fontSize = 18.sp,
            fontWeight = FontWeight.Thin,
            color = colorResource(id = R.color.black)
        )

        Text(
            text = "— ${stringResource(id = year)} —",
            fontSize = 15.sp,
            fontWeight = FontWeight.Medium,
            color = colorResource(id = R.color.black)
        )

    }
}