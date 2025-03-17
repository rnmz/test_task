package dev.runo.home.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface CourseAPI {
    @GET("/courses/all")
    suspend fun getCourses(): Response<AllCoursesModelApi>
}