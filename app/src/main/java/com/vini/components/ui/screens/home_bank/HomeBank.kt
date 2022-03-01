package com.vini.components.ui.screens.home_bank

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vini.components.ui.components.CreditCard
import com.vini.components.ui.components.ExpandableCard
import com.vini.components.ui.components.MessageBox
import com.vini.components.ui.components.MessageType

@Composable
fun HomeBank() {
    Scaffold(backgroundColor = Color(0xFFF2EAE5)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            MessageBox(
                modifier = Modifier,
                message = "Temos uma novidade para você, agora você pode usar Bitcoin em sua conta",
                type = MessageType.DEFAULT
            )
            Spacer(modifier = Modifier.height(16.dp))
            CreditCard("Personalité Mastercard Black Multiplo")
            Spacer(modifier = Modifier.height(24.dp))
            ExpandableCard(title = "crédito", buttonText = "ver mais", text = "R$ 4.369,81")
        }
    }
}

@Preview
@Composable
fun HomeBankPreview() {
    HomeBank()
}