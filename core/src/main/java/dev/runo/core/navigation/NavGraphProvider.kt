package dev.runo.core.navigation

import androidx.navigation.NavGraphBuilder

fun interface NavGraphProvider {
    fun provideGraph(): NavGraphBuilder.() -> Unit
}