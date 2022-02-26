package com.vini.components.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vini.components.R

val fontFamily = FontFamily(
    Font(R.font.inter_medium),
    Font(R.font.inter_semibold, FontWeight.SemiBold),
)

@Composable
fun MessageBox(modifier: Modifier, message: String, type: MessageType = MessageType.DEFAULT) {
    Row(
        modifier = modifier.then(
            createModifier(type = type).padding(
                horizontal = 16.dp,
                vertical = 16.dp
            )
        ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val drawable = when(type.ordinal) {
            MessageType.ALERT.ordinal -> {
                R.drawable.ic_bitcoin
            }
            MessageType.ERROR.ordinal -> {
                R.drawable.ic_error
            }
            MessageType.INFORMATION.ordinal -> {
                R.drawable.ic_celebration
            }
            else -> {
                R.drawable.ic_info
            }
        }
        Image(
            painter = painterResource(id = drawable),
            contentDescription = "",
            modifier = Modifier
                .size(24.dp),
            alignment = Alignment.Center,
            contentScale = ContentScale.FillHeight,
            colorFilter = ColorFilter.tint(getIconColor(type = type))
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = message, fontSize = 16.sp,
            color = getTextColor(type = type),
            fontFamily = fontFamily,
            fontWeight = FontWeight.Normal
        )
    }
}

private fun getIconColor(type: MessageType) =
    when (type.ordinal) {
        MessageType.ALERT.ordinal -> {
            Color(0xFF000000)
        }
        MessageType.INFORMATION.ordinal -> {
            Color(0xFFFF871A)
        }
        else -> {
            Color(0xFFFFFFFF)
        }
    }

private fun getTextColor(type: MessageType) =
    when (type.ordinal) {
        MessageType.ALERT.ordinal -> {
            Color(0xFF000000)
        }
        MessageType.INFORMATION.ordinal -> {
            Color(0xFF796F6A)
        }
        else -> {
            Color(0xFFFFFFFF)
        }
    }

private fun createModifier(type: MessageType): Modifier {
    val backgroundColor = when (type.ordinal) {
        MessageType.ALERT.ordinal -> Color(0xFFE4B527)
        MessageType.ERROR.ordinal -> Color(0xFF781B8E)
        MessageType.INFORMATION.ordinal -> Color(0xFFFBF7F5)
        else -> Color(0xFF006EB4)
    }
    return Modifier
        .background(
            color = backgroundColor,
            shape = RoundedCornerShape(size = 6.dp)
        )
}

enum class MessageType {
    ALERT, ERROR, DEFAULT, INFORMATION
}

@Preview
@Composable
fun MessageBoxPreview() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF2EAE5))
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(Modifier.fillMaxSize()) {
            MessageBox(
                modifier = Modifier.wrapContentSize(),
                message = "Temos uma recomendação de investimento para você. Confira",
                type = MessageType.DEFAULT
            )
            Spacer(modifier = Modifier.height(24.dp))
            MessageBox(
                modifier = Modifier.wrapContentSize(),
                message = "Temos uma recomendação de investimento para você. Confira",
                type = MessageType.ALERT
            )
            Spacer(modifier = Modifier.height(24.dp))
            MessageBox(
                modifier = Modifier.wrapContentSize(),
                message = "Temos uma recomendação de investimento para você. Confira",
                type = MessageType.ERROR
            )
            Spacer(modifier = Modifier.height(24.dp))
            MessageBox(
                modifier = Modifier.wrapContentSize(),
                message = "Temos uma recomendação de investimento para você. Confira",
                type = MessageType.INFORMATION
            )
        }
    }
}