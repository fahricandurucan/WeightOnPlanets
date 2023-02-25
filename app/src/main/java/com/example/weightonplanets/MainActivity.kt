package com.example.weightonplanets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.CheckBox
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    val KILO_TO_POUND = 2.2045
    val MARS = 0.38
    val VENUS = 0.91
    val JUPITER = 2.34
    val POUND_TO_KILO = 0.45359237

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cbVenus.setOnClickListener(this)
        cbMars.setOnClickListener(this)
        cbJupiter.setOnClickListener(this)

        /*button.setOnClickListener {
            var userPound = kiloToPound(weightOfUser.toString().toDouble())
            var weightOnMarsPound = userPound*MARS
            var weightOnMarsKilo = poundToKilo(weightOnMarsPound)
            textViewResult.text = weightOnMarsKilo.format().toString()
        }*/
    }


    fun kiloToPound(kilo:Double) : Double{
        return (kilo*KILO_TO_POUND)
    }

    fun poundToKilo(pound:Double) : Double{
        return (pound*POUND_TO_KILO)
    }

    fun Double.format() = java.lang.String.format("%.${2}f",this)
    override fun onClick(v: View?) {
        v as CheckBox
        var isChecked:Boolean = v.isChecked


        if(!TextUtils.isEmpty(editTextWeight.text.toString())){
            var weightOfUser:Double = editTextWeight.text.toString().toDouble()
            var poundOfUser = kiloToPound(weightOfUser)
            when(v.id){
                R.id.cbMars -> if(isChecked){
                    cbVenus.isChecked = false
                    cbJupiter.isChecked = false
                    calculateWeightPound(poundOfUser,v)
                }
                R.id.cbVenus -> if(isChecked){
                    cbMars.isChecked = false
                    cbJupiter.isChecked = false
                    calculateWeightPound(poundOfUser,v)
                }
                R.id.cbJupiter -> if(isChecked){
                    cbVenus.isChecked = false
                    cbMars.isChecked = false
                    calculateWeightPound(poundOfUser,v)
                }
            }
        }


    }


    fun calculateWeightPound(pound:Double, checkBox:CheckBox){
        var result : Double = 0.0
        when(checkBox.id){
            R.id.cbMars -> result = pound*MARS
            R.id.cbVenus -> result = pound*VENUS
            R.id.cbJupiter -> result = pound*JUPITER
            else -> result = 0.0
        }

        var resultToKilo = poundToKilo(result)
        textViewResult.text = resultToKilo.format().toString()
    }

}