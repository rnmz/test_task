package dev.runo.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.runo.onboarding.data.SettingsStore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardViewModel @Inject constructor(private val settingsStore: SettingsStore) : ViewModel() {

    private val _isFirstEnter = MutableStateFlow(true)
    val isFirstEnter = _isFirstEnter
        .onStart { loadSettings() }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            true
        )

    private fun loadSettings() {
        viewModelScope.launch {
            _isFirstEnter.value = settingsStore.getFirstEntrance()
        }
    }

    fun updateFirstEnter() {
        viewModelScope.launch {
            settingsStore.setFirstEntrance()
        }
    }
}