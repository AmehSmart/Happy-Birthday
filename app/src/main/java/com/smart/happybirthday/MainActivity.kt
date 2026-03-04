package com.smart.happybirthday

import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
                    GreetingImage(
                        message = stringResource(R.string.happy_birthday_ameh),
                        from = stringResource(R.string.signature_text),

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
                    .align(alignment = Alignment.CenterHorizontally)// here it just align it center horizontally


            )
    }
    }


@Composable
fun GreetingImage(message: String, from:String, modifier: Modifier=Modifier){
    val image = painterResource(
        R.drawable
            .androidparty)
    Box(modifier) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,// here we resize by cropping
            alpha = 0.5F // here we set the opacity of the image

        )
        GreetingText(
            message = message,
            from = from,
            modifier = Modifier
                .fillMaxHeight()
                .padding(8.dp)
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
        GreetingImage(
            message = stringResource(R.string.happy_birthday_ameh),
            from = stringResource(R.string.signature_text),
            )

    }
}