package com.vini.components.ui.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
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
import com.vini.components.ui.theme.bankFontFamily

@Composable
fun CreditCard(creditCardName: String) {
    val expandedState = remember {
        mutableStateOf(true)
    }
    val rotationState by animateFloatAsState(
        targetValue = if (expandedState.value) 180f else 0f
    )
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            ),
        shape = RoundedCornerShape(4.dp),
        backgroundColor = Color(0xFFFFFFFF),
        elevation = 8.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 0.dp)
                .background(Color(0xFFFFFFFF))
        ) {
            CreditCardInfo(
                creditCardName = creditCardName,
                expandedState = expandedState,
                rotationState = rotationState
            )
            if (expandedState.value) {
                Spacer(modifier = Modifier.height(16.dp))
                CreditCardFlagLastDigits()
            }
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
fun CreditCardInfo(
    creditCardName: String,
    expandedState: MutableState<Boolean>,
    rotationState: Float
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFFFFFFF)), verticalAlignment = Alignment.Top, horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            modifier = Modifier.weight(2f)
                .padding(top = 2.dp),
            text = creditCardName, fontSize = 18.sp,
            color = Color(0xFF000000),
            fontFamily = bankFontFamily,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.width(8.dp))
        TextButton(
            onClick = {
                expandedState.value = !expandedState.value
            },
            modifier = Modifier
                .height(48.dp),
            contentPadding = PaddingValues(0.dp)
        ) {
            Text(
                text = if (expandedState.value) {
                    "Esconder"
                } else {
                    "Expandir"
                },
                fontSize = 14.sp,
                color = Color(0xFF61534A),
                fontFamily = bankFontFamily,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.End
            )
            Image(
                painter = painterResource(id = R.drawable.ic_arrow_down),
                contentDescription = "",
                modifier = Modifier
                    .size(24.dp)
                    .rotate(rotationState),
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
            fontFamily = bankFontFamily,
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
        TextButton(
            onClick = { /*TODO*/ },
            modifier = Modifier.defaultMinSize(48.dp, 48.dp),
            contentPadding = PaddingValues(0.dp)
        ) {
            Text(
                text = "Ver fatura",
                fontSize = 14.sp,
                color = Color(0xFF006EB4),
                fontFamily = bankFontFamily,
                fontWeight = FontWeight.Medium,
            )
        }
        Spacer(modifier = Modifier.width(24.dp))
        TextButton(
            onClick = { /*TODO*/ },
            modifier = Modifier.defaultMinSize(48.dp, 48.dp),
            contentPadding = PaddingValues(0.dp)
        ) {
            Text(
                text = "Cartão virtual",
                fontSize = 14.sp,
                color = Color(0xFF006EB4),
                fontFamily = bankFontFamily,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Preview
@Composable
fun CreditCardPreview() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF2EAE5)),
        contentAlignment = Alignment.Center
    ) {
        CreditCard(creditCardName = "Nelson Jones Card Exclusive")
    }
}

@Preview
@Composable
fun CreditCardInfoPreview() {
    val expandedState = remember {
        mutableStateOf(false)
    }
    val rotationState by animateFloatAsState(
        targetValue = if (expandedState.value) 180f else 0f
    )
    CreditCardInfo(
        creditCardName = "Nelson Jones Card Exclusive",
        expandedState = expandedState,
        rotationState = rotationState
    )
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