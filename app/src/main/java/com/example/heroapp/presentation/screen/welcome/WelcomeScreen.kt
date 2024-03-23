package com.example.heroapp.presentation.screen.welcome

import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.heroapp.domain.model.OnBoardingPage
import com.example.heroapp.ui.theme.activeColor
import com.example.heroapp.ui.theme.buttonColor
import com.example.heroapp.ui.theme.descriptionColor
import com.example.heroapp.ui.theme.inActiveColor
import com.example.heroapp.ui.theme.titleColor
import com.example.heroapp.ui.theme.welcomeOnBoardScreenColor
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun WelcomeScreen(navHostController: NavHostController) {
    val pages = listOf(OnBoardingPage.First,OnBoardingPage.Second,OnBoardingPage.Third)
    val pageState  = rememberPagerState()
    Column(modifier = Modifier.background(color = MaterialTheme.colors.welcomeOnBoardScreenColor)) {
        HorizontalPager(
            modifier = Modifier.weight(9f),
            count = 3,
            state = pageState,
            verticalAlignment = Alignment.Top
        ) {
            Welcome(onBoardingPage = pages[it])
        }
        
        HorizontalPagerIndicator(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterHorizontally),
            pagerState = pageState,
            activeColor = MaterialTheme.colors.activeColor,
            inactiveColor = MaterialTheme.colors.inActiveColor,
            indicatorWidth = 12.dp,
            spacing = 8.dp
        )
        FinishButton(pagerState = pageState) {
            
        }
        
    }
}

@Composable
fun Welcome(onBoardingPage: OnBoardingPage) {
    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally,modifier = Modifier.background(MaterialTheme.colors.welcomeOnBoardScreenColor)) {
        Image(painter = painterResource(id = onBoardingPage.image), contentDescription = onBoardingPage.description )
        Text(
            text = onBoardingPage.title,
            color = MaterialTheme.colors.titleColor,
            fontSize = MaterialTheme.typography.h4.fontSize,
            modifier = Modifier
                .padding(horizontal = 40.dp)
                .padding(top = 10.dp),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Text(
            text = onBoardingPage.description,
            color = MaterialTheme.colors.descriptionColor,
            fontSize = MaterialTheme.typography.subtitle1.fontSize,
            modifier = Modifier
                .padding(horizontal = 40.dp)
                .padding(top = 10.dp),
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center
        )
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun FinishButton(
    pagerState: PagerState,
    onClick:()->Unit
) {
    
    Row(modifier = Modifier.padding(12.dp)){
        AnimatedVisibility(visible = pagerState.currentPage == 2) {
            Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(contentColor = Color.White, backgroundColor = MaterialTheme.colors.buttonColor),modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(12.dp)) {
                Text(text = "Finish")
            }
        }
    }

}