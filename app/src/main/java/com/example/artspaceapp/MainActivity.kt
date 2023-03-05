package com.example.artspaceapp

import android.graphics.drawable.AnimatedImageDrawable
import android.net.wifi.aware.AwareResources
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                        ArtSpace();
                }
            }
        }
    }
}

@Composable
fun ArtSpace() {
    var count by remember { mutableStateOf(0) }
    Surface(modifier = Modifier.fillMaxSize()) {
        when (count) {
            0 -> {
                ArtSpaceCard(
                    drawableResourceID = R.drawable.img_20230305_wa0018,
                    contentDescriptionId = R.string.app_name,

                    onNextClick = { count++ },
                    onPrevClick = {
                        count = 7

                    })
            }
            1 -> {
                ArtSpaceCard(
                    drawableResourceID = R.drawable.img_20230305_wa0014,
                    contentDescriptionId = R.string.app_name,

                    onNextClick = { count++ },
                    onPrevClick = { count-- })
            }
            2 -> {
                ArtSpaceCard(
                    drawableResourceID = R.drawable.img_20230305_wa0015,
                    contentDescriptionId = R.string.app_name,

                    onNextClick = { count++ },
                    onPrevClick = { count-- })
            }
            3 -> {
                ArtSpaceCard(
                    drawableResourceID = R.drawable.img_20230305_wa0016,
                    contentDescriptionId = R.string.app_name,

                    onNextClick = { count++ },
                    onPrevClick = { count-- })
            }
            4 -> {
                ArtSpaceCard(
                    drawableResourceID = R.drawable.img_20230305_wa0017,
                    contentDescriptionId = R.string.app_name,

                    onNextClick = { count++ },
                    onPrevClick = { count-- })
            }
            5 -> {
                ArtSpaceCard(
                    drawableResourceID = R.drawable.img_20230305_wa0021,
                    contentDescriptionId = R.string.app_name,

                    onNextClick = { count++ },
                    onPrevClick = { count-- })
            }
            6 -> {
                ArtSpaceCard(
                    drawableResourceID = R.drawable.img_20230305_wa0020,
                    contentDescriptionId = R.string.app_name,

                    onNextClick = { count++ },
                    onPrevClick = { count-- })
            }
            7 -> {
                ArtSpaceCard(
                    drawableResourceID = R.drawable.img_20230305_wa0019,
                    contentDescriptionId = R.string.app_name,

                    onNextClick = { count++ },
                    onPrevClick = { count-- })
            }
        }
    }
}

@Composable
fun ArtSpaceCard(
    drawableResourceID: Int,
    contentDescriptionId: Int,
    onNextClick: () -> Unit,
    onPrevClick: () -> Unit,
    modifier: Modifier=Modifier
) {
    Column(modifier = modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = stringResource(id = R.string.welcome))
        Image(
            painter = painterResource(drawableResourceID),
            contentDescription = stringResource(contentDescriptionId),
            modifier= Modifier
                .width(400.dp)
                .height(700.dp)
                .padding(20.dp),
            contentScale = ContentScale.None
        )
        Spacer(modifier = Modifier.height(3.dp))

        Row(modifier = Modifier.fillMaxWidth() , horizontalArrangement = Arrangement.Center) {
            Button(onClick = onNextClick , modifier = Modifier
                .padding(10.dp)
                .width(100.dp)) {
                Text(text = "Previous")
            }
            Button(onClick = onPrevClick ,
                modifier
                    .padding(10.dp)
                    .width(100.dp)) {
                Text(text = "Next")
            }
        }
        


    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceAppTheme {
    ArtSpace();
    }
}