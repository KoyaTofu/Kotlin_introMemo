package com.example.twolinelist

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.SimpleAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lvMenu: ListView = findViewById(R.id.lvMenu)
        // ListViewに要素を追加
        adaptListView(lvMenu)

        //　リストタップのリスナクラス設定
        lvMenu.onItemClickListener = ListItemClickListener()
    }

    //region fun adaptListView | ListViewに要素を追加
    fun adaptListView( listView: ListView ) {
        // SimpleAdapter 第２引数 MutableListオブジェクトを生成
        val menuList: MutableList<MutableMap<String, String>> = createMenuList()
        // SimpleAdapter 第４引数 from用データの用意
        val from: Array<String> = arrayOf( "name", "price")
        // SimpleAdapter 第５引数 to用データの用意
        val to: IntArray = intArrayOf( android.R.id.text1, android.R.id.text2)

        // SimpleAdapter 生成
        val adapter = SimpleAdapter(this@MainActivity, menuList, android.R.layout.simple_list_item_2, from, to)
        // Adapter 登録
        listView.adapter = adapter
    }
    //endregion
    //region fun createMenuList | MenuList作成
    fun createMenuList(): MutableList<MutableMap<String,String>> {
        val menuList: MutableList<MutableMap<String, String>> = mutableListOf()

        var menu: MutableMap< String,String> = mutableMapOf()
        menu = mutableMapOf("name" to "から揚げ定食", "price" to "800円")
        menuList.add(menu)
        menu = mutableMapOf ("name" to "ハンバーグ定食", "price" to "850円")
        menuList.add(menu)
        menu = mutableMapOf ("name" to "生姜焼き定食", "price" to "750円")
        menuList.add(menu)
        menu = mutableMapOf ("name" to "ステーキ定食", "price" to "1200円")
        menuList.add(menu)
        menu = mutableMapOf ("name" to "野菜炒め定食", "price" to "750円")
        menuList.add(menu)
        menu = mutableMapOf ("name" to "とんかつ定食", "price" to "850円")
        menuList.add(menu)
        menu = mutableMapOf ("name" to "ミンチかつ定食", "price" to "800円")
        menuList.add(menu)
        menu = mutableMapOf ("name" to "コロッケ定食", "price" to "750円")
        menuList.add(menu)
        menu = mutableMapOf ("name" to "回鍋肉定食", "price" to "800円")
        menuList.add(menu)
        menu = mutableMapOf ("name" to "麻婆豆腐定食", "price" to "850円")
        menuList.add(menu)
        menu = mutableMapOf ("name" to "青椒肉絲定食", "price" to "900円")
        menuList.add(menu)
        menu = mutableMapOf ("name" to "八宝菜定食", "price" to "900円")
        menuList.add(menu)
        menu = mutableMapOf ("name" to "酢豚定食", "price" to "900円")
        menuList.add(menu)
        menu = mutableMapOf ("name" to "豚の角煮定食", "price" to "850円")
        menuList.add(menu)
        menu = mutableMapOf ("name" to "焼き鳥定食", "price" to "800円")
        menuList.add(menu)
        menu = mutableMapOf ("name" to "焼き魚定食", "price" to "850円")
        menuList.add(menu)
        menu = mutableMapOf ("name" to "焼肉定食", "price" to "800円")
        menuList.add(menu)

        return menuList
    }
    //endregion

    //region | リストタップ時の処理
    private inner class ListItemClickListener : AdapterView.OnItemClickListener {
        override fun onItemClick( parent: AdapterView<*>, view: View, position: Int, id: Long) {
            // タップされた行のデータを取得
            val item: MutableMap<String,String> = parent.getItemAtPosition(position) as MutableMap<String, String>
            // 定食名と金額を取得
            val menuName: String = item["name"].toString()
            val menuPrice: String = item["price"].toString()
            // インテントオブジェクトを生成
            val intentMenuThanksAct = Intent(this@MainActivity, MenuThanksAct::class.java)
            // 渡すデータを格納
            intentMenuThanksAct.putExtra( "menuName", menuName)
            intentMenuThanksAct.putExtra( "menuPrice", menuPrice)
            //　画面を起動
            startActivity(intentMenuThanksAct)
        }
    }
    //endregion
}