package com.dinesh.xtweet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.dinesh.xtweet.api.TweetAPI
import com.dinesh.xtweet.screens.CategoryScreen
import com.dinesh.xtweet.screens.DetailScreen
import com.dinesh.xtweet.ui.theme.XTweetTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            XTweetTheme {
                Scaffold(
                   topBar = {
                       TopAppBar(title = {
                           Text(text = "XTweet")
                       }, Modifier.background(Color.Black))
                   }
                ) {
                    Box(
                        modifier = Modifier.padding(it)){
                        App()
                    }
                }
            }
        }
    }
}

@Composable
fun App(){

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "category"){
        composable(route = "category") {
            CategoryScreen {
                navController.navigate("detail/${it}")
            }
        }
        composable(route = "detail/{category}",
        arguments = listOf(navArgument("category"){
            type = NavType.StringType
        })
        )
        {
            DetailScreen()
        }
    }

}