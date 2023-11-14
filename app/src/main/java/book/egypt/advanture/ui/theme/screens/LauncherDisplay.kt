package book.egypt.advanture.ui.theme.screens

import android.app.Activity
import android.content.pm.ActivityInfo
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import book.egypt.advanture.R
import book.egypt.advanture.ui.theme.YellowEgypt
import book.egypt.advanture.ui.theme.destinations.Displays


@Composable
fun LauncherDisplay(navHostController: NavHostController){
    val a = LocalContext.current as Activity
    a.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    
    Box(modifier = Modifier.fillMaxSize()){
        LauncherBackground()

        Image(
            painter = painterResource(id = R.drawable.pharaoh),
            contentDescription = "Pharaon",
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 128.dp)
                .alpha(0.5f)
        )
        
        Column(modifier = Modifier
            .align(Alignment.BottomCenter)
            .padding(bottom = 256.dp)
        ){
            ElevatedButton(
                modifier = Modifier.width(256.dp),
                colors = ButtonDefaults.buttonColors(containerColor = YellowEgypt),
                onClick = {
                navHostController.navigate(Displays.Playground.destination)
            }) {
                Text(text = "Play game")
            }

            ElevatedButton(
                modifier = Modifier.width(256.dp),
                colors = ButtonDefaults.buttonColors(containerColor = YellowEgypt),
                onClick = {
                navHostController.navigate(Displays.Settings.destination)
            }) {
                Text(text = "Settings")
            }


        }
    }
    
    
    
}

@Composable
fun LauncherBackground(){
    Image(
        painter = painterResource(id = R.drawable.backloading),
        contentDescription = "launcher back",
        modifier = Modifier
            .fillMaxSize(),
        contentScale = ContentScale.FillBounds
    )
}