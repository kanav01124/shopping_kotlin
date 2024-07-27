package com.example.ascendio.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ascendio.ChocolateViewModel
import com.example.ascendio.presentation.bill.BillScreen
import com.example.ascendio.presentation.chocolates.ChocolateScreen
import com.example.ascendio.presentation.start.StartScreen
import com.example.ascendio.presentation.vegetable.VegetableScreen

@Composable
fun NavGraph(
    navHostController: NavHostController,
    chocolateViewModel: ChocolateViewModel = viewModel()
) {
    NavHost(navController = navHostController, startDestination = "start") {
        composable(
            "start"
        ) {
            StartScreen(
                onStartClick = {
                    navHostController.navigate("vegetables")
                }
            )
        }
        composable("vegetables") {
            VegetableScreen(
                vegetableViewModel = chocolateViewModel,
                onNextClick = {
                    navHostController.navigate("chocolates")
                },
                onCancelClick = {
                    navHostController.navigate("start", navOptions = NavOptions.Builder()
                        .setPopUpTo("start", true).build())
                    chocolateViewModel.reset()
                }
            )
        }
        composable("chocolates") {
            ChocolateScreen(
                chocolateViewModel = chocolateViewModel,
                onNextClick = {
                    navHostController.navigate("bill")
                },
                onCancelClick = {
                    navHostController.navigate("start", navOptions = NavOptions.Builder()
                        .setPopUpTo("start", true).build())
                    chocolateViewModel.reset()
                }
            )
        }
        composable("bill") {
            BillScreen(billViewModel = chocolateViewModel,
                onClick = {
                    navHostController.navigate("start", navOptions = NavOptions.Builder()
                        .setPopUpTo("start", true).build())
                    chocolateViewModel.reset()
                })
        }
    }
}