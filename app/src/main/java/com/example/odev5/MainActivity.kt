package com.example.odev5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.odev5.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var parantezAcik = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            button0.setOnClickListener { operationScreen.append("0") }
            button1.setOnClickListener { operationScreen.append("1") }
            button2.setOnClickListener { operationScreen.append("2") }
            button3.setOnClickListener { operationScreen.append("3") }
            button4.setOnClickListener { operationScreen.append("4") }
            button5.setOnClickListener { operationScreen.append("5") }
            button6.setOnClickListener { operationScreen.append("6") }
            button7.setOnClickListener { operationScreen.append("7") }
            button8.setOnClickListener { operationScreen.append("8") }
            button9.setOnClickListener { operationScreen.append("9") }

            commaButton.setOnClickListener { operationScreen.append(".") }
            additionButton.setOnClickListener { operationScreen.append("+") }
            substractButton.setOnClickListener { operationScreen.append("-") }
            multipleButton.setOnClickListener { operationScreen.append("*") }
            divisionButton.setOnClickListener { operationScreen.append("/") }
            modeButton.setOnClickListener { operationScreen.append("%") }

            parenthesesButton.setOnClickListener {
                if (parantezAcik) {
                    operationScreen.append("(")
                } else {
                    operationScreen.append(")")
                }
                parantezAcik = !parantezAcik
            }

            deleteButton.setOnClickListener {
                operationScreen.text = ""
                resultScreen.text = ""
                resultScreen.hint = "0"
            }

            resultButton.setOnClickListener {
                val expression = operationScreen.text.toString()
                try {
                    val result = ExpressionBuilder(expression).build().evaluate()
                    resultScreen.text = if (result % 1 == 0.0) {
                        result.toInt().toString()
                    } else {
                        String.format("%.3f", result)
                    }
                } catch (e: Exception) {
                    resultScreen.text = "Hata!"
                }
            }
        }
    }
}
