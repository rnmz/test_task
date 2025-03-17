package dev.runo.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.Multibinds
import dev.runo.core.navigation.NavGraphProvider
import dev.runo.core.navigation.NavigationHelper

@Module
@InstallIn(SingletonComponent::class)
class CoreModule {

    @Provides
    fun provideNavigationHelper(navGraphProviders: Set<@JvmSuppressWildcards NavGraphProvider>): NavigationHelper {
        return NavigationHelper(navGraphProviders)
    }
}

@Module
@InstallIn(SingletonComponent::class)
abstract class CoreModuleHelper {

    @Multibinds
    abstract fun bindNavGraphProviders(): Set<NavGraphProvider>
}