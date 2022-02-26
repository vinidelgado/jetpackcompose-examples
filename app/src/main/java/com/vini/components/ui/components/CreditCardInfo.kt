package com.vini.components.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vini.components.R

@Composable
fun CreditCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = RoundedCornerShape(12.dp),
        backgroundColor = Color(0xFFFFFFFF),
        elevation = 8.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(horizontal = 16.dp, vertical = 16.dp)
                .background(Color(0xFFFFFFFF))
        ) {
            CreditCardInfo()
            Spacer(modifier = Modifier.height(16.dp))
            CreditCardFlagLastDigits()
            Spacer(modifier = Modifier.height(8.dp))
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp),
                color = Color(0xFFF6F2EF)
            )
            ActionButtons()
        }
    }
}

@Composable
fun CreditCardDivisor() {

}

@Composable
fun CreditCardInfo() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFFFFFFF)), verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.weight(0.6f),
            text = "Itaú Uniclass Mastercard Internacional Multiplo", fontSize = 18.sp,
            color = Color(0xFF000000),
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.width(8.dp))
        TextButton(onClick = { /*TODO*/ }, modifier = Modifier.weight(0.3f)) {
            Text(
                text = "Expandir",
                fontSize = 14.sp,
                color = Color(0xFF61534A),
                fontFamily = fontFamily,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.End
            )
            Image(
                painter = painterResource(id = R.drawable.ic_arrow_down),
                contentDescription = "",
                modifier = Modifier
                    .size(28.dp),
                alignment = Alignment.Center,
                contentScale = ContentScale.FillHeight,
                colorFilter = ColorFilter.tint(Color(0xFF61534A))
            )
        }
    }
}

@Composable
fun CreditCardFlagLastDigits() {
    val drawable = R.drawable.ic_mastercard
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFFFFFFF)), verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = drawable),
            contentDescription = "",
            modifier = Modifier
                .size(32.dp),
            alignment = Alignment.Center,
            contentScale = ContentScale.FillHeight,
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "Final 1234", fontSize = 16.sp,
            color = Color(0xFF5F4544),
            fontFamily = fontFamily,
            fontWeight = FontWeight.Normal
        )
    }
}

@Composable
fun ActionButtons() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .defaultMinSize(minHeight = 48.dp)
            .background(Color(0xFFFFFFFF)), verticalAlignment = Alignment.CenterVertically
    ) {
        TextButton(onClick = { /*TODO*/ }) {
            Text(
                text = "Ver fatura",
                fontSize = 16.sp,
                color = Color(0xFF006EB4),
                fontFamily = fontFamily,
                fontWeight = FontWeight.SemiBold
            )
        }
        Spacer(modifier = Modifier.width(24.dp))
        TextButton(onClick = { /*TODO*/ }) {
            Text(
                text = "Cartão virtual",
                fontSize = 16.sp,
                color = Color(0xFF006EB4),
                fontFamily = fontFamily,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Preview
@Composable
fun CreditCardPreview() {
    CreditCard()
}

@Preview
@Composable
fun CreditCardInfoPreview() {
    CreditCardInfo()
}

@Preview
@Composable
fun CreditCardFlagLastDigitsPreview() {
    CreditCardFlagLastDigits()
}

@Preview
@Composable
fun ActionButtonsPreview() {
    ActionButtons()
}