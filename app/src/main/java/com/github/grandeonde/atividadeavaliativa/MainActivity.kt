package com.github.grandeonde.atividadeavaliativa

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.grandeonde.atividadeavaliativa.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calcularBotao.setOnClickListener { calcularPeso() }
    }

    private fun calcularPeso() {
        val stringInTextField = binding.Quantia.text.toString()
        val peso = stringInTextField.toDouble()
        if (peso == null) {
            binding.resultadoFinal.text = ""
            return
        }

        val escolha = when (binding.botoes.checkedRadioButtonId) {
            R.id.option_lb_kg -> 0.45
            R.id.option_kg_lb -> 2.2
        }

        var tip = escolha * peso

        val formattedTip = NumberFormat.getCurrencyInstance().format(floatValue)
        binding.resultadoFinal.text = getString(R.string.resultado, formattedTip)
    }
}

