package dev.runo.home.domain.repository

import dev.runo.home.domain.model.CourseModel
import kotlinx.coroutines.flow.Flow

interface CourseRepository {
    fun getAllCourses(reversed: Boolean): Flow<CourseModel>
}