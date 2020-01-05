package com.example.insurancepremiumcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var premiumModel: PremiumViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        premiumModel =ViewModelProviders.of(this).get(PremiumViewModel::class.java)

        display()

        btnCal.setOnClickListener(){
            premiumModel.premium = getPremium()
            display()
        }

        btnReset.setOnClickListener(){
            spinnerAge.setSelection(0)
            radGroup.clearCheck()
            chkSmoker.setChecked(false)
            txtAPremium.text = ""
        }
    }

   private fun display(){
        txtAPremium.text = premiumModel.premium.toString()
    }

   private fun getPremium():Double{

        return when(spinnerAge.selectedItemPosition){

            0 -> 60.00
            1 -> 70.00 +
                    (if(radMale.isChecked) 50.00 else 0.0)+
                    (if(chkSmoker.isChecked) 100.00 else 0.0)
            2 -> 90.00 +
                    (if(radMale.isChecked) 50.00 else 0.0)+
                    (if(chkSmoker.isChecked) 150.00 else 0.0)
            3 -> 120.00 +
                    (if(radMale.isChecked) 50.00 else 0.0)+
                    (if(chkSmoker.isChecked) 200.00 else 0.0)
            4 -> 150.00 +
                    (if(radMale.isChecked) 50.00 else 0.0)+
                    (if(chkSmoker.isChecked) 250.00 else 0.0)
            else -> 150.00 +
                    (if(radMale.isChecked) 50.00 else 0.0)+
                    (if(chkSmoker.isChecked) 300.00 else 0.0)
        }

    }
}
