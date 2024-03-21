package ru.vladislavmitin.patterns_example.ui.attraction.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage
import ru.vladislavmitin.patterns_example.ui.compose.MyCard
import ru.vladislavmitin.patterns_example.ui.model.PresentationAttraction

@Composable
fun AttractionCard(
    attraction: PresentationAttraction,
) {
    MyCard {
        AttractionImageContent(
            name = attraction.name,
            imageUrl = attraction.url,
            rating = attraction.rating,
        )
        AttractionDescription(
            description = attraction.description,
        )
    }
}

@Composable
fun AttractionImageContent(
    name: String,
    imageUrl: String,
    rating: String,
    modifier: Modifier = Modifier,
) {
    Box(modifier) {
        AttractionImage(imageUrl)
        AttractionRating(
            modifier = Modifier.align(Alignment.TopEnd),
            rating = rating,
        )
        AttractionTitle(
            modifier = Modifier.align(Alignment.BottomStart),
            title = name,
        )
    }
}

@Composable
fun AttractionImage(
    imageUrl: String,
    modifier: Modifier = Modifier,
) {
    GlideImage(
        modifier = modifier
            .fillMaxWidth()
            .height(300.dp),
        imageModel = { imageUrl },
        imageOptions = ImageOptions(contentScale = ContentScale.Crop),
        failure = { failure ->
            Text(
                modifier = modifier.align(Alignment.Center),
                text = "Ошибка загрузки картинки ${failure.reason?.message}",
            )
        }
    )
}

@Composable
fun AttractionRating(
    rating: String,
    modifier: Modifier = Modifier,
) {
    Text(
        modifier = modifier
            .padding(16.dp)
            .background(Color(0xA6717575), RoundedCornerShape(16.dp))
            .padding(horizontal = 8.dp, vertical = 2.dp),
        text = rating,
        color = Color(0xCCFFFFFF),
    )
}

@Composable
fun AttractionTitle(
    title: String,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier
            .fillMaxWidth()
            .background(Color(0x80717575))
    ) {
        Text(
            modifier = modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            text = title,
            color = Color(0xE6FFFFFF),
            fontSize = 22.sp,
            fontWeight = FontWeight(500),
        )
    }
}

@Composable
fun AttractionDescription(
    description: String,
    modifier: Modifier = Modifier,
) {
    Text(
        modifier = modifier.padding(horizontal = 16.dp, vertical = 8.dp),
        text = description,
        fontSize = 16.sp,
    )
}