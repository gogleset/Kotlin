package com.gogleset.app


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun MovieScreen(modifier: Modifier) {
    val viewModel: MovieViewModel = viewModel()
    val viewState by viewModel.movieState

    Box(modifier) {
        when {
            viewState.loading -> {
                CircularProgressIndicator(modifier.align(Alignment.Center))
            }

            viewState.error != null -> {
                Text(text = "ERROR OCCURED")
            }

            else -> {
                MovieItem(result = viewState.result)
            }
        }
    }

}

@Composable
fun MovieItem(result: MovieResult?) {
    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        if (result != null) {
            items(result.boxOfficeResult.dailyBoxOfficeList) { items ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .aspectRatio(1F)
                ) {
                    Text(items.rank)
                    Text(items.openDt)
                    Text(items.movieNm)
                }
            }
        }
    }

}
