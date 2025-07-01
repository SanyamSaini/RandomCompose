package com.sam.random.composable.list

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.sam.random.composable.ui.theme.RandomComposableTheme

class ListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RandomComposableTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val fruits = listOf("Apple", "Banana", "Cherry", "Date", "Elderberry", "Fig", "Grape", "Honeydew", "Kiwi", "Lemon", "Mango", "Nectarine", "Orange", "Papaya", "Quince", "Raspberry", "Strawberry", "Tangerine", "Ugli fruit", "Vanilla", "Watermelon", "Xigua", "Yellow Passion Fruit", "Zucchini", "Apricot", "Blueberry", "Cantaloupe", "Dragonfruit", "Elderberry", "Fig", "Grape", "Honeydew", "Kiwi", "Lemon", "Mango", "Nectarine", "Orange", "Papaya", "Quince", "Raspberry", "Strawberry", "Tangerine", "Ugli fruit", "Vanilla", "Watermelon", "Xigua", "Yellow Passion Fruit", "Zucchini", "Apricot", "Blueberry", "Cantaloupe")
                    DisplayFruits(fruits)
                }
            }
        }
    }
}

@Composable
fun DisplayFruits(fruits: List<String>) {
//    Column {
//        fruits.forEach{
//            Text(text = it, fontSize = 30.sp, color = Color.Red)
//        }
//    }

//    LazyColumn {
//        items(fruits){
//            Text(text = it, fontSize = 30.sp, color = Color.Red)
//        }
//    }

    LazyRow {
        items(fruits){
            Text(text = it, fontSize = 30.sp, color = Color.Red)
        }
    }
}

@Preview
@Composable
fun DisplayFruitsPreview() {
    RandomComposableTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            val fruits = listOf("Apple", "Banana", "Cherry", "Date", "Elderberry", "Fig", "Grape", "Honeydew", "Kiwi", "Lemon", "Mango", "Nectarine", "Orange", "Papaya", "Quince", "Raspberry", "Strawberry", "Tangerine", "Ugli fruit", "Vanilla", "Watermelon", "Xigua", "Yellow Passion Fruit", "Zucchini", "Apricot", "Blueberry", "Cantaloupe", "Dragonfruit", "Elderberry", "Fig", "Grape", "Honeydew", "Kiwi", "Lemon", "Mango", "Nectarine", "Orange", "Papaya", "Quince", "Raspberry", "Strawberry", "Tangerine", "Ugli fruit", "Vanilla", "Watermelon", "Xigua", "Yellow Passion Fruit", "Zucchini", "Apricot", "Blueberry", "Cantaloupe")
            DisplayFruits(fruits)
        }
    }
}