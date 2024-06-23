package com.example.listselection

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lvMenu: ListView = findViewById(R.id.lvMenu)
        // ListViewにリスナを設定
        lvMenu.onItemClickListener = ListItemClickListener()

    }
    //region リストがタップされた時の処理
    /**
     * @args parent:  タップされたリスト全体を表す
     * @args position: タップされた要素のindex番号
     */
    private inner class ListItemClickListener : AdapterView.OnItemClickListener {
        override fun onItemClick( parent: AdapterView<*>, view: View, position: Int, id: Long) {
            /** イベントハンドラを記載 */
            // タップされた定食名を取得
            val item: String = parent.getItemAtPosition(position).toString()
            // トーストで表示する文字列を生成
            val msg: String = getString(R.string.msg_choice) + " : " + item
            // トーストの表示
            Toast.makeText(this@MainActivity, msg, Toast.LENGTH_LONG).show()
        }
    }
    //endregion
}