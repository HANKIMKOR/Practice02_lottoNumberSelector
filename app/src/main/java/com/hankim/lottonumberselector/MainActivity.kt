package com.hankim.lottonumberselector

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val random = Random()
        val list = mutableListOf<Int>().apply {
            for (i in 1..45) {
                this.add(i)
            }
        }

        list.shuffle()

        list.subList(0, 6)

        println(list)
//
//        방법1. mutuableListOf 를 활용
//        val random = Random()
//        val list1 = mutableListOf<Int>()
//
//        while (list1.size < 6) {
//            val randomNumber = random.nextInt(45) + 1
//            if (list.contains(randomNumber)) {
//                continue
//            }
//            list1.add(randomNumber)
//        }
//
//        방법2. mutableSetOf 를 활용
//        val random = Random()
//        val list2 = mutableSetOf<Int>()
//
//        while (list2.size < 6) {
//            val randomNumber = random.nextInt(45) + 1
//            list2.add(randomNumber)
//        }
    }
}