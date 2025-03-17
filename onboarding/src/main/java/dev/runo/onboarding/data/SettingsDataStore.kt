package dev.runo.onboarding.data

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import dev.runo.onboarding.settingsStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SettingsStore @Inject constructor(private val context: Context) {

    private val firstEntranceKey = booleanPreferencesKey("first_entrance")

    /**
     * Checks if this the first entrance to the app.
     * @return `true` if yes, `false` if no
     */
    suspend fun getFirstEntrance(): Boolean {
        val isFirstEntrance = context.settingsStore.data
            .map {
                it[firstEntranceKey] ?: true
            }.first()
        return isFirstEntrance
    }

    suspend fun setFirstEntrance() {
        context.settingsStore.edit {
            it[firstEntranceKey] = false
        }
    }

}