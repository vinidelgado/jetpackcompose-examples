package com.vini.components.ui.components.bank

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vini.components.R
import com.vini.components.ui.theme.bankFontFamily

@Composable
fun RefreshTimeStatus() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = "há 5 minutos",
            fontSize = 14.sp,
            color = Color(0xFFFFFFFF),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            fontFamily = bankFontFamily,
            fontWeight = FontWeight.Normal
        )
        Spacer(modifier = Modifier.width(12.dp))
        Image(
            painter = painterResource(id = R.drawable.ic_refresh),
            contentDescription = "Expand",
            modifier = Modifier.size(12.dp),
            colorFilter = ColorFilter.tint(
                Color(0xFFFFFFFF),
            )
        )
    }
}

@Preview
@Composable
fun RefreshTimeStatusPreview() {
    RefreshTimeStatus()
}