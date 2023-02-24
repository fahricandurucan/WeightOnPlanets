package com.example.weightonplanets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val KILO_TO_POUND = 2.2045
    val MARS = 0.38
    val POUND_TO_KILO = 0.45359237

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var weightOfUser = editTextWeight.text

        button.setOnClickListener {
            var userPound = kiloToPound(weightOfUser.toString().toDouble())
            var weightOnMarsPound = userPound*MARS
            var weightOnMarsKilo = poundToKilo(weightOnMarsPound)
            textViewResult.text = weightOnMarsKilo.format().toString()
        }
    }


    fun kiloToPound(kilo:Double) : Double{
        return (kilo*KILO_TO_POUND)
    }

    fun poundToKilo(pound:Double) : Double{
        return (pound*POUND_TO_KILO)
    }

    fun Double.format() = java.lang.String.format("%.${1}f",this)
}