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

    /**
     * Adds the number input by the user onto the screen
     *
     * @param number The number that the user wishes to enter onto the screen
     */
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

    private fun setPlusMinus() {
        if ("-" in operand) {
            operand = operand.toInt().absoluteValue.toString()
            txtOutput.text = operand
        } else {
            operand = "-$operand"
            txtOutput.text = operand
        }
    }

    private fun addDecimal() {
        if (operand == "") {
            operand = "0."
            txtOutput.text = operand
        } else {
            operand += "."
            txtOutput.text = operand
        }
    }

    private fun addParens() {
        if (operand == "") {
            // Do nothing
        } else {
            operand = "($operand"
            txtOutput.text = operand
        }

        if ("(" in operand) {
            operand = "$operand)"
            txtOutput.text = operand
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
            setPlusMinus()
        }

        btnPeriod.setOnClickListener {
            addDecimal()
        }

        btnParen.setOnClickListener {
            addParens()
        }
    }
}
