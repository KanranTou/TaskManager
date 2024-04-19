package com.example.task_manager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.task_manager.ui.theme.Task_managerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Task_managerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    InformationImage(
                        status = stringResource(R.string.tasks_status_text),
                        compliment = stringResource(R.string.compliment_text)
                    )
                }
            }
        }
    }
}

@Composable
fun InformationText(status: String, compliment: String, modifier: Modifier = Modifier) {
    Text(
        text = status,
        fontWeight = FontWeight.Bold,
        modifier = modifier
            .padding(
                top = 24.dp,
                bottom = 8.dp
            )
    )
    Text(
        text = compliment,
        fontSize = 16.sp,
    )
}

@Composable
fun InformationImage(status: String, compliment: String, modifier: Modifier = Modifier){
    val image = painterResource(id = R.drawable.ic_task_completed)
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
    ) {
        Image(
            painter = image,
            contentDescription = null,
        )
        InformationText(
            status = status,
            compliment = compliment
        )
    }
}

@Preview(showBackground = true)
@Composable
fun InformationPreview() {
    InformationImage(
        status = stringResource(R.string.tasks_status_text),
        compliment = stringResource(R.string.compliment_text)
    )
}