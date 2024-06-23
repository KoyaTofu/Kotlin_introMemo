package com.example.twolinelist

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenuThanksAct : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_thanks)

        // リスト画面から受け取ったデータを取得
        val menuName: String = intent.getStringExtra("menuName").toString()
        val menuPrice: String = intent.getStringExtra("menuPrice").toString()
        // 定食名と金額を表示させる TextViewを取得
        val tvMenuName: TextView = findViewById(R.id.tvMenuName)
        val tvMenuPrice: TextView = findViewById(R.id.tvMenuPrice)
        // TextViewに格納
        tvMenuName.text = menuName
        tvMenuPrice.text = menuPrice
    }

    fun onBackButtonClick( view: View) {
        finish()
    }
}