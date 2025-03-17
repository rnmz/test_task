package dev.runo.core.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.createGraph
import javax.inject.Inject

class NavigationHelper @Inject constructor(
    private val navGraphProviders: Set<@JvmSuppressWildcards NavGraphProvider>
) {

    fun createNavGraph(navController: NavController): NavGraph {
        return navController.createGraph(
            startDestination = Routes.ONBOARD
        ) {
            navGraphProviders.forEach { it.provideGraph().invoke(this) }
        }
    }

    fun navigateTo(route: String, navController: NavController) {
        navController.navigate(route)
    }

    fun getCurrentNavigation(navController: NavController): String? {
        return navController.currentDestination?.label?.toString()
    }
}