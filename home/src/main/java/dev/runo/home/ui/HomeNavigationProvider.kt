package dev.runo.home.ui

import androidx.navigation.NavGraphBuilder
import androidx.navigation.fragment.fragment
import dev.runo.core.navigation.NavGraphProvider
import dev.runo.core.navigation.Routes
import javax.inject.Inject

class HomeNavigationProvider @Inject constructor(): NavGraphProvider {
    override fun provideGraph(): NavGraphBuilder.() -> Unit = {
        fragment<HomeFragment>(Routes.HOME) {
            label = Routes.HOME
        }
    }
}