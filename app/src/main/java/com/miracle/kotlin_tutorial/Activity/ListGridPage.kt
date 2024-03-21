package com.miracle.kotlin_tutorial.Activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.miracle.kotlin_tutorial.R
import com.miracle.kotlin_tutorial.ui.theme.ColorAccent
import com.miracle.kotlin_tutorial.ui.theme.Kotlin_TutorialTheme
import com.miracle.kotlin_tutorial.ui.theme.White

class ListGridPage : ComponentActivity() {
    private val numbers: Array<Int> = Array(20) { it }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Kotlin_TutorialTheme {
                ButtonPageUI()
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun ButtonPageUI() {
        Kotlin_TutorialTheme {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(ColorAccent)
                            .height(55.dp),

                        ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_back),
                            contentDescription = null,
                            colorFilter = ColorFilter.tint(White),
                            modifier = Modifier
                                .height(55.dp)
                                .width(55.dp)
                                .padding(15.dp)
                                .clickable {
                                    finish()
                                },
                        )
                        Text(
                            text = "List & Grid Demo",
                            color = Color.White,
                            fontFamily = FontFamily.SansSerif,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.align(alignment = Alignment.Center)
                        )
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .padding(10.dp),
//                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Column(Modifier.fillMaxHeight(0.5f)) {
                            titleText("Row :")
                            RowExample()

                            titleText("Column :")
                            ColumnExample()
                        }

                        Column(Modifier.fillMaxHeight()) {
                            titleText("Grid :")
                            GridExample()
                        }

                    }
                }
            }
        }
    }

    private @Composable
    fun RowExample() {
        LazyRow(
            contentPadding = PaddingValues(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp) //Each Item in LazyRow have a 8.dp margin
        ) {
//            item {
//                RowItem(number = 0)
//            }
            items(10) { currentCount ->
                RowItem(number = currentCount)
            }
            items(numbers) { arrayItem -> //Here numbers is Array<Int> so we get Int in the scope.
                RowItem(number = arrayItem)
            }
            itemsIndexed(numbers) { index: Int, item: Int ->
                RowItem(number = index)
            }
        }

    }

    @Composable
    private fun titleText(text: String) {
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = text,
            modifier = Modifier
                .fillMaxWidth(),
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start,
        )
        Spacer(modifier = Modifier.height(8.dp))
    }

    @Composable
    fun RowItem(number: Int) {
        Row(
            modifier = Modifier
                .size(100.dp)//Size 100 dp
                .background(Color.White)//Background White
                .border(1.dp, ColorAccent), //Border color green
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "This Is Item Number $number",
                color = ColorAccent,
                modifier = Modifier
                    .padding(horizontal = 10.dp)

            )
        }

    }

    @Composable
    fun ColumnExample() {
        LazyColumn(
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
//            item {
//                ColumnItem(number = 0)
//            }
            items(10) { currentCount ->
                ColumnItem(number = currentCount)
            }
            items(numbers) { arrayItem ->
                ColumnItem(number = arrayItem)
            }
            itemsIndexed(numbers) { index, item ->
                ColumnItem(number = index)
            }
        }
    }

    @Composable
    fun ColumnItem(number: Int) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp)
                .background(Color.White)
                .border(1.dp, ColorAccent),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {

            Text(text = "This Is Item Number $number", color = ColorAccent)
        }
    }

    @Composable
    fun GridExample() {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
//            item {
//                RowItem(number = 0)
//            }
            items(10) {
                RowItem(number = it)
            }
            items(numbers) {
                RowItem(number = it)
            }
            itemsIndexed(numbers) { index, item ->
                RowItem(number = index)
            }
        }
    }

}