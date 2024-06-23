package com.example.customizemenulist

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.TextView

class MenuThanksAct : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_thanks)

        // 注文を受けたメニューを表示
        displayOrderMenu()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
    //region fun displayOrderMenu | 注文を受けたメニューを表示
    private fun displayOrderMenu() {
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
    //endregion

    //region | 戻るメニュー選択時 処理
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var returnVal: Boolean = true
        // 選択メニューが[戻る]の場合、アクティビティを終了
        if( item.itemId == android.R.id.home) {
            finish()
        } else {
            returnVal = super.onOptionsItemSelected(item)
        }
        return returnVal
    }
    //endregion
}