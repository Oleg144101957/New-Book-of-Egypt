package book.egypt.advanture.ui.theme.screens

import android.app.Activity
import android.content.Context
import android.content.pm.ActivityInfo
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import book.egypt.advanture.R
import book.egypt.advanture.ui.theme.Constants
import kotlinx.coroutines.delay


@Composable
fun PlaygroundDisplay(navHostController: NavHostController){

    val a = LocalContext.current as Activity
    a.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

    Box(modifier = Modifier
        .fillMaxSize()
    ){
        GameBackground()
        GameSurface()
    }
}

@Composable
fun GameBackground(){
    Image(
        painter = painterResource(id = R.drawable.backplay),
        contentDescription = "launcher back",
        modifier = Modifier
            .fillMaxSize(),
        contentScale = ContentScale.FillBounds
    )
}


@Composable
fun BoxScope.GameSurface(){
    val screenOlympusHeight = LocalConfiguration.current.screenHeightDp

    val context = LocalContext.current
    val shared = context.getSharedPreferences(Constants.SHARED, Context.MODE_PRIVATE)
    val userName = shared.getString(Constants.SHARED_NAME, "User")

    val score = remember{
        mutableStateOf(0)
    }

    val fallingSpeed = remember {
        mutableStateOf(3500)
    }

    val ani1 = remember {
        Animatable(initialValue = 0f)
    }

    val ani2 = remember {
        Animatable(initialValue = 0f)
    }

    val ani3 = remember {
        Animatable(initialValue = 0f)
    }

    val ani4 = remember {
        Animatable(initialValue = 0f)
    }

    val ani5 = remember {
        Animatable(initialValue = 0f)
    }

    val ani6 = remember {
        Animatable(initialValue = 0f)
    }


    val isVisible1 = remember {
        mutableStateOf(true)
    }

    val isVisible2 = remember {
        mutableStateOf(true)
    }

    val isVisible3 = remember {
        mutableStateOf(true)
    }

    val isVisible4 = remember {
        mutableStateOf(true)
    }

    val isVisible5 = remember {
        mutableStateOf(true)
    }

    val isVisible6 = remember {
        mutableStateOf(true)
    }


    LaunchedEffect(key1 = "anim1"){
        ani1.animateTo(
            targetValue = screenOlympusHeight.toFloat(),
            animationSpec = infiniteRepeatable(
                tween(fallingSpeed.value, delayMillis = 150, easing = FastOutLinearInEasing),
                repeatMode = RepeatMode.Restart
            )
        )
    }

    LaunchedEffect(key1 = "anim2"){
        ani2.animateTo(
            targetValue = screenOlympusHeight.toFloat(),
            animationSpec = infiniteRepeatable(
                tween(fallingSpeed.value, delayMillis = 300, easing = FastOutLinearInEasing),
                repeatMode = RepeatMode.Restart
            )
        )
    }

    LaunchedEffect(key1 = "anim3"){
        ani3.animateTo(
            targetValue = screenOlympusHeight.toFloat(),
            animationSpec = infiniteRepeatable(
                tween(fallingSpeed.value, delayMillis = 500, easing = FastOutLinearInEasing),
                repeatMode = RepeatMode.Restart
            )
        )
    }

    LaunchedEffect(key1 = "anim4"){
        ani4.animateTo(
            targetValue = screenOlympusHeight.toFloat(),
            animationSpec = infiniteRepeatable(
                tween(fallingSpeed.value, delayMillis = 50, easing = FastOutLinearInEasing),
                repeatMode = RepeatMode.Restart
            )
        )
    }

    LaunchedEffect(key1 = "anim5"){
        ani5.animateTo(
            targetValue = screenOlympusHeight.toFloat(),
            animationSpec = infiniteRepeatable(
                tween(fallingSpeed.value, delayMillis = 150, easing = FastOutLinearInEasing),
                repeatMode = RepeatMode.Restart
            )
        )
    }

    LaunchedEffect(key1 = "anim6"){
        ani6.animateTo(
            targetValue = screenOlympusHeight.toFloat(),
            animationSpec = infiniteRepeatable(
                tween(fallingSpeed.value, delayMillis = 500, easing = FastOutLinearInEasing),
                repeatMode = RepeatMode.Restart
            )
        )
    }

    LaunchedEffect(Unit){
        repeat(64){
            delay(4000)
            isVisible1.value = true
            isVisible2.value = true
            isVisible3.value = true
            isVisible4.value = true
            isVisible5.value = true
            isVisible6.value = true
        }
    }

    
    //Scores box
    Box(modifier = Modifier
        .align(Alignment.TopCenter)
        .padding(top = 128.dp)

    ){

        Text(
            text = "Hello dear $userName",
            color = Color.White,
            modifier = Modifier
                .align(Alignment.TopCenter)
        )

        Image(
            painter = painterResource(id = R.drawable.decor2),
            contentDescription = "Score background",
            modifier = Modifier
                .align(Alignment.Center)
                .padding(32.dp)
        )

        Text(
            text = "Score ${score.value}",
            color = Color.White,
            modifier = Modifier
                .align(Alignment.Center)
                .padding(32.dp)

        )
    }
    
    Image(
        painter = painterResource(id = R.drawable.light1),
        contentDescription = "light",
        modifier = Modifier
            .align(Alignment.BottomCenter)
            .size(480.dp)
            .alpha(0.8f)
    )

    if (isVisible1.value){
        Image(
            painter = painterResource(id = R.drawable.pic7),
            contentDescription = "art1",
            modifier = Modifier
                .offset(y = ani1.value.dp, x = 33.dp)
                .align(Alignment.TopCenter)
                .clickable {
                    score.value += 1
                    isVisible1.value = false
                    fallingSpeed.value -= 200
                }
        )
    }

    if (isVisible2.value){
        Image(
            painter = painterResource(id = R.drawable.pic8),
            contentDescription = "art2",
            modifier = Modifier
                .offset(y = ani2.value.dp, x = (-33).dp)
                .align(Alignment.TopCenter)
                .clickable {
                    score.value += 1
                    isVisible2.value = false
                    fallingSpeed.value -= 200
                }
        )
    }

    if (isVisible3.value){
        Image(
            painter = painterResource(id = R.drawable.pick9),
            contentDescription = "art3",
            modifier = Modifier
                .offset(y = ani3.value.dp, x = (-45).dp)
                .align(Alignment.TopCenter)
                .clickable {
                    score.value += 1
                    isVisible3.value = false
                    fallingSpeed.value -= 200
                }
        )
    }

    if (isVisible4.value){
        Image(
            painter = painterResource(id = R.drawable.pic10),
            contentDescription = "art4",
            modifier = Modifier
                .offset(y = ani4.value.dp, x = (+45).dp)
                .align(Alignment.TopCenter)
                .clickable {
                    score.value += 1
                    isVisible4.value = false
                    fallingSpeed.value -= 200
                }
        )
    }

    if (isVisible5.value){
        Image(
            painter = painterResource(id = R.drawable.pick11),
            contentDescription = "art5",
            modifier = Modifier
                .offset(y = ani5.value.dp)
                .align(Alignment.TopCenter)
                .clickable {
                    score.value += 1
                    isVisible5.value = false
                    fallingSpeed.value -= 200
                }
        )
    }

    if (isVisible6.value){
        Image(
            painter = painterResource(id = R.drawable.pick12),
            contentDescription = "art6",
            modifier = Modifier
                .offset(y = ani6.value.dp)
                .align(Alignment.TopCenter)
                .clickable {
                    score.value += 1
                    isVisible6.value = false
                    fallingSpeed.value -= 200
                }
        )
    }
}