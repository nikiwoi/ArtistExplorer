package com.example.artistexplorer_niki.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.artistexplorer_niki.ui.viewmodel.MusicViewModel

@Composable
fun MainView(
    modifier: Modifier,
    viewModel: MusicViewModel
) {
    val artists by viewModel.artist.collectAsState()

    LazyColumn(
        Modifier
            .background(Color(0xFF282828))
            .fillMaxSize()
    ) {
        item {
            Row(
                modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .background(Color(0xFF1D2122))
                    .padding(top = 20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
            ) {
                Text(
                    "Taylor Swift",
                    color = Color(0xFFA39E91),
                    fontSize = 15.sp
                )
            }
        }
        item {
            Column(
                modifier
                    .padding(20.dp)
            ) {
                Card {
//                    AsyncImage(
//                        model = ImageRequest.Builder(LocalContext.current)
//                            .data(artist.strArtistThumb)
//                            .crossfade(true)
//                            .build(),
//                        contentDescription = "",
//                        modifier = Modifier
//                            .size(400.dp),
//                        contentScale = ContentScale.Crop
//                    )
                }
                Row(
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier
                        .padding(vertical = 20.dp)
                        .padding(horizontal = 10.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "Albums",
                        color = Color.LightGray
                    )
                }

            }
        }
        item {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .height(800.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(20.dp),
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {
//                items() {
//
//                }
            }
        }

    }


}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun MainViewPreview() {
    MainView(Modifier, viewModel())
}