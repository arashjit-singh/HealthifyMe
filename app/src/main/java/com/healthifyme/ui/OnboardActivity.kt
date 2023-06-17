package com.healthifyme.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.healthifyme.ui.screens.home_screen.HomeScreen
import com.healthifyme.ui.screens.onboarding.gender.GenderSelectionScreen
import com.healthifyme.ui.screens.onboarding.goal.GoalScreen
import com.healthifyme.ui.screens.onboarding.height.HeightScreen
import com.healthifyme.ui.screens.onboarding.nutrient_goal.NutrientGoalScreen
import com.healthifyme.ui.screens.onboarding.weight.WeightScreen
import com.healthifyme.ui.screens.onboarding.welcome.WelcomeScreen
import com.healthifyme.ui.screens.search.SearchScreen
import com.healthifyme.ui.theme.HealthifyMeTheme
import com.healthifyme.util.Routes
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@OptIn(ExperimentalMaterial3Api::class)
class OnboardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HealthifyMeTheme {
                val navController = rememberNavController()
                val snackbarHostState = remember {
                    SnackbarHostState()
                }
                Scaffold(
                    snackbarHost = {
                        SnackbarHost(hostState = snackbarHostState)
                    }
                ) { innerPadding ->
                    // Screen content
                    Box(modifier = Modifier.padding(innerPadding)) {
                        NavHost(
                            navController = navController,
                            startDestination = Routes.ROUTE_HOME_SCREEN
                        ) {
                            composable(Routes.ROUTE_WELCOME) {
                                WelcomeScreen() {
                                    navController.navigate(Routes.ROUTE_GENDER)
                                }
                            }
                            composable(Routes.ROUTE_GENDER) {
                                GenderSelectionScreen(navClickCallback = {
                                    navController.navigate(Routes.ROUTE_WEIGHT)
                                })
                            }
                            composable(Routes.ROUTE_WEIGHT) {
                                WeightScreen(navClickCallback = {
                                    navController.navigate(Routes.ROUTE_HEIGHT)
                                })
                            }
                            composable(Routes.ROUTE_HEIGHT) {
                                HeightScreen(navClickCallback = {
                                    navController.navigate(Routes.ROUTE_GOAL)
                                })
                            }
                            composable(Routes.ROUTE_GOAL) {
                                GoalScreen(navClickCallback = {
                                    navController.navigate(Routes.ROUTE_NUTRITION_ROUTE)
                                })
                            }
                            composable(Routes.ROUTE_NUTRITION_ROUTE) {
                                NutrientGoalScreen(snackbarHostState)
                            }
                            composable(Routes.ROUTE_SEARCH_FOOD) {
                                SearchScreen(snackbarHostState)
                            }
                            composable(Routes.ROUTE_HOME_SCREEN) {
                                HomeScreen()
                            }
                        }
                    }
                }
            }
        }
    }
}
