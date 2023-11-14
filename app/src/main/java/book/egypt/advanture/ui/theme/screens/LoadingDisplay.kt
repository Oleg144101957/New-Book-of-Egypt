package book.egypt.advanture.ui.theme.screens

import android.app.Activity
import android.content.pm.ActivityInfo
import android.util.Log
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import book.egypt.advanture.EgyptViewModel
import book.egypt.advanture.MainActivity
import book.egypt.advanture.R
import book.egypt.advanture.data.EgyptStorage
import book.egypt.advanture.ui.theme.Constants
import book.egypt.advanture.ui.theme.destinations.Displays
import kotlinx.coroutines.delay


@Composable
fun LoadingDisplay(navHostController: NavHostController, egyptViewModel: EgyptViewModel){
    val a = LocalContext.current as Activity
    a.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

    val context = LocalContext.current
    val egyptStorage = EgyptStorage(context)
    egyptViewModel.addDataIntoTheViewModel(egyptStorage.readData())

    val status = egyptViewModel.destination.observeAsState()

    Log.d("123123", "when in LoadingDisplay")


    when (status.value){
        Constants.oneList[3] -> { navHostController.navigate(Displays.Launcher.destination) }
        Constants.appsDevList[0] -> { egyptViewModel.buildLink(context) }
        else -> { MainActivity.navigateToAddActivity(context, status.value.toString()) }
    }

    val infiniteTransition = rememberInfiniteTransition()
    val rotation = infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1500, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    LaunchedEffect(Unit){

        delay(1750)
        navHostController.navigate(Displays.Launcher.destination)
    }

    Box(modifier = Modifier.fillMaxSize()){
        LoadingBackground()

        Image(
            painter = painterResource(id = R.drawable.pic6),
            contentDescription = "loading pic",
            modifier = Modifier
                .align(Alignment.Center)
                .size(128.dp)
                .graphicsLayer {
                    rotationZ = rotation.value
                }
        )

        Text(
            text = "Preparing screen...",
            color = Color.White,
            modifier = Modifier
                .align(Alignment.Center)
                .offset(y = 90.dp)
        )
    }
}


@Composable
fun LoadingBackground(){
    Image(
        painter = painterResource(id = R.drawable.backloading),
        contentDescription = "loading back",
        modifier = Modifier
            .fillMaxSize(),
        contentScale = ContentScale.FillBounds
    )
}