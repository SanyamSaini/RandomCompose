package com.sam.random.composable.otheractivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.sam.random.composable.ui.theme.RandomComposableTheme

class ConstraintLayoutActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RandomComposableTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LearnConstraintLayout()
                }
            }
        }
    }
}

@Composable
fun LearnConstraintLayout() {
    ConstraintLayout {
        val (redButton, greenButton, blueButton, blackButton) = createRefs()

        Button(onClick = {}, colors = ButtonDefaults.buttonColors(Color.Red), modifier = Modifier.constrainAs(redButton){
            top.linkTo(parent.top)
            width = Dimension.matchParent
            height = Dimension.wrapContent
        }) {
            Text(text = "Red")
        }

        Button(onClick = {}, colors = ButtonDefaults.buttonColors(Color.Green), modifier = Modifier.constrainAs(greenButton){
            top.linkTo(redButton.bottom)
        }) {
            Text(text = "Green")
        }

        Button(onClick = {}, colors = ButtonDefaults.buttonColors(Color.Blue), modifier = Modifier.constrainAs(blueButton){
            top.linkTo(redButton.bottom)
        }) {
            Text(text = "Blue")
        }

        createHorizontalChain(greenButton, blueButton, chainStyle = ChainStyle.Packed)

        val guideline = createGuidelineFromBottom(0.01f)

        Button(onClick = {}, colors = ButtonDefaults.buttonColors(Color.Black), modifier = Modifier.constrainAs(blackButton){
            bottom.linkTo(guideline)
        }) {
            Text(text = "Black")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LearnConstraintLayoutPreview() {
    RandomComposableTheme {
        LearnConstraintLayout()
    }
}