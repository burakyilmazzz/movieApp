package com.example.movieapp

import android.graphics.drawable.shapes.Shape
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movieapp.data.DataSource
import com.example.movieapp.model.Affirmation
import com.example.movieapp.ui.theme.MovieAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    MovieApp()

                }
            }
        }
    }
}

 @Composable
fun MovieApp(){
    MovieAppTheme {
        AffirmationList(affirmationList = DataSource().loadAffirmations())
    }
}

@Composable
fun AffirmationCard(affirmation: Affirmation, modifier: Modifier = Modifier){
    
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(5.dp), elevation = 4.dp) {
        Row {
            Box{
                modifier.padding(30.dp)
                Image(
                    painter = painterResource(id = affirmation.imageResourceId),
                    contentDescription = stringResource(id = affirmation.stringResourceId),
                    modifier = Modifier
                        .height(194.dp)
                        .width(150.dp)
                        .clip(RoundedCornerShape(35))
                        .padding(8.dp)

                )
            }
                Column {
                    Text(
                        text = stringResource(id = affirmation.stringResourceId),
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.h6
                    )
                    Row {
                        Icon(painter = painterResource(id = R.drawable.yildiz), contentDescription =  null)
                        Icon(painter = painterResource(id = R.drawable.yildiz), contentDescription =  null)
                        Icon(painter = painterResource(id = R.drawable.yildiz), contentDescription =  null)
                        Icon(painter = painterResource(id = R.drawable.yildiz), contentDescription =  null)
                        Icon(painter = painterResource(id = R.drawable.yildiz), contentDescription =  null)
                        Spacer(modifier = Modifier.width(15.dp))
                        Text(text = affirmation.puan.toString())
                    }
                    Row {
                                Text(text = affirmation.tarih.toString())
                                Text("  |  ")
                                Text(text = affirmation.sure)
                    }
                    Spacer(modifier = modifier.height(30.dp))
                    Row {
                        Button(
                            modifier = Modifier.clip(RoundedCornerShape(30.dp)).background(color = Color.Magenta),
                            onClick = { /*TODO*/ }) {
                            Text(stringResource(R.string.button))


                        }
                        Spacer(modifier = Modifier.width(66.dp))
                        Text(text = "Trailer", modifier.padding(top = 10.dp))
                    }


                }
           


            Icon(painter = painterResource(id = R.drawable.koleksiyon ) , contentDescription = null,
                modifier = Modifier.padding(top = 15.dp, end = 15.dp)
                )

            
    }
}
}

@Composable
fun movieAppBar(modifier: Modifier = Modifier){
        Row (modifier = Modifier.fillMaxWidth().background(color = MaterialTheme.colors.primary)){
           Image(painter = painterResource(id = R.drawable.logo), contentDescription = null, Modifier.size(45.dp) )
            Text(text = stringResource(id = R.string.appBar),
            style = MaterialTheme.typography.h6
                )
        }
}

@Composable
private fun AffirmationList(affirmationList: List<Affirmation>, modifier: Modifier = Modifier){
    Scaffold(
        topBar = { movieAppBar()}
    ) {
        LazyColumn(modifier = Modifier.background(color = MaterialTheme.colors.surface)){
            items(affirmationList){ affirmation -> AffirmationCard(affirmation = affirmation)

            }
        }
    }

}

@Preview
@Composable
fun AffirmationCardPreview() {
    AffirmationCard(affirmation = Affirmation(R.string.batman, R.drawable.batman, 8.9 , 2011, "2h 30m"))
}