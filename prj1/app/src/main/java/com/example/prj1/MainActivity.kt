package com.example.prj1

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnDS = findViewById<Button>(R.id.buttonDate)
        val sdf=SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH)
        val cDate=sdf.parse(sdf.format(System.currentTimeMillis()))
        var selectedD=findViewById<TextView>(R.id.textView12)
        var timeinmin=findViewById<TextView>(R.id.textView11)
        selectedD.text= "1/1/1970"
        timeinmin.text="-"
        btnDS.setOnClickListener {
            clickDate()
        }

    }

    fun clickDate() {
        val myCal= Calendar.getInstance()
        val year=myCal.get(Calendar.YEAR)
        val month=myCal.get(Calendar.MONTH)
        val day=myCal.get(Calendar.DAY_OF_MONTH)
        var selectedD=findViewById<TextView>(R.id.textView12)
        var timeinmin=findViewById<TextView>(R.id.textView11)

        val dpd=DatePickerDialog( this,
            DatePickerDialog.OnDateSetListener { view, year, month, day ->
//                Toast.makeText(this,
//                    "$day  ${month+1}  $year",Toast.LENGTH_LONG).show()
                selectedD.text="$day/${month+1}/$year"
                val selectDate="$day/${month+1}/$year"
                val sdf=SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH)
                val date=sdf.parse(selectDate)
                val DOBinM=date.time/ 60000
                val cDate=sdf.parse(sdf.format(System.currentTimeMillis()))
                val CDinM=cDate.time/60000
                val ans=CDinM-DOBinM
                timeinmin.text=ans.toString()
            },
            year,
            month,
            day
        )
        dpd.datePicker.maxDate=System.currentTimeMillis()-60*60*24
        dpd.show()

        Toast.makeText(this,
        "datePicker Pressed",Toast.LENGTH_LONG).show()

        }
    }



