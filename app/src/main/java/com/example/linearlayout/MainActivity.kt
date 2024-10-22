package com.example.linearlayout

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.linearlayout.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonConvertDollar.setOnClickListener {
            val euros = binding.editEuros.text.toString().trim()
            this.toastShow(this.convertDollar(euros))
        }

        binding.buttonConvertReal.setOnClickListener {
            val euros = binding.editEuros.text.toString().trim()
            this.toastShow(this.convertReal(euros))
        }

        binding.buttonConvertPeso.setOnClickListener {
            val euros = binding.editEuros.text.toString().trim()
            this.toastShow(this.convertPeso(euros))
        }
    }

    private val DOLLAR: Double = 0.8
    private val REAL: Double = 6.0
    private val PESO: Double = 10.0

    private fun convert(value: Double, coin: Double): Double {
        return value * coin
    }

    private fun convertDollar(value: String): String {
        if (!value.isEmpty()) {
            val dollars = this.convert(value.toDouble(), DOLLAR)
            val message = "${dollars} $"
            return message
        }

        return "Sem valor Inserido"
    }

    private fun convertReal(value: String): String {
        if (!value.isEmpty()) {
            val reals = this.convert(value.toDouble(), REAL)
            val message = "R$ ${reals}"
            return message
        }

        return "Sem valor Inserido"
    }

    private fun convertPeso(value: String): String {
        if (!value.isEmpty()) {
            val pesos = this.convert(value.toDouble(), PESO)
            val message = "P ${pesos}"
            return message
        }

        return "Sem valor Inserido"
    }

    private fun toastShow(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }
}

