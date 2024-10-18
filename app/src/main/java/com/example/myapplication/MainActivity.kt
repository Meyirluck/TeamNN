package com.example.myapplication

import android.os.Bundle
import android.service.autofill.OnClickAction
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MovieApp()

        }
    }
}

@Composable
@Preview
private fun Actions() {
    Column(
        modifier = Modifier
        .background(Color(0xFF12BF76)).fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Smartr",
            color = Color.White,
            style = TextStyle(
                fontSize = 35.sp
            ),
            modifier = Modifier
                .padding(0.dp, 60.dp, 0.dp, 20.dp)
            )

        Image(
            painter = painterResource(id = R.drawable.signup_man),
            contentDescription = "",
            modifier = Modifier
                .size(220.dp)
                .padding(25.dp)
        )
        Text(
            text = "Fresh look, Same login",
            modifier = Modifier
                .padding(0.dp, 0.dp, 0.dp, 30.dp),
            color =  Color.White,
            style = TextStyle(
                    fontSize = 25.sp
                    )
        )
        Box(
            modifier = Modifier
                .padding(0.dp, 0.dp, 30.dp, 0.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.switchh),
                    contentDescription = "",
                    modifier = Modifier
                        .size(50.dp)
                        .padding(10.dp)
                )
                Text(
                    text = "Smart Recruiters \ncandidate portal \nis now Smartr",
                    color = Color.White,
                    style = TextStyle(
                        fontSize = 15.sp
                    )
                )
            }
        }
        Box(
            modifier = Modifier.padding(0.dp, 25.dp, 30.dp, 25.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.login),
                    contentDescription = "",
                    modifier = Modifier
                        .size(50.dp)
                        .padding(10.dp)
                )
                Text(
                    text = "Smart Recruiters \ncandidate portal \nis now Smartr",
                    color = Color.White,
                    style = TextStyle(
                        fontSize = 15.sp
                    )
                )
            }
        }
        Box(
            modifier = Modifier
                .padding(0.dp, 0.dp, 30.dp, 0.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.refresh),
                    contentDescription = "",
                    modifier = Modifier
                        .size(50.dp)
                        .padding(10.dp)
                )
                Text(
                    text = "Smart Recruiters \ncandidate portal \nis now Smartr",
                    color = Color.White,
                    style = TextStyle(
                        fontSize = 15.sp
                    )
                )
            }
        }

        TextButton(
            onClick = {},
            modifier = Modifier
        ) {
            Text(
                text = "Why Smartr? Read here...",
                modifier = Modifier
                    .padding(10.dp, 55.dp, 0.dp, 5.dp),
                color = Color.White,
                style = TextStyle(
                    fontSize = 12.sp
                )
            )
        }
        Button(
            onClick = {},
            colors = ButtonColors(Color.White, Color.Black, Color.Red, Color.Blue),
            modifier = Modifier
                .size(250.dp, 40.dp)
        ) {
            Text(
                "GET STARTED",
                color = Color(0xFF12BF76)
            )
        }
    }


}







