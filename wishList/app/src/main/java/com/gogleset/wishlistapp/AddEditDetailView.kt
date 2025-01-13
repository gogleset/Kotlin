package com.gogleset.wishlistapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun AddEditDetailView(id: Long, viewModel: WishViewModel, navController: NavController) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 0.0.dp, top = 51.809525.dp, end = 0.0.dp, bottom = 24.0.dp),
        topBar = {
            AppBarView(
                title =
                if (id != 0L) stringResource(id = R.string.update_wish) else stringResource(id = R.string.add_wish),
                onBackNavClicked = {
                    navController.navigateUp()
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .wrapContentSize()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            WishTextField(
                label = "Title",
                value = viewModel.wishTitleState,
                onValueChanged = { value -> viewModel.onWishTitleChanged(value) }
            )

            Spacer(modifier = Modifier.height(10.dp))
            WishTextField(
                label = "Description",
                value = viewModel.wishDescriptionState,
                onValueChanged = { value -> viewModel.onWishDescriptionChanged(value) }
            )
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = {
                if (viewModel.wishTitleState.isNotEmpty() && viewModel.wishDescriptionState.isNotEmpty()) {
                    // Update wish

                } else {
//                    TODO add wish

                }
            }) {
                Text(
                    text =
                    if (id != 0L) stringResource(id = R.string.update_wish) else stringResource(
                        id = R.string.add_wish
                    ),
                    style = TextStyle(fontSize = 18.sp)
                )
            }
        }
    }
}

@Composable
fun WishTextField(label: String, value: String, onValueChanged: (String) -> Unit) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChanged,
        label = {
            Text(text = label, color = Color.Black)
        },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Color.Black,
            focusedLabelColor = Color.Black,
            unfocusedBorderColor = Color.Black, cursorColor = Color.Black,
            focusedBorderColor = Color.Black,
            unfocusedLabelColor = Color.Red
        )
    )
}

@Preview
@Composable
fun WishTextFieldPreview() {
    WishTextField("test", "test", {})
}