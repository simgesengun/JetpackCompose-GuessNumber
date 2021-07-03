package com.example.guessnumberapplication

import android.icu.text.CaseMap
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.guessnumberapplication.ui.theme.GuessNumberApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GuessNumberApplicationTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Navigation()
                }
            }
        }
    }
}

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController
        , startDestination = "homepage"){
        composable("homepage"){
            Homepage(navController)
        }
        composable("guess_screen"){
            GuessScreen(navController)
        }
        composable("result_screen/{result}", arguments = listOf(
            navArgument("result"){ type = NavType.BoolType }
        )){
            val result = it.arguments?.getBoolean("result")!!
            ResultScreen(navController, result)
        }
    }
}

@Composable
fun Homepage(navController : NavController){
    Column(modifier = Modifier.fillMaxSize()
        , horizontalAlignment = Alignment.CenterHorizontally
        , verticalArrangement = Arrangement.SpaceAround) {
        Text(text = "Number Guessing Game",fontSize = 36.sp, fontWeight = FontWeight.Bold)
        Image(painter = painterResource(id = R.drawable.ic_dice)
            , contentDescription = "Dice")
        Button(onClick = { navController.navigate("guess_screen") }
            , modifier = Modifier.size(width = 250.dp, height = 50.dp)) {
            Text("Start")
        }
    }
}



@Preview(showBackground = true, name = "Homepage Screen")
@Composable
fun HomepagePreview() {
    GuessNumberApplicationTheme {
    }
}