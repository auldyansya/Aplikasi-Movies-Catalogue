package com.auldy.moviecatalogue.ui.setting

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.auldy.moviecatalogue.R
import com.auldy.moviecatalogue.alarm.AlarmReceiver
import com.auldy.moviecatalogue.alarm.Reminder
import com.auldy.moviecatalogue.alarm.ReminderPreference
import com.auldy.moviecatalogue.databinding.ActivitySettingBinding
import com.auldy.moviecatalogue.ui.about.AboutActivity

/**
 * 12/05/2021
 * AULDY ANSYA RULLAH
 */
class SettingActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingBinding
    private lateinit var reminder: Reminder
    private lateinit var alarmReceiver: AlarmReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title =
            applicationContext.resources.getString(R.string.setting)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.elevation = 0f

        val reminderPreference = ReminderPreference(this)
        binding.reminder.isChecked = reminderPreference.getReminder().isReminded

        alarmReceiver = AlarmReceiver()
        binding.reminder.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                saveReminder(true)
                alarmReceiver.setRepeatingAlarm(
                    this,
                    "RepeatingAlarm",
                    "12:00",
                    "AYOK TONTON FILM YG SERU HARI INI DI MOVIE CATALOGUE"
                )
            } else {
                saveReminder(false)
                alarmReceiver.cancelAlarm(this)
            }
        }

        binding.btnAbout.setOnClickListener{
            val moveabout = Intent(this@SettingActivity, AboutActivity::class.java)
            startActivity(moveabout)
        }
    }


    private fun saveReminder(state: Boolean) {
        val remind = ReminderPreference(this)
        reminder = Reminder()
        reminder.isReminded = state
        remind.setReminder(reminder)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}