package dev.runo.auth.ui

import androidx.navigation.NavGraphBuilder
import androidx.navigation.fragment.fragment
import dev.runo.core.navigation.NavGraphProvider
import dev.runo.core.navigation.Routes
import javax.inject.Inject

class AuthNavigationProvider @Inject constructor() : NavGraphProvider {
    override fun provideGraph(): NavGraphBuilder.() -> Unit = {
        fragment<AuthFragment>(Routes.AUTH) {
            label = Routes.AUTH
        }
    }
}