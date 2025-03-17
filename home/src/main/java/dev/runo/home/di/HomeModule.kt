package dev.runo.home.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet
import dev.runo.core.navigation.NavGraphProvider
import dev.runo.home.data.DefaultCourseRepository
import dev.runo.home.data.remote.CourseAPI
import dev.runo.home.domain.repository.CourseRepository
import dev.runo.home.ui.HomeNavigationProvider
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
class HomeModule {

    @Provides
    fun provideCourseRepository(courseAPI: CourseAPI): CourseRepository {
        return DefaultCourseRepository(courseAPI)
    }

    @Provides
    fun provideCourseApi(retrofit: Retrofit): CourseAPI {
        return retrofit.create(CourseAPI::class.java)
    }
}

@Module
@InstallIn(SingletonComponent::class)
abstract class HomeModuleGraph {

    @Binds
    @IntoSet
    abstract fun provideHomeNavGraphProvider(provider: HomeNavigationProvider): NavGraphProvider
}
