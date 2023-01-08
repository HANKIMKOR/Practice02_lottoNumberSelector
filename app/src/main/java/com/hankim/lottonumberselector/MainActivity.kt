package com.hankim.lottonumberselector

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.NumberPicker
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {


    private val clearButton: Button by lazy {
        findViewById(R.id.bt_clearNumber)
    }

    private val addButton: Button by lazy {
        findViewById(R.id.bt_addNumber)
    }

    private val runButton: Button by lazy {
        findViewById(R.id.bv_runButton)
    }

    private val numberPicker: NumberPicker by lazy {
        findViewById(R.id.np_numberPicker)
    }

    private val numberTextViewList: List<TextView> by lazy {
        listOf<TextView>(
            findViewById<TextView>(R.id.tv_number1),
            findViewById<TextView>(R.id.tv_number2),
            findViewById<TextView>(R.id.tv_number3),
            findViewById<TextView>(R.id.tv_number4),
            findViewById<TextView>(R.id.tv_number5),
            findViewById<TextView>(R.id.tv_number6)
        )
    }
    private var didRun = false

    private val pickNumberSet = hashSetOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        numberPicker.minValue = 1
        numberPicker.maxValue = 45

        initRunButton()
        initAddButton()
    }

    private fun initRunButton() {
        runButton.setOnClickListener {
            val list = getRandomNumber()

        }
    }

    private fun initAddButton() {
        addButton.setOnClickListener {

            if (didRun) {
                Toast.makeText(this, "초기화 후에 시도해주세요.",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (pickNumberSet.size >= 5) {
                Toast.makeText(this, "번호는 5개까지만 선택할 수 있습니다.",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (pickNumberSet.contains(numberPicker.value)) {
                Toast.makeText(this, "이미 선택한 번호입니다.",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val textView = numberTextViewList[pickNumberSet.size]
            textView.isVisible = true
            textView.text = numberPicker.value.toString()

            pickNumberSet.add(numberPicker.value)
        }
    }

    private fun getRandomNumber(): List<Int> {
        val numberList = mutableListOf<Int>()
            .apply {
                for (i in 1..45) {
                    this.add(i)
                }
            }
        numberList.shuffle()

        return numberList.subList(0, 6).sorted()

    }
}