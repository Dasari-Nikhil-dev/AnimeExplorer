package com.example.animeexplorer.ui.list

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun AnimeListScreen(viewmodel: AnimeListViewModel, onClick: (Int) -> Unit) {
    val animeList by viewmodel.topAnime.observeAsState(emptyList())
    if (animeList.isEmpty()) {
        Text("Loading...", modifier = Modifier.fillMaxSize(), textAlign = TextAlign.Center)
    } else {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(animeList) { anime ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(260.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .clickable { onClick(anime.malId) },
                    elevation = CardDefaults.cardElevation(8.dp)
                ) {
                    Box {
                        GlideImage(
                            model = anime.images.jpg.imageUrl,
                            contentDescription = anime.title,
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.BottomStart)
                                .background(
                                    Brush.verticalGradient(
                                        listOf(Color.Transparent, Color(0xAA000000))
                                    )
                                )
                                .padding(8.dp)
                        ) {
                            Column {
                                Text(
                                    text = anime.title,
                                    style = MaterialTheme.typography.bodyLarge.copy(color = Color.White),
                                    maxLines = 1
                                )
                                Text(
                                    text = "Ep: ${anime.episodes ?: "?"} | Score: ${anime.score ?: "?"}",
                                    style = MaterialTheme.typography.bodySmall.copy(color = Color.LightGray)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}


