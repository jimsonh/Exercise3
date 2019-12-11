package com.example.exercise3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.exercise3.databinding.ActivityMainBinding
import android.widget.RadioButton
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.buttonCalculate.setOnClickListener{
            cal(it)
        }

        binding.buttonReset.setOnClickListener{
            reset()
        }


    }

    private fun reset() {
        binding.apply {
            radioGroupGender.clearCheck()
            checkBoxSmoker.isChecked = false
            textViewPremium.setText(R.string.insurance_premium)
            spinnerAge.setSelection(0)
        }


    }

    private fun cal(view: View) {
        binding.apply {

            var basePrice =0
            var extra =0
            var smoker =0


            if (spinnerAge.selectedItem.toString()=="Less than 17")
            {
                basePrice = 60
            }

            else if(spinnerAge.selectedItem.toString()=="17 to 25"){
                basePrice = 70

                if(radioGroupGender.checkedRadioButtonId.equals(radioButtonMale.id)){
                    extra = 50
                }

                if(checkBoxSmoker.isChecked){
                    smoker=100
                }

            }

            else if(spinnerAge.selectedItem.toString()=="26 to 30")
            {
                basePrice = 90
                if(radioGroupGender.checkedRadioButtonId.equals(radioButtonMale.id)){
                    extra = 100
                }


                if(checkBoxSmoker.isChecked){
                    smoker = 150
                }
            }
            else if(spinnerAge.selectedItem.toString()=="31 to 40")
            {
                basePrice = 70
                if(radioGroupGender.checkedRadioButtonId.equals(radioButtonMale.id)){
                    extra = 150
                }

                if(checkBoxSmoker.isChecked){
                    smoker = 200
                }
            }
            else if(spinnerAge.selectedItem.toString()=="41 to 55")
            {
                basePrice = 150
                if(radioGroupGender.checkedRadioButtonId.equals(radioButtonMale.id)){
                    extra = 200
                }


                if(checkBoxSmoker.isChecked){
                    smoker = 250
                }
            }
            else
            {
                basePrice = 150
                if(radioGroupGender.checkedRadioButtonId.equals(radioButtonMale.id)){
                    extra = 200
                }


                if(checkBoxSmoker.isChecked){
                    smoker = 300
                }
            }

            var totalPrice = basePrice+smoker+extra

            textViewPremium.text= "Insurance Premium: RM"+totalPrice.toString()
        }


    }
}
