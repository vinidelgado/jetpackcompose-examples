package com.vini.components.ui.components.bank

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vini.components.R

data class Menu(val textMenu: String, val menuIcon: Int)

@Composable
fun Menu(
    modifier: Modifier = Modifier,
    selected: Boolean = false,
    textMenu: String,
    iconMenu: Int,
    iconSelectedColor: Color = Color(0xFFFFFFFF),
    iconUnselectedColor: Color = Color(0xFFFF7002),
    backgroundSelectedColor: Color = Color(0xFF006EB4),
    backgroundUnselectedColor: Color = Color(0xFFFFFFFF),
    borderSelectedColor: Color = Color(0xFF006EB4),
    borderUnselectedColor: Color = Color(0xFFE1DCD9),
    shape: Shape = RoundedCornerShape(8.dp)
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val backgroundColor = if (selected) {
            backgroundSelectedColor
        } else {
            backgroundUnselectedColor
        }

        val borderColor = if (selected) {
            borderSelectedColor
        } else {
            borderUnselectedColor
        }

        val iconColor = if (selected) {
            iconSelectedColor
        } else {
            iconUnselectedColor
        }

        Box(
            modifier = Modifier
                .size(48.dp)
                .border(2.dp, borderColor, shape = shape)
                .background(backgroundColor, shape = shape),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier.width(22.dp),
                painter = painterResource(id = iconMenu),
                contentScale = ContentScale.FillWidth,
                contentDescription = "$textMenu ícone",
                colorFilter = ColorFilter.tint(iconColor)
            )
        }
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            text = textMenu,
            textAlign = TextAlign.Center,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MenuPreview() {
    Menu(
        modifier = Modifier
            .size(width = 98.dp, height = 120.dp)
            .padding(vertical = 10.dp),
        selected = true,
        textMenu = "Selecionado",
        iconMenu = R.drawable.ic_celebration
    )
}


@Preview(showBackground = true)
@Composable
fun MenuSelectedPreview() {
    Menu(
        modifier = Modifier
            .size(width = 98.dp, height = 120.dp)
            .padding(vertical = 10.dp),
        selected = false,
        textMenu = "Not Selecionado",
        iconMenu = R.drawable.ic_bitcoin
    )
}