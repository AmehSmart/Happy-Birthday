package com.smart.happybirthday

import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.smart.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HappyBirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // here is the content block like what is to display in the ui
                    // Add your content here
                    GreetingText(message = "Happy Birthday Ameh!",
                        from = "From Smart",
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    }
}
// now i need to delete the greeting func and i can create mine
//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}

// This func display the text in the ui, it does that by calling the Text() composable func
// adding row or
@Composable
fun GreetingText(message: String,from:String, modifier: Modifier = Modifier){
    // here we will add a text composable greeting
    Column (

        // here we get the text to be arange to the center
        verticalArrangement = Arrangement.Center,
        modifier = modifier

    ){
            Text(

                // here we set the text to the arg being pass as message and datatype is string
                text = message,
                fontSize = 100.sp,
                lineHeight = 116.sp,
                textAlign = TextAlign.Center

            )
            Text(

                text = from,
                fontSize = 36.sp,
                modifier = Modifier
                    .padding(16.dp)
                    .align(alignment = androidx.compose.ui.Alignment.End)


            )
    }
    }




// in this code the preview func is calling the greeting func inside it and displaying it in the ui
// it is display with the help of the composable that tell that this is for ui
// in order to view or display the text we will call it here
@Preview(showBackground = true, showSystemUi = true, name = "My app view")
@Composable
fun BirthdayCardPreview() {
    HappyBirthdayTheme {
        // Greeting("Ameh") here also i delete the call
        // here i will call it
        GreetingText(message = "Happy Birthday Ameh!",
            from = "Smart"
            )

    }
}