package com.example.aboutmeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aboutmeapp.ui.theme.AboutMeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AboutMeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AboutMeApp()
                }
            }
        }
    }
}

@Composable
fun AboutMeApp(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(top = 100.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.sanji_cat),
            contentDescription = "Image of Sanji from one piece smiling. He has a cat ears too"
        )
        Text(
            text = "Jakub \"banku\" Woźniczka",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(top = 10.dp, bottom = 5.dp)
        )
        Text(text = "aspiring hacker", fontSize = 18.sp)
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .padding(bottom = 20.dp)
            .fillMaxWidth()
    ) {
        Row (
            modifier = Modifier
                .padding(vertical = 5.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.envelope_solid ),
                contentDescription = null,
                tint = Color(0xFF645068),
                modifier = Modifier
                    .size(24.dp)
                    .padding(end = 5.dp)
            )
            Text(text = "wozniczka.jakub@proton.me", fontSize = 18.sp)
        }
        Row (
            modifier = Modifier
                .padding(vertical = 5.dp)
        ){
            Icon(
                painter = painterResource(id = R.drawable.mastodon),
                contentDescription = null,
                tint = Color(0xFF645068),
                modifier = Modifier
                    .size(24.dp)
                    .padding(end = 5.dp)
            )
            Text(text = "tech.lgbt/@b4nq", fontSize = 18.sp)
        }
        Row (
            modifier = Modifier
                .padding(vertical = 5.dp)
        ){
            Icon(
                painter = painterResource(id = R.drawable.square_share_nodes_solid),
                contentDescription = null,
                tint = Color(0xFF645068),
                modifier = Modifier
                    .size(24.dp)
                    .padding(end = 5.dp)
            )
            Text(text = "bankubanku.github.io", fontSize = 18.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFF7B3C2)
    ) {
        AboutMeApp()
    }
}