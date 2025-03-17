package dev.runo.onboarding.di

import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet
import dev.runo.core.navigation.NavGraphProvider
import dev.runo.onboarding.OnboardNavigationGraph
import dev.runo.onboarding.data.SettingsStore

@Module
@InstallIn(SingletonComponent::class)
abstract class OnboardingModuleGraph {

    @Binds
    @IntoSet
    abstract fun bindOnboardNavGraphProvider(provider: OnboardNavigationGraph): NavGraphProvider
}

@Module
@InstallIn(ViewModelComponent::class)
class OnboardingModule {
    @Provides
    fun provideSettingStore(@ApplicationContext context: Context): SettingsStore {
        return SettingsStore(context)
    }
}