package book.egypt.advanture.ui.theme.screens

import android.app.Activity
import android.content.Context
import android.content.pm.ActivityInfo
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Constraints
import book.egypt.advanture.R
import book.egypt.advanture.ui.theme.Constants


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsDisplay(){
    val a = LocalContext.current as Activity
    a.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

    val context = LocalContext.current
    val shared = context.getSharedPreferences(Constants.SHARED, Context.MODE_PRIVATE)

    val text = remember {
        mutableStateOf("")
    }

    Box(modifier = Modifier
        .fillMaxSize()
    ){
        SettingsBackground()

        Column(modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.Center)
        ) {

            Text(
                text = "Enter your name",
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)

            )

            OutlinedTextField(
                value = text.value,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                onValueChange = {
                    text.value = it
                    shared.edit().putString(Constants.SHARED_NAME, it).apply()
                }
            )
        }
    }
}


@Composable
fun SettingsBackground(){
    Image(
        painter = painterResource(id = R.drawable.backloading),
        contentDescription = "launcher back",
        modifier = Modifier
            .fillMaxSize(),
        contentScale = ContentScale.FillBounds
    )
}