package com.sam.random.composable

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sam.random.composable.ui.theme.RandomComposableTheme

class AlignmentArrangementActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RandomComposableTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ButtonImage()
                }
            }
        }
    }
}

@Composable
fun ButtonImage() {
    val context = LocalContext.current.applicationContext
    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Button(
            onClick = {Toast.makeText(context, "Button Clicked", Toast.LENGTH_LONG).show()},
            colors = ButtonColors(Color.Red, Color.White, Color.Gray, Color.LightGray),
            shape = RoundedCornerShape(10.dp),
            enabled = true,
        ) {
            Text("Click Me")
        }

        Image(painter = painterResource(R.drawable.androidparty), contentDescription = "Android Party")
    }
}


@Preview
@Composable
fun ButtonImagePreview() {
    ButtonImage()
}