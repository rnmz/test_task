package dev.runo.auth.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet
import dev.runo.auth.ui.AuthNavigationProvider
import dev.runo.core.navigation.NavGraphProvider

@Module
@InstallIn(SingletonComponent::class)
abstract class AuthModuleGraph {
    @Binds
    @IntoSet
    abstract fun provideAuthNavGraphProvider(provider: AuthNavigationProvider): NavGraphProvider
}