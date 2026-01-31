package edu.gvsu.cis.connectionsapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edu.gvsu.cis.connectionsapp.ui.theme.ConnectionsAppTheme

@Composable
fun connectionsScreen (modifier: Modifier = Modifier){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0E0E0E))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            //TopControls() this function will create the icons for settings and others...
            Spacer(Modifier.height(20.dp))
            //Title() this function will create the text, "create 4 groups of four!"
            Spacer(Modifier.height(20.dp))
            //TileGridVisual() this function will create all of the tiles to select
            Spacer(Modifier.height(20.dp))
            //MistakesVisual() this function will create the visual for how many mistakes you have left
            Spacer(Modifier.height(20.dp))
            //BottomButtonsVisual() this function will create buttons that allow you to submit, shuffle, and deselect all
            Spacer(Modifier.height(20.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun connectionsScreenPreview () {
    ConnectionsAppTheme {
        connectionsScreen()
    }
}