package com.gogleset.wishlistapp

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.gogleset.wishlistapp.data.DummyWish
import com.gogleset.wishlistapp.data.Wish
import com.gogleset.wishlistapp.ui.theme.Screen

@Composable
fun HomeView(navController: NavController) {
    val context = LocalContext.current
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 0.0.dp, top = 51.809525.dp, end = 0.0.dp, bottom = 24.0.dp),
        topBar = {
            AppBarView(title = "WishList") {
                Toast.makeText(context, "Button Clicked", Toast.LENGTH_SHORT).show()
            }
        }, floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier
                    .padding(all = 20.dp),
                contentColor = Color.White,
                containerColor = Color.Black,
                onClick = {
                    Toast.makeText(context, "FAButton Clicked", Toast.LENGTH_SHORT).show()
                    navController.navigate(Screen.AddScreen.route)
                }) {
                Icon(imageVector = Icons.Default.AddCircle, contentDescription = "add")
            }
        }
    ) {
        LazyColumn(modifier = Modifier.padding(it)) {
            items(DummyWish.wishList) { item ->
                WishItem(wish = item) {

                }
            }
        }
    }
}

@Composable
fun WishItem(wish: Wish, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, start = 8.dp, end = 8.dp, bottom = 4.dp)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(6.dp),
        colors = CardDefaults.cardColors(Color.White),
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = wish.title, fontWeight = FontWeight.ExtraBold)
            Text(text = wish.description)
        }
    }
}
