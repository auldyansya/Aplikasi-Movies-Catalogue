package com.auldy.moviecatalogue.alarm

import android.content.Context
import androidx.core.content.edit

/**
 * 12/05/2021
 * AULDY ANSYA RULLAH
 */
class ReminderPreference (context: Context) {
    companion object {
        const val PREFS_NAME = "reminder_preference"
        const val REMIND_KEY = "reminded"
    }

    private val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    fun setReminder(value: Reminder) {
        prefs.edit {
            putBoolean(REMIND_KEY, value.isReminded)
            apply()
        }
    }

    fun getReminder(): Reminder {
        val model = Reminder()
        model.isReminded = prefs.getBoolean(REMIND_KEY, false)
        return model
    }
}