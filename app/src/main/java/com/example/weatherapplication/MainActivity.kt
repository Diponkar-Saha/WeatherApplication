package com.example.weatherapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.weatherapplication.databinding.ActivityMainBinding
import com.example.weatherapplication.viewmodel.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel:WeatherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.weatherResp.observe(this, Observer { weather ->
            binding.apply {
                tvCityName.text =  "Cumilla"
                tvTemperature.text = weather.temperature
                tvDescription.text =weather.description
                tvWind.text =weather.wind

                val forecast1 =weather.forecast[0]
                val forecast2 =weather.forecast[1]
                val forecast3 =weather.forecast[2]

                tvForecast1.text = "${forecast1.temperature}/${forecast1.wind}"
                tvForecast2.text = "${forecast1.temperature}/${forecast1.wind}"
                tvForecast3.text = "${forecast1.temperature}/${forecast1.wind}"

            }

        })

    }
}