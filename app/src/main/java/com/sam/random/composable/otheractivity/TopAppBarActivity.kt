package com.sam.random.composable.otheractivity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.sam.random.composable.R
import com.sam.random.composable.ui.theme.GreenJC
import com.sam.random.composable.ui.theme.RandomComposableTheme

class TopAppBarActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RandomComposableTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LearnTopAppBar()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LearnTopAppBar() {
    val context = LocalContext.current.applicationContext
    TopAppBar(
        title = { Text("Whatsapp")},
        navigationIcon = {
            IconButton(onClick = {
                Toast.makeText(context, "Whatsapp", Toast.LENGTH_LONG).show()
            })
            {
                Icon(painter = painterResource(R.drawable.baseline_whatsapp_24), contentDescription = "Whatsapp")
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = GreenJC,
            navigationIconContentColor = Color.White,
            titleContentColor = Color.White
        ),
        actions = {
            IconButton(onClick = {
                Toast.makeText(context, "Profile", Toast.LENGTH_LONG).show()
            }) {
                Icon(imageVector = Icons.Filled.Person, tint = Color.White, contentDescription = "Profile Icon")
            }

            IconButton(onClick = {
                Toast.makeText(context, "Search", Toast.LENGTH_LONG).show()
            }) {
                Icon(imageVector = Icons.Filled.Search, tint = Color.White, contentDescription = "Search Icon")
            }

            IconButton(onClick = {
                Toast.makeText(context, "Menu", Toast.LENGTH_LONG).show()
            }) {
                Icon(imageVector = Icons.Filled.MoreVert, tint = Color.White, contentDescription = "Menu Icon")
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun LearnTopAppBarPreview() {
    RandomComposableTheme {
        LearnTopAppBar()
    }
}