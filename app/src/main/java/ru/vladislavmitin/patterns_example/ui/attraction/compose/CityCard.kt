package ru.vladislavmitin.patterns_example.ui.attraction.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import ru.vladislavmitin.patterns_example.ui.model.PresentationCity

@Composable
fun CityCard(
    city: PresentationCity,
) {
    MyCard {
        CityImageContent(
            title = city.name,
            imageUrl = city.url,
            population = city.population,
        )
    }
}

@Composable
fun CityImageContent(
    title: String,
    imageUrl: String,
    population: Long,
    modifier: Modifier = Modifier,
) {
    Box(modifier) {
        CityImage(imageUrl)
        CityInformation(
            modifier = Modifier.align(Alignment.BottomStart),
            title = title,
            population = population,
        )
    }
}

@Composable
fun CityImage(
    imageUrl: String,
    modifier: Modifier = Modifier,
) {
    GlideImage(
        modifier = modifier
            .fillMaxWidth()
            .height(200.dp),
        imageModel = { imageUrl },
        imageOptions = ImageOptions(contentScale = ContentScale.Inside),
        failure = { failure ->
            Text(
                modifier = modifier.align(Alignment.Center),
                text = "Ошибка загрузки картинки ${failure.reason?.message}",
            )
        }
    )
}

@Composable
fun CityInformation(
    title: String,
    population: Long,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier
            .fillMaxWidth()
            .background(Color(0x80717575))
            .padding(horizontal = 16.dp, vertical = 8.dp),
    ) {
        Text(
            text = title,
            color = Color(0xE6FFFFFF),
            fontSize = 22.sp,
            fontWeight = FontWeight(500),
        )
        Text(
            text = "В этом городе проживает $population человек",
            color = Color(0xE6FFFFFF),
            fontSize = 16.sp,
        )
    }
}