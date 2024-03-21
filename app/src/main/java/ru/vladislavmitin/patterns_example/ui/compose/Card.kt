package ru.vladislavmitin.patterns_example.ui.compose

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyCard(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit,
) {
    Card(
        modifier = modifier
            .padding(horizontal = 16.dp, vertical = 16.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(8.dp),
            ),
        colors = CardDefaults.cardColors().copy(containerColor = Color.White),
        shape = RoundedCornerShape(16.dp),
        content = content,
    )
}
