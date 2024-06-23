package com.example.dynamiclistgeneration

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment

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

open class BaseFragment : DialogFragment() {
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
