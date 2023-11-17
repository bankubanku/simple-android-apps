package com.example.lemonadeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonadeapp.ui.theme.LemonadeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeAppTheme {
                ProcessOfMakingLemonade(
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
        }
    }
}

data class StageInfo(
    val stage: Int,
    val imageId: Int,
    val imageDescId: Int,
    val processDescId: Int
)
@Composable
fun ProcessOfMakingLemonade(modifier: Modifier = Modifier) {
    var click by remember { mutableStateOf( 1 ) }

    val stageInfo = when(click) {
        1 -> StageInfo(1,
                       R.drawable.lemon_tree,
                       R.string.lemon_tree,
                       R.string.select_lemon)
        2, 3, 4, 5 -> StageInfo(2,
                       R.drawable.lemon_squeeze,
                       R.string.lemon,
                       R.string.squeeze_lemon)
        6 -> StageInfo(3,
                       R.drawable.lemon_drink,
                       R.string.glass_of_lemonade,
                       R.string.drink_lemonade)
        else -> StageInfo(4,
                          R.drawable.lemon_restart,
                          R.string.empty_glass,
                          R.string.start_again)
    }

    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .clip(MaterialTheme.shapes.extraLarge)
                .clickable {
                    click = when(click) {
                        1 -> click + 1
                        in 2..4 -> click + (1..2).random()
                        5, 6 -> click + 1
                        else -> 1
                    }
                }
        )   {
            Image(
                painter = painterResource(id = stageInfo.imageId),
                contentDescription = stringResource(id = stageInfo.imageDescId),
                modifier = Modifier
                    .background(color = colorResource(id = R.color.green))
                    .padding(horizontal = 30.dp, vertical = 20.dp)
            )
        }
        Text(
            text = stringResource(id = stageInfo.processDescId),
            modifier = Modifier
                .padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProcessOfMakingLemonadePreview() {
    LemonadeAppTheme {
        ProcessOfMakingLemonade(
            modifier = Modifier
                .fillMaxSize()
        )
    }
}