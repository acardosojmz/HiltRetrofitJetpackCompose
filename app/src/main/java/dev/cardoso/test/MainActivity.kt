package dev.cardoso.test

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.AndroidEntryPoint
import dev.cardoso.test.core.NetworkUtils
import dev.cardoso.test.di.NetworkModule
import dev.cardoso.test.presentation.viewmodel.QuoteViewModel
import dev.cardoso.test.ui.theme.TestTheme
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    //modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   MyScreen()
                    //TxtField()

                }
            }
        }
    }
}

fun updateServer(quoteViewModel: QuoteViewModel){
    //NetworkModule.changeUrl(quoteViewModel.serverIP.value)
    NetworkUtils.BASE_URL = "http://" + quoteViewModel.serverIP.value
    quoteViewModel.getQuotes()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyScreen(quoteViewModel: QuoteViewModel =  viewModel())
{

    val quotes = quoteViewModel.quotes.observeAsState()

    Column {

        OutlinedTextField(
            value = quoteViewModel.serverIP.value,
            onValueChange = { quoteViewModel.refreshIP(it) },
            label = { Text("server Ip with port") },

            )


        Spacer(Modifier.size(16.dp))

        Button(
            onClick = { updateServer(quoteViewModel) }, // 7
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Aplicar")
        }

        Spacer(Modifier.size(16.dp))

        TxtResponse(value= quotes.value.toString(),  modifier = Modifier.padding(start = 16.dp),)

    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TxtField() {
    var text by remember { mutableStateOf("") }
    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("server Ip with port") },

    )
}

@Composable
fun TxtResponse(value: String, modifier: Modifier = Modifier) {
    Text(
        text = value,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TestTheme {
        //Greeting("Android")
    }
}