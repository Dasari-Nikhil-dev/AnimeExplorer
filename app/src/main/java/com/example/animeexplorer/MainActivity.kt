package com.example.animeexplorer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.animeexplorer.data.AnimeRepository
import com.example.animeexplorer.data.local.AnimeDatabase
import com.example.animeexplorer.ui.common.AnimeViewModelFactory
import com.example.animeexplorer.ui.detail.AnimeDetailScreen
import com.example.animeexplorer.ui.list.AnimeListScreen
import com.example.animeexplorer.ui.detail.AnimeDetailViewModel
import com.example.animeexplorer.ui.list.AnimeListViewModel

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = AnimeDatabase.getDatabase(this)
        val dao = db.AnimeDao()
        val repo = AnimeRepository(dao)
        val factory = AnimeViewModelFactory(repo)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {
                            Text(
                                "Anime Explorer",
                                style = MaterialTheme.typography.titleLarge
                            )
                        },
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = Color(0xFF1E1E2E),
                            titleContentColor = Color.White
                        )
                    )
                }
            ) { padding ->
                NavHost(
                    navController,
                    startDestination = "anime_list",
                    modifier = Modifier.padding(padding)
                ) {
                    composable("anime_list") {
                        val listViewModel: AnimeListViewModel = viewModel(factory = factory)
                        AnimeListScreen(listViewModel) { animeId ->
                            navController.navigate("anime_detail/$animeId")
                        }
                    }
                    composable(
                        "anime_detail/{animeId}",
                        arguments = listOf(navArgument("animeId") { type = NavType.IntType })
                    ) { backStackEntry ->
                        val id = backStackEntry.arguments?.getInt("animeId") ?: 0
                        val detailViewModel: AnimeDetailViewModel = viewModel(factory = factory)
                        detailViewModel.loadAnimeDetail(id)
                        AnimeDetailScreen(detailViewModel) {
                            navController.popBackStack()
                        }
                    }
                }
            }
        }
    }
}



