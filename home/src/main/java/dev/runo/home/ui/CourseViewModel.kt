package dev.runo.home.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.runo.home.domain.model.CourseModel
import dev.runo.home.domain.repository.CourseRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CourseViewModel @Inject constructor(private val repository: CourseRepository): ViewModel() {
    private val _coursesList = MutableStateFlow<List<CourseUiState>>(listOf())
    val coursesList = _coursesList
        .onStart { loadCourses() }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            listOf()
        ).asLiveData()

    fun loadCourses(reversed: Boolean = false) {
        viewModelScope.launch {
            repository.getAllCourses(reversed).collect {
                _coursesList.value += convertDomainModel(it)
            }
        }
    }

    fun updateFavouriteStatus(id: Int) {
        viewModelScope.launch {
            _coursesList.value = _coursesList.value.map {
                if (it.id == id) {
                    it.copy(hasLike = !it.hasLike)
                } else {
                    it
                }
            }
        }
    }

    private fun convertDomainModel(model: CourseModel) = CourseUiState(
        model.id,
        model.title,
        model.description,
        model.price,
        model.rate,
        model.startDate,
        model.hasLike,
        model.publishDate
    )
}