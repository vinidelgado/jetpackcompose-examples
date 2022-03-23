package com.vini.components.ui.components.bank

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vini.components.R
import com.vini.components.ui.theme.bankFontFamily

@Composable
fun ExpandableCard(
    title: String,
    titleFontSize: TextUnit = 24.sp,
    titleFontWeight: FontWeight = FontWeight.Normal,
    titleTextColor: Color = Color(0xFF504949),
    text: String?,
    textFontSize: TextUnit = 24.sp, //Change to your Material Theme
    textFontWeight: FontWeight = FontWeight.Bold,
    textColor: Color = Color(0xFFFF7002), //Change to your Material Theme
    buttonText: String?,
    buttonFontSize: TextUnit = 14.sp,
    buttonTextColor: Color = Color(0xFF006EB4),
    buttonFontWeight: FontWeight = FontWeight.Medium,
) {
    val expandedState = remember {
        mutableStateOf(false)
    }
    val rotationState by animateFloatAsState(
        targetValue = if (expandedState.value) 180f else 0f
    )
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
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
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    modifier = Modifier
                        .padding(top = 2.dp),
                    text = title,
                    fontSize = titleFontSize,
                    color = titleTextColor,
                    fontFamily = bankFontFamily,
                    fontWeight = titleFontWeight
                )
                text?.let { _ ->
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
            text?.let {
                if (expandedState.value) {
                    Text(
                        text = it,
                        fontSize = textFontSize,
                        color = textColor,
                        fontFamily = bankFontFamily,
                        fontWeight = textFontWeight
                    )
                }
            }
            buttonText?.let { buttonText ->
                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp),
                    color = Color(0xFFF6F2EF)
                )
                TextButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.defaultMinSize(48.dp, 48.dp),
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Text(
                        text = buttonText,
                        fontSize = buttonFontSize,
                        color = buttonTextColor,
                        fontFamily = bankFontFamily,
                        fontWeight = buttonFontWeight,
                    )
                }
            }
        }

    }
}

@Preview
@Composable
fun ExpandableCardPreview() {
    ExpandableCard(title = "crédito", buttonText = "ver mais", text = "R$ 4.369,81")
}