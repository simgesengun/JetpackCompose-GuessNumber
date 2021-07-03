package com.example.guessnumberapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
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
import com.example.guessnumberapplication.ui.theme.GuessNumberApplicationTheme


@Composable
fun ResultScreen(navController : NavController, result : Boolean){
    Column(modifier = Modifier.fillMaxSize()
        , horizontalAlignment = Alignment.CenterHorizontally
        , verticalArrangement = Arrangement.SpaceAround) {

        if (result){
            Text(text = "You Win!",fontSize = 36.sp, fontWeight = FontWeight.Bold)
            Image(painter = painterResource(id = R.drawable.ic_happy)
                , contentDescription = "Happy Face")
        }else{
            Text(text = "You lose!",fontSize = 36.sp, fontWeight = FontWeight.Bold)
            Image(painter = painterResource(id = R.drawable.ic_sad)
                , contentDescription = "Sad Face")
        }
    }
}

@Preview(showBackground = true, name = "Result Screen")
@Composable
fun ResultPreview() {
    GuessNumberApplicationTheme {
    }
}