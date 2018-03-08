package nconklin.com.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.absoluteValue

class MainActivity : AppCompatActivity() {

    // The confirmed text to be entered+
    private var outputText = ""
    // The full number currently being entered
    private var operand = ""
    private var outputList: MutableList<String> = mutableListOf()

    private fun clearAll() {
        operand = ""
        outputText = ""
        txtOutput.text = ""
        txtInterimCalculation.text = ""
    }

    private fun clearOutput() {
        operand = ""
        outputText = ""
        txtOutput.text = ""
    }

    private fun addOutputNumber (number : String) {
        if (operand == "0") {
            operand = ""
        }

        operand += number
        txtOutput.text = outputText + operand
    }

    private fun addOperation(operationType : String) {
        if (operand == "") {
            // Do nothing
        } else {
            outputText = operand
            outputList.add(outputText)
            outputList.add(operationType)
            txtInterimCalculation.text = outputList.toString() // Leave for now to show the list is working
            operand = ""
        }
    }

    private fun setPlusMinus(number : String) {
        var number = number

        if (number.toInt() > 0) {
            number = "-$number"
            txtOutput.text = number
        } else if (number.toInt() < 0) {
            number = number.toInt().absoluteValue.toString()
            txtOutput.text = number
        }
    }

    private fun addDecimal(number : String) {
        var number = number

        if (number == "") {
            number = "0."
            txtOutput.text = number
        } else {
            number += "."
            txtOutput.text = number
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnClear.setOnClickListener {
            clearAll()
        }

        btn0.setOnClickListener {
            addOutputNumber("0")
        }

        btn1.setOnClickListener {
            addOutputNumber("1")
        }

        btn2.setOnClickListener {
            addOutputNumber("2")
        }

        btn3.setOnClickListener {
            addOutputNumber("3")
        }

        btn4.setOnClickListener {
            addOutputNumber("4")
        }

        btn5.setOnClickListener {
            addOutputNumber("5")
        }

        btn6.setOnClickListener {
            addOutputNumber("6")
        }

        btn7.setOnClickListener {
            addOutputNumber("7")
        }

        btn8.setOnClickListener {
            addOutputNumber("8")
        }

        btn9.setOnClickListener {
            addOutputNumber("9")
        }

        btnAdd.setOnClickListener {
            addOperation("+")
            clearOutput()
        }

        btnSubtract.setOnClickListener {
            addOperation("-")
            clearOutput()
        }

        btnMultiply.setOnClickListener {
            addOperation("*")
            clearOutput()
        }

        btnDivide.setOnClickListener {
            addOperation("/")
            clearOutput()
        }

        btnPlusMinus.setOnClickListener {
            setPlusMinus(operand)
        }

        btnPeriod.setOnClickListener {
            addDecimal(operand)
        }
    }
}
