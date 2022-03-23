package com.vini.components.ui.components.bank

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
fun AccountBalanceButton() {
    Row(
        modifier = Modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_visibility),
            contentDescription = "User",
            modifier = Modifier.size(18.dp),
            colorFilter = ColorFilter.tint(Color(0xFFFFFFFF))
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "saldo em conta", fontSize = 14.sp,
            color = Color(0xFFFFFFFF),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            fontFamily = bankFontFamily,
            fontWeight = FontWeight.Normal
        )
    }
}

@Preview
@Composable
fun AccountBalancePreview() {
    AccountBalanceButton()
}