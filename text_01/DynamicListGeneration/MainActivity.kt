package com.example.dynamiclistgeneration

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lvMenu: ListView = findViewById(R.id.lvMenu)
        // リストビューに表示するリストデータを作成
        var menuList: MutableList<String> = mutableListOf(
                "から揚げ定食", "ハンバーグ定食", "生姜焼き定食", "ステーキ定食", "野菜炒め定食", "とんかつ定食",
                "ミンチかつ定食", "コロッケ定食", "回鍋肉定食",  "麻婆豆腐定食", "青椒肉絲定食", "八宝菜定食",
                "酢豚定食", "豚の角煮定食", "焼き鳥定食", "焼き魚定食",  "焼肉定食"
        )
        // アダプタオブジェクトを生成
        val adapter: ArrayAdapter<String> = ArrayAdapter(this@MainActivity, android.R.layout.simple_list_item_1, menuList)
        //リストビューにアダプタオブジェクトを設定
        lvMenu.adapter = adapter

        //リストビューにリスナを設定
        lvMenu.onItemClickListener = ListItemClickListener()
    }
    //region　class ListItemClickListener: OnItemClickListener | リストビュークリック時のリスナ
    private inner class ListItemClickListener : AdapterView.OnItemClickListener {
        override fun onItemClick( parent: AdapterView<*>, view: View, position: Int, id: Long) {
            // 注文確認ダイアログフラグメントオブジェクトを生成
            val dialogFragment = OrderConfirmDialogFragment()
            // 選択した商品名を渡す
            val bundle = Bundle().apply {
                putString("item", parent.getItemAtPosition(position).toString())
            }
            dialogFragment.arguments = bundle
            //ダイアログ表示
            dialogFragment.show( supportFragmentManager, "OrderConfirmDialogFragment")
        }
    }
    //endregion
}