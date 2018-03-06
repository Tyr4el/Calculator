package nconklin.com.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var outputText = ""
    private var operand = ""
    private var firstNumber : Int = 0

    private fun clearAll() {
        operand = ""
        firstNumber = 0
        outputText = ""
        txtOutput.text = ""
        txtLeftSide.text = ""
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

    private fun getFirstNumber (operationType: String) {
        // Check if anything was entered before pressing an operation
        if (firstNumber == 0) {
            firstNumber = operand.toInt()
            outputText = operand //+ " " + operationType + " "
            txtLeftSide.text = outputText + " " + operationType + " "
            operand = ""
        } else {
            // TODO: Do stuff here
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
            getFirstNumber("+")
            clearOutput()
        }

        btnSubtract.setOnClickListener {
            getFirstNumber("-")
            clearOutput()
        }

        btnMultiply.setOnClickListener {
            getFirstNumber("*")
            clearOutput()
        }

        btnDivide.setOnClickListener {
            getFirstNumber("/")
            clearOutput()
        }
    }
}
