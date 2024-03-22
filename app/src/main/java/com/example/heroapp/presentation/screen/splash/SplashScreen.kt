package com.example.heroapp.presentation.screen.splash

import android.content.res.Configuration
import android.window.SplashScreen
import androidx.compose.animation.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.heroapp.R
import com.example.heroapp.ui.theme.Purple500
import com.example.heroapp.ui.theme.Purple700

@Composable
fun SplashScreen(navHostController: NavHostController) {
    val degrees = remember {
        androidx.compose.animation.core.Animatable(0f)
    }
    LaunchedEffect(key1 = true){
        degrees.animateTo(360f,
            animationSpec = tween(
                durationMillis = 1000,
                delayMillis = 200
            )
        )

    }
    Splash(degrees.value)
}

@Composable
fun Splash(degrees:Float) {
    if (isSystemInDarkTheme()){
        Box(modifier = Modifier
            .background(Color.Black)
            .fillMaxSize(), contentAlignment = Alignment.Center){

            Image(modifier = Modifier.rotate(degrees),painter = painterResource(id = R.drawable.logo), contentDescription = stringResource(R.string.app_logo) )

        }
    }else{
        Box(modifier = Modifier
            .background(brush = Brush.verticalGradient(listOf(Purple700, Purple500)))
            .fillMaxSize(), contentAlignment = Alignment.Center){

            Image(modifier = Modifier.rotate(degrees),painter = painterResource(id = R.drawable.logo), contentDescription = stringResource(R.string.app_logo) )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview(){
//    Splash()
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun SplashScreenDarkPreview(){
//    Splash()
}