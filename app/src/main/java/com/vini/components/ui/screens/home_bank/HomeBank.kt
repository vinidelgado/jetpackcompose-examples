package com.vini.components.ui.screens.home_bank

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vini.components.R
import com.vini.components.ui.components.bank.CreditCard
import com.vini.components.ui.components.bank.ExpandableCard
import com.vini.components.ui.components.bank.AccountBalanceButton
import com.vini.components.ui.components.bank.LoggerUser
import com.vini.components.ui.components.bank.Menu
import com.vini.components.ui.components.bank.MessageBox
import com.vini.components.ui.components.bank.MessageType
import com.vini.components.ui.components.bank.RefreshTimeStatus
import com.vini.components.ui.theme.bankFontFamily

@Composable
fun HomeBank() {
    Scaffold(backgroundColor = Color(0xFFF2EAE5), topBar = {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.3f)
                .background(color = Color(0xFFFF7002), shape = RectangleShape)
                .padding(horizontal = 16.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            LoggerUser()
            Spacer(modifier = Modifier.height(16.dp))
            AccountBalanceButton()
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "R$ 5.000,47",
                    fontSize = 24.sp,
                    color = Color.White,
                    fontFamily = bankFontFamily,
                    fontWeight = FontWeight.SemiBold
                )
                RefreshTimeStatus()
            }
            Spacer(modifier = Modifier.height(8.dp))
            Divider(color = Color(0xFFF2EAE5).copy(alpha = 0.4f), thickness = 1.dp)
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "ver lançamentos futuros",
                    fontSize = 14.sp,
                    color = Color.White.copy(alpha = 0.7f),
                    fontFamily = bankFontFamily,
                    fontWeight = FontWeight.Normal
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_chevron_right),
                    contentDescription = "Lançamentos futuros ícone",
                    modifier = Modifier.size(12.dp),
                    colorFilter = ColorFilter.tint(
                        Color(0xFFFFFFFF).copy(alpha = 0.7f),
                    )
                )
            }
        }
    }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(bottom = 48.dp)
        ) {
            MenuList()
            Spacer(modifier = Modifier.height(8.dp))
            MessageBox(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                message = "Temos uma novidade para você, agora você pode usar Bitcoin em sua conta",
                type = MessageType.DEFAULT
            )
            Spacer(modifier = Modifier.height(8.dp))
            CreditCard("Personalité Mastercard Black Multiplo")
            Spacer(modifier = Modifier.height(24.dp))
            ExpandableCard(title = "crédito", buttonText = "ver mais", text = "R$ 4.369,81")
        }
    }
}

@Composable
private fun MenuList() {
    val menuList = listOf(
        Menu(textMenu = "soluções para esse momento", R.drawable.ic_home),
        Menu(textMenu = "fazer transferência", R.drawable.ic_transactions),
        Menu(textMenu = "investimento", R.drawable.ic_trendingup),
        Menu(textMenu = "pagar conta", R.drawable.ic_scan),
        Menu(textMenu = "saque sem cartão", R.drawable.ic_withdraw_no_card),
        Menu(textMenu = "cartão digital", R.drawable.ic_wallet)
    )
    Box(
        Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        LazyRow {
            items(menuList.size) { index ->
                val menu = menuList[index]
                Menu(
                    modifier = Modifier
                        .size(width = 98.dp, height = 120.dp)
                        .padding(vertical = 10.dp),
                    selected = index == 0,
                    textMenu = menu.textMenu,
                    iconMenu = menu.menuIcon
                )
                Spacer(modifier = Modifier.width(4.dp))
            }
        }
    }
}

@Preview
@Composable
fun HomeBankPreview() {
    HomeBank()
}