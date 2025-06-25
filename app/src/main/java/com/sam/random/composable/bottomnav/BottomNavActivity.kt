package com.sam.random.composable.bottomnav

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sam.random.composable.ui.theme.GreenJC
import com.sam.random.composable.ui.theme.RandomComposableTheme

class BottomNavActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RandomComposableTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BottomNav()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNav() {
    val navigationController = rememberNavController()
    val context = LocalContext.current.applicationContext
    val selected = remember {
        mutableStateOf(Icons.Default.Home)
    }
    val sheetState = rememberModalBottomSheetState()
    var showBottomSheet by remember {
        mutableStateOf(false)
    }

    Scaffold(
        bottomBar = {
            BottomAppBar(containerColor = GreenJC) {
                IconButton(onClick = {
                    selected.value = Icons.Default.Home
                    navigationController.navigate(BottomScreens.Home.screenName){
                        popUpTo(0)
                    }
                },
                    modifier = Modifier.weight(1f)) {
                    Icon(Icons.Default.Home, contentDescription = "Home Screen", modifier = Modifier.size(26.dp),
                        tint = if (selected.value == Icons.Default.Home) Color.White else Color.DarkGray)
                }

                IconButton(onClick = {
                    selected.value = Icons.Default.Search
                    navigationController.navigate(BottomScreens.Search.screenName){
                        popUpTo(0)
                    }
                },
                    modifier = Modifier.weight(1f)) {
                    Icon(Icons.Default.Search, contentDescription = "Search Screen", modifier = Modifier.size(26.dp),
                        tint = if (selected.value == Icons.Default.Search) Color.White else Color.DarkGray)
                }

                Box(modifier = Modifier.weight(1f).padding(16.dp), contentAlignment = Alignment.Center) {
                    FloatingActionButton(onClick = {
                        showBottomSheet = true
                    }) {
                        Icon(Icons.Default.Add, contentDescription = "Open Bottom Sheet", tint = GreenJC)
                    }
                }

                IconButton(onClick = {
                    selected.value = Icons.Default.Notifications
                    navigationController.navigate(BottomScreens.Notification.screenName){
                        popUpTo(0)
                    }
                },
                    modifier = Modifier.weight(1f)) {
                    Icon(Icons.Default.Notifications, contentDescription = "Notification Screen", modifier = Modifier.size(26.dp),
                        tint = if (selected.value == Icons.Default.Notifications) Color.White else Color.DarkGray)
                }

                IconButton(onClick = {
                    selected.value = Icons.Default.Person
                    navigationController.navigate(BottomScreens.Profile.screenName){
                        popUpTo(0)
                    }
                },
                    modifier = Modifier.weight(1f)) {
                    Icon(Icons.Default.Person, contentDescription = "Profile Screen", modifier = Modifier.size(26.dp),
                        tint = if (selected.value == Icons.Default.Person) Color.White else Color.DarkGray)
                }
            }
        }
    ) {paddingValues ->
        NavHost(
            navController = navigationController,
            startDestination = BottomScreens.Home.screenName,
            modifier = Modifier.padding(paddingValues)) {
            composable(BottomScreens.Home.screenName) { BottomHome() }
            composable(BottomScreens.Search.screenName) { BottomSearch() }
            composable(BottomScreens.Notification.screenName) { BottomNotification() }
            composable(BottomScreens.Profile.screenName) { BottomProfile() }
            composable(BottomScreens.Post.screenName) { BottomSheetPost() }
        }
    }

    if (showBottomSheet) {
        ModalBottomSheet(onDismissRequest = { showBottomSheet = false},
            sheetState = sheetState) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)) {
                BottomSheetItem(Icons.Default.ThumbUp, "Create a post") {
                    showBottomSheet = false
                    navigationController.navigate(BottomScreens.Post.screenName){
                        popUpTo(0)
                    }
                }

                BottomSheetItem(Icons.Default.Star, "Add a story") {
                    Toast.makeText(context, "Story", Toast.LENGTH_SHORT).show()
                }

                BottomSheetItem(Icons.Default.PlayArrow, "Create a Reel") {
                    Toast.makeText(context, "Reel", Toast.LENGTH_SHORT).show()
                }

                BottomSheetItem(Icons.Default.Favorite, "Go Live") {
                    Toast.makeText(context, "Live", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}

@Composable
fun BottomSheetItem(icon : ImageVector, title : String, onClick : () -> Unit){
    Row(verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.clickable { onClick() }) {
        Icon(icon, contentDescription = title, tint = GreenJC)
        Text(text = title, color = GreenJC, fontSize = 22.sp)

    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavPreview() {
    RandomComposableTheme {
        BottomNav()
    }
}