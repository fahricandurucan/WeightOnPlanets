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
    val MERKUR = 0.38
    val SATURN = 1.06
    val URANUS = 0.92
    val NEPTUN = 1.19
    val DUNYA = 1
    val POUND_TO_KILO = 0.45359237

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cbVenus.setOnClickListener(this)
        cbMars.setOnClickListener(this)
        cbJupiter.setOnClickListener(this)
        cbMerkur.setOnClickListener(this)
        cbSaturn.setOnClickListener(this)
        cbUranus.setOnClickListener(this)
        cbDunya.setOnClickListener(this)
        cbNeptun.setOnClickListener(this)

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
                    cbMerkur.isChecked = false
                    cbSaturn.isChecked = false
                    cbUranus.isChecked = false
                    cbDunya.isChecked = false
                    cbNeptun.isChecked = false
                    calculateWeightPound(poundOfUser,v)
                }
                R.id.cbVenus -> if(isChecked){
                    cbMars.isChecked = false
                    cbJupiter.isChecked = false
                    cbMerkur.isChecked = false
                    cbSaturn.isChecked = false
                    cbUranus.isChecked = false
                    cbDunya.isChecked = false
                    cbNeptun.isChecked = false
                    calculateWeightPound(poundOfUser,v)
                }
                R.id.cbJupiter -> if(isChecked){
                    cbVenus.isChecked = false
                    cbMars.isChecked = false
                    cbMerkur.isChecked = false
                    cbSaturn.isChecked = false
                    cbUranus.isChecked = false
                    cbDunya.isChecked = false
                    cbNeptun.isChecked = false
                    calculateWeightPound(poundOfUser,v)
                }
                R.id.cbMerkur -> if(isChecked){
                    cbMars.isChecked = false
                    cbVenus.isChecked = false
                    cbJupiter.isChecked = false
                    cbSaturn.isChecked = false
                    cbUranus.isChecked = false
                    cbDunya.isChecked = false
                    cbNeptun.isChecked = false
                    calculateWeightPound(poundOfUser,v)
                }
                R.id.cbSaturn -> if(isChecked){
                    cbMars.isChecked = false
                    cbJupiter.isChecked = false
                    cbMerkur.isChecked = false
                    cbUranus.isChecked = false
                    cbDunya.isChecked = false
                    cbNeptun.isChecked = false
                    cbVenus.isChecked = false
                    calculateWeightPound(poundOfUser,v)
                }
                R.id.cbUranus -> if(isChecked){
                    cbMars.isChecked = false
                    cbJupiter.isChecked = false
                    cbMerkur.isChecked = false
                    cbSaturn.isChecked = false
                    cbDunya.isChecked = false
                    cbNeptun.isChecked = false
                    cbVenus.isChecked = false
                    calculateWeightPound(poundOfUser,v)
                }
                R.id.cbDunya -> if(isChecked){
                    cbMars.isChecked = false
                    cbJupiter.isChecked = false
                    cbMerkur.isChecked = false
                    cbSaturn.isChecked = false
                    cbUranus.isChecked = false
                    cbNeptun.isChecked = false
                    cbVenus.isChecked = false
                    calculateWeightPound(poundOfUser,v)
                }
                R.id.cbNeptun -> if(isChecked){
                    cbMars.isChecked = false
                    cbJupiter.isChecked = false
                    cbMerkur.isChecked = false
                    cbSaturn.isChecked = false
                    cbUranus.isChecked = false
                    cbDunya.isChecked = false
                    cbVenus.isChecked = false
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
            R.id.cbMerkur -> result = pound*MERKUR
            R.id.cbSaturn -> result = pound*SATURN
            R.id.cbUranus -> result = pound*URANUS
            R.id.cbDunya -> result = pound*DUNYA
            R.id.cbNeptun -> result = pound*NEPTUN
            else -> result = 0.0
        }

        var resultToKilo = poundToKilo(result)
        textViewResult.text = resultToKilo.format().toString()
    }

}