package com.example.guessnumberapplication

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.guessnumberapplication.ui.theme.GuessNumberApplicationTheme
import kotlin.random.Random


@Composable
fun GuessScreen(navController : NavController){
    val tfGuess = remember { mutableStateOf("") }
    val count = remember { mutableStateOf(5) }
    val helper = remember { mutableStateOf("") }
    val randomNumber = remember { mutableStateOf(0) }

    LaunchedEffect(key1 = true){
        randomNumber.value = (0..100).random()
        Log.e("randomNumber", randomNumber.value.toString())
    }

    Column(modifier = Modifier.fillMaxSize()
        , horizontalAlignment = Alignment.CenterHorizontally
        , verticalArrangement = Arrangement.SpaceAround) {

        Text(text = "Remaining Guesses: ${count.value}"
            , fontSize = 36.sp
            , fontWeight = FontWeight.Bold
            , color = Color.Blue)
        Text(text = "Helper: ${helper.value}"
            , fontSize = 24.sp)
        TextField(value = tfGuess.value
            , onValueChange = { tfGuess.value = it }
            , label = { Text(text="Guess") })
        Button(onClick = {
                            count.value = count.value - 1
                            val guess = tfGuess.value.toInt()
                            if(randomNumber.value == guess){
                                navController.navigate("result_screen/true"){
                                    popUpTo("guess_screen") { inclusive = true }
                                }
                                return@Button
                            }else if(randomNumber.value > guess){
                                helper.value = "Increase"
                            }else{
                                helper.value = "Decrease"
                            }
                            if(count.value == 0){
                                navController.navigate("result_screen/false"){
                                    popUpTo("guess_screen") { inclusive = true }
                                }
                            }
                            tfGuess.value = ""
                         }
            , modifier = Modifier.size(width = 250.dp, height = 50.dp)) {
            Text("Guess")
        }
    }
}


@Preview(showBackground = true, name = "Guess Screen")
@Composable
fun GuessPreview() {
    GuessNumberApplicationTheme {
    }
}