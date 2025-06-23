package com.sam.random.composable

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sam.random.composable.ui.theme.RandomComposableTheme

class LearnStateActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RandomComposableTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    StateFunction()
                }
            }
        }
    }
}

@Composable
fun StateFunction() {
//    var age = 0
    var age by remember {
        mutableIntStateOf(0)
    }

    Column {
        Button(onClick = {
            age++
        },
            shape = RoundedCornerShape(10.dp),
            colors = ButtonColors(Color.Blue, Color.White, Color.Gray, Color.LightGray)
        ) {
            Text(text = "I'm $age years old")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun StateFunctionPreview() {
    StateFunction()
}
