package com.example.eventandlistener

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btClick: Button = findViewById(R.id.btClick)
        // リスナクラスのインスタンスを生成
        val listener = HelloListener()
        // ボタンにリスナを設定
        btClick.setOnClickListener(listener)

        val btClear: Button = findViewById(R.id.btClear)
        btClear.setOnClickListener(listener)
    }

    //region class HelloListener(OnClickListener): ボタン押下処理
    private inner class HelloListener : View.OnClickListener {
        override fun onClick( view: View) {
            // 名前入力欄であるEditTextオブジェクトを取得
            val input: EditText = findViewById(R.id.etName)
            // メッセージを表示するTextViewオブジェクトを取得
            val output: TextView = findViewById(R.id.tvOutput)

            when(view.id) {
                R.id.btClick -> {  //表示ボタンの場合
                    // 入力された文字列を取得
                    val inputStr: String = input.text.toString()
                    if( inputStr != "" ) {
                        // メッセージを生成
                        val msg: String = getString(R.string.msg_greeting) + space(1) + inputStr
                        // メッセージを表示
                        output.text = msg
                    } else {
                        output.text =  getString(R.string.request_name)
                    }
                }
                R.id.btClear -> {  //クリアボタンの場合
                    // 名前入力欄を空文字に設定
                    input.setText("")
                    // メッセージ表示欄を空文字に設定
                    output.text = ""
                }
            }
        }
    }
    //endregion
}