package com.sam.random.composable.otheractivity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sam.random.composable.R
import com.sam.random.composable.bottomnav.BottomNav
import com.sam.random.composable.ui.theme.RandomComposableTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RandomComposableTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                )
                {
                    DisplayNavComponent()
                }
            }
        }
    }

    @Composable
    private fun LearnTextAndModifier() {
        val clickOnText = { Toast.makeText(this, "Clicked on Text", Toast.LENGTH_SHORT).show()}
        Text(
            text = stringResource(R.string.happy_birthday_text),
            color = Color.Red,
            fontSize = 24.sp,
            fontStyle = FontStyle.Italic,
            modifier = Modifier.padding(12.dp)
                .background(color = Color.Black, shape = RectangleShape)
                .clickable { clickOnText }
        )
    }

    @Composable
    @Preview(showBackground = true)
    private fun LearnTextAndModifierPreview() {
//        LearnTextAndModifier()
    }

    @Composable
    private fun MainScreen(navController: NavController) {
        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Main Screen", fontSize = 30.sp)
            Button(onClick = {navController.navigate("BottomNavigation")}) {
                Text(text = "Go To Bottom Navigation")
            }
        }
    }

    @Composable
    private fun DisplayNavComponent() {
        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = "MainScreen") {
            composable("MainScreen") {
                MainScreen(navController)
            }

            composable("BottomNavigation") {
                BottomNav()
            }
        }
    }
}