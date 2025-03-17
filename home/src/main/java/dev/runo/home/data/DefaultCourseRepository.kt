package dev.runo.home.data

import android.util.Log
import dev.runo.home.data.remote.CourseAPI
import dev.runo.home.domain.model.CourseModel
import dev.runo.home.domain.repository.CourseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class DefaultCourseRepository @Inject constructor(private val courseAPI: CourseAPI) : CourseRepository {

    /*
    Сейчас я сделаю кое что плохое: Реверсну список прямо в "ответе" от сервера.
    Это ОЧЕНЬ плохо т.к. сервер должен иметь пагинацию элементов, но т.к. её тут нету - сделаю таким
    образом из-за ТЗ.
     */

    override fun getAllCourses(reversed: Boolean) = flow<CourseModel> {
        val response = courseAPI.getCourses()
        if (response.isSuccessful) {
            if (reversed) {
                response.body()?.courses?.sortedByDescending { it.publishDate }?.map { emit(ConvertCourseModel.toDomain(it)) }
            }
            else {
                response.body()?.courses?.map { emit(ConvertCourseModel.toDomain(it)) }
            }
        }
        else {
            Log.e("test_task", "server not responding")
        }
    }.flowOn(Dispatchers.IO)

}