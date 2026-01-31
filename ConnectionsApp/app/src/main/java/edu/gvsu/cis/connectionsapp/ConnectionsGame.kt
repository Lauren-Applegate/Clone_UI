package edu.gvsu.cis.connectionsapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import edu.gvsu.cis.connectionsapp.ui.theme.ConnectionsAppTheme

@Composable
fun connectionsScreen (modifier: Modifier = Modifier){
    //TODO
}

@Preview(showBackground = true)
@Composable
fun connectionsScreenPreview () {
    ConnectionsAppTheme {
        connectionsScreen()
    }
}