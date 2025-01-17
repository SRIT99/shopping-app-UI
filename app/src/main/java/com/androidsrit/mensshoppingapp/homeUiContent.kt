package com.androidsrit.mensshoppingapp

import android.content.ClipData.Item
import android.content.Context
import android.content.DialogInterface.OnShowListener
import android.text.Layout.Alignment
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.androidsrit.mensshoppingapp.ui.theme.steelBlue
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.androidsrit.mensshoppingapp.ui.theme.Data
import com.androidsrit.mensshoppingapp.ui.theme.charcoalGray
import com.androidsrit.mensshoppingapp.ui.theme.navyBlue

@Composable
fun homeUi() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)

    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .background(steelBlue)
                    .fillMaxWidth()
                    .height(56.dp)
            ) {
                buttons(icon = R.drawable.baseline_menu_24)
                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "sDotShop",
                        style = TextStyle(
                            fontSize = 20.sp,
                            color = Color.White,
                            fontWeight = FontWeight.W700

                        )
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {

                    buttons(icon = R.drawable.baseline_search_24)
                }


            }

            LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                    items(Data.datalist) {
                        ShowSuit(data = it)


                }
            }
        }
    }
}

@Composable
fun buttons(
    @DrawableRes icon: Int,
    tint: Color = Color.Unspecified
) {
    IconButton(onClick = {/*ToDO*/ }) {
        Icon(painter = painterResource(id = icon), null)
    }
}

@Composable
fun ShowSuit(
    data: Data.Demo
) {
    Card(
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .width(175.dp)
            .height(300.dp)
            .padding(5.dp, 5.dp)

    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = androidx.compose.ui.Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp, 5.dp),
                horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(data.Img), contentDescription = "",
                    modifier = Modifier
                        .size(108.dp)
                        .clip(shape = CircleShape),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = data.price, style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W400,
                        color = Color.White,
                        textAlign = TextAlign.Center

                    ),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = data.desc, style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W400,
                        color = Color.White
                    ),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = data.name, style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W400,
                        fontFamily = FontFamily.Cursive,
                        color = Color.White
                    ),
                    textAlign = TextAlign.Center
                )
                Button(
                    onClick = {/*TODO*/ },
                    modifier = Modifier
                        .width(91.dp),
                    shape = RoundedCornerShape(18.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = charcoalGray)
                ) {
                    Text(
                        text = "Buy Now", style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.W600,
                            color = Color.White,
                            textAlign = TextAlign.Center
                        ),
                        textAlign = TextAlign.Center
                    )
                }

            }
        }
    }
}

