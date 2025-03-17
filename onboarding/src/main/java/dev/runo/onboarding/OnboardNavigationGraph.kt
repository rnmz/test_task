package dev.runo.onboarding

import androidx.navigation.NavGraphBuilder
import androidx.navigation.fragment.fragment
import dev.runo.core.navigation.NavGraphProvider
import dev.runo.core.navigation.Routes
import javax.inject.Inject

class OnboardNavigationGraph @Inject constructor() : NavGraphProvider {
    override fun provideGraph(): NavGraphBuilder.() -> Unit = {
        fragment<OnboardFragment>(route = Routes.ONBOARD) {
            label = Routes.ONBOARD
        }
    }
}