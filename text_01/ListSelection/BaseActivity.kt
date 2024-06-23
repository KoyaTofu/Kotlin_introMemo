package com.example.listselection

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
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
