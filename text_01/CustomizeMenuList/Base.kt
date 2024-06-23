package com.example.customizemenulist

import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {
    //region fun space: 空白
    fun space( num: Int): String {
        var space: String = ""
        for( count in 0 until num) {
            space += " "
        }
        return space
    }
    //endregion

}