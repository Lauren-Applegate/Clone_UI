package edu.gvsu.cis.connectionsapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
            Spacer(Modifier.height(10.dp))
            //this function will create the icons for settings and others...
            TopControls()
            Spacer(Modifier.height(20.dp))
            // this function will create the text, "create 4 groups of four!"
            Title()
            Spacer(Modifier.height(15.dp))
            //this function will create all of the tiles to select
            TileGridVisual()
            Spacer(Modifier.height(20.dp))
            //this function will create the visual for how many mistakes you have left
            MistakesVisual()
            Spacer(Modifier.height(20.dp))
            //this function will create buttons that allow you to submit, shuffle, and deselect all
            BottomButtonsVisual()
            Spacer(modifier = modifier.weight(1f))
            //this function will create my name
            MadeBy()
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

@Composable
fun TopControls() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box() {
            Image(
                painter = painterResource(R.drawable.arrow),
                contentDescription = null,
                modifier = Modifier.size(25.dp)
            )
        }

        Row(horizontalArrangement = Arrangement.spacedBy(5.dp), modifier = Modifier.padding(start = 18.dp)) {
            Image(
                painter = painterResource(R.drawable.idea),
                contentDescription = null,
                modifier = Modifier.size(25.dp)
            )

            Image(
                painter = painterResource(R.drawable.stats),
                contentDescription = null,
                modifier = Modifier.size(25.dp)
            )

            Image(
                painter = painterResource(R.drawable.question),
                contentDescription = null,
                modifier = Modifier.size(28.dp)
            )

            Image(
                painter = painterResource(R.drawable.settings),
                contentDescription = null,
                modifier = Modifier.size(25.dp)
            )
        }

        Box(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
        ) {
            OutlinedButton(onClick = { }) {
                Text(text = "Subscribe to Games", color = Color.White)
            }
        }
    }
    // here is where I found how to use dividers
    // https://developer.android.com/develop/ui/compose/components/divider
    HorizontalDivider(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
        thickness = 0.5.dp,
        color = Color.DarkGray
    )
}

@Composable
fun Title(){
    Box(modifier = Modifier.padding(bottom = 15.dp)){
        Text(
            text = "Create four groups of four!",
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Light
        )
    }
}

@Composable
fun TileGridVisual() {
    val labels = listOf(
        "DRESS", "WISHBONE", "ROLLER", "BALL",
        "SHOWER", "STETHOSCOPE", "BRUSH", "MIXER",
        "SLINGSHOT", "SPRAY CAN", "RECEPTION", "COMPUTER KEY",
        "FLUCTUATION", "TUNING FORK", "WORK PERIOD", "PALETTE KNIFE"
    )
    // here is where I found how to do grids
    // https://developer.android.com/develop/ui/compose/lists
    LazyVerticalGrid(
        columns = GridCells.Fixed(4),
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        userScrollEnabled = false // static layout
    ) {
        items(labels) { label ->
            TileVisual(label)
        }
    }
}

@Composable
fun TileVisual(text: String) {
    Box(
        modifier = Modifier
            .background(
                color = Color(0xFFD8D8CC),
                shape = RoundedCornerShape(8.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = Color.Black,
            fontSize = 10.sp,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 25.dp, bottom = 25.dp)
        )
    }
}

@Composable
fun MistakesVisual(){
    Row (
        modifier = Modifier
            .padding(top = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)) {

            Text(text = "Mistakes remaining: ", color = Color(0xFFD8D8CC))
            repeat(4) {
                Box (modifier = Modifier
                    .size(15.dp)
                    .background(Color(0xFFD8D8CC), CircleShape))
        }
    }
}

@Composable
fun BottomButtonsVisual() {
    Row (verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        OutlinedButton(onClick = {}) {
            Text(text = "Shuffle", color = Color.White)
        }
        OutlinedButton(onClick = { }) {
            Text(text = "Deselect All")
        }

        OutlinedButton(onClick = { }) {
            Text(text = "Submit")
        }
    }
}

@Composable
fun MadeBy(){
    Text(text = "Connections Game recreated", color = Color(0xFFD8D8CC))
    Text(text = "by Lauren Applegate", color = Color(0xFFD8D8CC))
}
