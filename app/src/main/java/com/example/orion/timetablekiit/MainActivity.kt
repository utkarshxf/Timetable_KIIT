package com.example.orion.timetablekiit

import android.graphics.Paint
import android.graphics.fonts.Font
import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.Size
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.orion.timetablekiit.ui.theme.TimeTableKIITTheme
import java.nio.file.WatchEvent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TimeTableKIITTheme {
               Timetableapp()
            }
        }
    }
}
@Composable
fun Timetableapp() {
    Scaffold(
        topBar = {
            TopAppBar()
           }
    ){
    LazyColumn(modifier = Modifier.background(MaterialTheme.colors.background)){
        items(timetb){
           timedetl(timetable = it)
        }
    }
}}
@Composable
fun TopAppBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colors.onSurface),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = modifier
                .size(50.dp)
                .padding(5.dp),
            painter = painterResource(R.drawable.kiit),
            contentDescription = null
        )
        Text(
            text = "Time Table 3rd semester", color = Color.White,
            style = MaterialTheme.typography.h1
            )

    }
}
@Composable
fun timedetl (timetable: timetable, modifier: Modifier =Modifier) {
    var expanded by remember { mutableStateOf(false) }
    Card(
        modifier = modifier.padding(8.dp),
        elevation = 200.dp
    ) {
        Column(modifier = Modifier
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
            {
                branchicon(timetable.branch)
                branchinfo(timetable.section)

                Spacer(Modifier.weight(1f))
                infoButton(expanded = expanded, onClick = { expanded=!expanded })
            }
            if (expanded==true){
            timetablelst(timetable.imageresourceId,modifier)}
        }

    }
}
@Composable
fun timetablelst(@DrawableRes image:Int, modifier: Modifier) {
    Column(
        modifier = modifier
            .padding(
             top = 10.dp, bottom = 27.dp
        )
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = null
             )
      }
}
@Composable
private fun infoButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(onClick =  onClick ) {
       Icon(imageVector = if (expanded) Icons.Filled.ExpandLess
                            else Icons.Filled.ExpandMore ,
           tint = MaterialTheme.colors.onSurface,
           contentDescription = "")


    }
}
@Composable
fun branchicon(@DrawableRes branch: Int, modifier: Modifier = Modifier) {
    Image(
         modifier = modifier
             .size(64.dp)
             .padding(8.dp)
             .clip(RoundedCornerShape(50)),
        contentScale = ContentScale.Crop,
        painter = painterResource(branch),
        contentDescription = null
    )
}
@Composable
fun branchinfo(section: Int, modifier: Modifier=Modifier){
    Column {
        Text(text = "Section :  $section ", color = Color.White, style = MaterialTheme.typography.h6,
              modifier= modifier
                  .padding(top = 20.dp)
                  .padding(start = 20.dp)

        )

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TimeTableKIITTheme {
        Timetableapp()
    }
}