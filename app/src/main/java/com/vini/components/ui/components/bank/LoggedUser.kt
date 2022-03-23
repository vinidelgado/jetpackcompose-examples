package com.vini.components.ui.components.bank

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
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
fun LoggerUser() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        IconLoggerUser()
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "Rafaela", fontSize = 16.sp,
            color = Color(0xFFFFFFFF),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            fontFamily = bankFontFamily,
            fontWeight = FontWeight.Normal
        )
        Spacer(modifier = Modifier.width(8.dp))
        Image(
            painter = painterResource(id = R.drawable.ic_expand),
            contentDescription = "Expand",
            modifier = Modifier.size(10.dp),
            colorFilter = ColorFilter.tint(Color(0xFFFFFFFF))
        )
    }
}

@Composable
fun IconLoggerUser() {
    Box(
        modifier = Modifier
            .size(40.dp)
            .background(color = Color(0xFFF2EAE5), shape = CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_user),
            contentDescription = "User",
            modifier = Modifier.fillMaxSize(0.5f),
            colorFilter = ColorFilter.tint(Color(0x40000000))
        )
    }
}

@Preview
@Composable
fun LoggedUserPreview() {
    LoggerUser()
}