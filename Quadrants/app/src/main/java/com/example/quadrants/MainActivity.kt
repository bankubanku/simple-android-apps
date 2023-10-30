package com.example.quadrants

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quadrants.ui.theme.QuadrantsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuadrantsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Quadrants()
                }
            }
        }
    }
}

@Composable
fun Quadrant(title: String, desc: String, color: Color, width: Float, height: Float) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(color = color)
            .fillMaxWidth(width)
            .fillMaxHeight(height)
            .padding(16.dp)
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = desc,
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun Quadrants() {
    Column (
         modifier = Modifier
             .fillMaxSize()
    ) {
        Row {
            Quadrant(
                stringResource(R.string.text_composable),
                stringResource(R.string.text_composable_desc),
                Color(0xFFEADDFF),
                0.5f,
                0.5f
            )
            Quadrant(
                stringResource(R.string.image_composable),
                stringResource(R.string.image_composable_desc),
                Color(0xFFD0BCFF),
                1f,
                0.5f
            )
        }
        Row {
            Quadrant(
                stringResource(R.string.row_composable),
                stringResource(R.string.row_composable_desc),
                Color(0xFFB69DF8),
                0.5f,
                1f
            )
            Quadrant(
                stringResource(R.string.column_composable),
                stringResource(R.string.columnt_composable_desc),
                Color(0xFFF6EDFF),
                1f,
                1f
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun QuadrantsPreview() {
    QuadrantsTheme {
        Quadrants()
    }
}