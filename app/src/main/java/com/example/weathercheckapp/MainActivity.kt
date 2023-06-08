package com.example.weathercheckapp

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.weathercheckapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //variables
        var temperatureUnit = "Celsius"
        var weatherCondition = "Sunny"
        var location = "New York"

        //toggle button on-click function
        binding.toggleButton.setOnClickListener {
            if (binding.toggleButton.isChecked) {
                temperatureUnit = "Celsius"
            } else {
                temperatureUnit = "Fahrenheit"
            }
        }

        //checkbox on-click functions
        binding.checkBoxCloudy.setOnClickListener {
            if (binding.checkBoxCloudy.isChecked) {
                Toast.makeText(applicationContext, "Cloudy", Toast.LENGTH_SHORT).show()
                weatherCondition = "Cloudy"
            }
        }
        binding.checkBoxRainy.setOnClickListener {
            if (binding.checkBoxRainy.isChecked) {
                Toast.makeText(applicationContext, "Rainy", Toast.LENGTH_SHORT).show()
                weatherCondition = "Rainy"
            }
        }
        binding.checkBoxSunny.setOnClickListener {
            if (binding.checkBoxSunny.isChecked) {
                Toast.makeText(applicationContext, "Sunny", Toast.LENGTH_SHORT).show()
                weatherCondition = "Sunny"
            }
        }

        //radio buttons on-click functions
        binding.radioButtonOption1.setOnClickListener {
            if (binding.radioButtonOption1.isChecked) {
                Toast.makeText(applicationContext, "Option 1", Toast.LENGTH_SHORT).show()
            }
        }
        binding.radioButtonOption2.setOnClickListener {
            if (binding.radioButtonOption2.isChecked) {
                Toast.makeText(applicationContext, "Option 2", Toast.LENGTH_SHORT).show()
            }
        }

        //spinner function
        val spinnerItems = arrayListOf<String>("Select Location","New York", "London", "Tokyo")
        val adapter = ArrayAdapter(this@MainActivity, android.R.layout.simple_spinner_item, spinnerItems)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinner.adapter = adapter

        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedItem = spinnerItems[position]
                if (selectedItem == spinnerItems[0]) {
                    location = "None Selected"
                } else {
                    location = selectedItem
                    Toast.makeText(applicationContext, selectedItem, Toast.LENGTH_SHORT).show()
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(applicationContext, "Nothing is Selected", Toast.LENGTH_SHORT).show()
            }
        }

        //frame layout on-click function
        //Show a dialog box with the selected options (temperature unit, weather conditions, and location) when the FrameLayout is clicked.
        binding.frameLayout.setOnClickListener {
            val alertDialogBuilder = AlertDialog.Builder(this)
            alertDialogBuilder.setTitle("Options Selected")
            alertDialogBuilder.setMessage("Temp Unit: $temperatureUnit\nWeather Condition: $weatherCondition\nLocation: $location")

            alertDialogBuilder.setPositiveButton("OK") { _:DialogInterface, _:Int -> }
            alertDialogBuilder.create().show()
        }


    }
}