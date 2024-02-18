package com.example.testmission.presenter.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.HtmlCompat
import androidx.core.text.parseAsHtml
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import coil.compose.AsyncImage
import com.example.testmission.R
import com.example.testmission.data.model.simple.BookModel
import com.example.testmission.ui.components.DetailsButton
import com.example.testmission.ui.components.DetailsItem
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class DetailsScreen(private val bookModel: BookModel) : AndroidScreen() {
    @Composable
    override fun Content() {
        val vm : DetailsScreenContract.ViewModel = getViewModel<DetailsScreenViewModel>()
        DetailsScreenContent(
            model = bookModel,
            vm::onEventDispatcher
        )
    }
}

@Composable
fun DetailsScreenContent(
    model: BookModel,
    onEventDispatcher: (DetailsScreenContract.Intent) -> Unit
) {
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setStatusBarColor(
            color = Color(0xFFE43C22),
        )
    }
    Column(    modifier = Modifier
        .verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(bottomStart = 24.dp, bottomEnd = 24.dp))
                .background(color = Color(0xFFE43C22))
                .padding(end = 16.dp, top = 20.dp, start = 16.dp, bottom = 40.dp)
        ) {
            Row {
                Image(
                    painter = painterResource(id = R.drawable.vector),
                    contentDescription = "back",
                    modifier = Modifier
                        .size(40.dp)
                        .clip(RoundedCornerShape(30.dp))
                        .clickable {
                            onEventDispatcher.invoke(DetailsScreenContract.Intent.BackToHomeScreen)
                        }
                        .background(color = Color.White)
                        .padding(8.dp),
                )
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    painter = painterResource(id = R.drawable.bookmark),
                    contentDescription = "bookmark",
                    modifier = Modifier
                        .size(40.dp)
                        .clip(RoundedCornerShape(30.dp))
                        .background(color = Color.White)
                        .padding(8.dp),
                )
                Spacer(modifier = Modifier.size(8.dp))
                Image(
                    painter = painterResource(id = R.drawable.share),
                    contentDescription = "share",
                    modifier = Modifier
                        .size(40.dp)
                        .clip(RoundedCornerShape(30.dp))
                        .background(color = Color.White)
                        .padding(8.dp),
                )
            }
            Spacer(modifier = Modifier.size(16.dp))
            Row {
                AsyncImage(
                    modifier = Modifier
                        .width(130.dp)
                        .height(180.dp)
                        .clip(RoundedCornerShape(6.dp)),
                    model = model.image,
                    contentScale = ContentScale.Crop,
                    placeholder = painterResource(id = R.drawable.img),
                    error = painterResource(id = R.drawable.img),
                    contentDescription = "The Book item",
                )
                Spacer(modifier = Modifier.size(16.dp))
                Column {
                    Text(
                        color = Color.White,
                        text = model.title,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.W500,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                    DetailsItem("Автор: ", model.author)
                    Spacer(modifier = Modifier.size(4.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            color = Color.White,
                            text = "Рейтинг: ",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.W500
                        )
                        Image(
                            painter = painterResource(id = R.drawable.star),
                            contentDescription = "",
                            modifier = Modifier.size(18.dp),
                        )
                        Spacer(modifier = Modifier.size(4.dp))
                        Text(
                            color = Color.White,
                            text = model.rating,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.W600
                        )
                    }
                    DetailsItem("Категория: ", model.section)
                    DetailsItem("Скачиваний: ", model.downloads)
                }
            }
        }
        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            Spacer(modifier = Modifier.size(16.dp))
            DetailsButton()
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                text = "О книге",
                fontSize = 22.sp,
                color = Color.Black,
                fontWeight = FontWeight.W700
            )
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                text = model.summary.parseAsHtml(HtmlCompat.FROM_HTML_MODE_COMPACT).toString(),
                fontSize = 14.sp,
                lineHeight = 24.sp,
                color = Color.Black,
                fontWeight = FontWeight.W500,
            )
            Text(
                text = "Читать полностью",
                fontSize = 14.sp,
                lineHeight = 24.sp,
                color = Color(0xFFE43C22),
                fontWeight = FontWeight.W500,
            )
            Spacer(modifier = Modifier.size(16.dp))
        }
    }
}