package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import java.text.SimpleDateFormat

class KalenderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kalender)

        val mButton = findViewById<Button>(R.id.button_1)

        // Event start and end time with date
        val startTime = "2022-02-1T09:00:00"
        val endTime = "2022-02-1T12:00:00"

        // Parsing the date and time
        val mSimpleDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        val mStartTime = mSimpleDateFormat.parse(startTime)
        val mEndTime = mSimpleDateFormat.parse(endTime)


        // When Button is clicked, Intent started
        // to create an event with given time
        mButton.setOnClickListener {
            val mIntent = Intent(Intent.ACTION_EDIT)
            mIntent.type = "vnd.android.cursor.item/event"
            mIntent.putExtra("beginTime", mStartTime.time)
            mIntent.putExtra("time", true)
            mIntent.putExtra("rule", "FREQ=YEARLY")
            mIntent.putExtra("endTime", mEndTime.time)
            mIntent.putExtra("title", "Geeksforgeeks Event")
            startActivity(mIntent)
        }
    }

    }

