package dev.runo.home.data

import dev.runo.home.data.remote.CourseModelApi
import dev.runo.home.domain.model.CourseModel

object ConvertCourseModel {

    fun toDomain(courseModelApi: CourseModelApi) = CourseModel(
        courseModelApi.id,
        courseModelApi.title,
        courseModelApi.text,
        courseModelApi.price,
        courseModelApi.rate,
        courseModelApi.startDate,
        courseModelApi.hasLike,
        courseModelApi.publishDate
    )
}