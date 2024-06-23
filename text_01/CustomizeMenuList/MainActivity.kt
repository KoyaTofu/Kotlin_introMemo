package com.example.customizemenulist

import android.content.Intent
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.SimpleAdapter
import android.widget.Toast

class MainActivity : BaseActivity() {
    var menuList: MutableList<MutableMap<String, Any>> = mutableListOf()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // メニュー用ListView を取得
        val lvMenu: ListView = findViewById(R.id.lvMenu)

        // ListViewの初期化 (定食メニュー)
        initListView( lvMenu )

        // ListViewのコンテキストメニュー有効化 (長押しによって表示される)
        registerForContextMenu(lvMenu)
    }
    //region fun initListView | ListView 初期化
    fun initListView(listView: ListView) {
        // 定食リストを生成
        val _menuList: MutableList<MutableMap<String,Any>> = createTeishokuList()
        // lvMenuにAdapterを追加
        adaptListView( listView, _menuList)
        // リストタップのリスナクラス登録
        listView.onItemClickListener = ListItemClickListener()
    }
    //endregion

    //region fun createTeishokuList | 定食リストを生成
    private fun createTeishokuList(): MutableList<MutableMap<String,Any>> {
        // 既存リストの初期化
        menuList.clear()
        // 新規追加
        var menu: MutableMap< String,Any>
             = mutableMapOf("name" to "から揚げ定食", "price" to 800, "desc" to "若鶏のから揚げにサラダ、ご飯とお味噌汁が付きます。")
        menuList.add(menu)
        menu = mutableMapOf ("name" to "ハンバーグ定食", "price" to 850, "desc" to "手ごねハンバーグにサラダ、ご飯とお味噌汁が付きます。")
        menuList.add(menu)
        menu = mutableMapOf ("name" to "生姜焼き定食", "price" to 750, "desc" to "商品説明")
        menuList.add(menu)
        menu = mutableMapOf ("name" to "ステーキ定食", "price" to 1200, "desc" to "商品説明")
        menuList.add(menu)
        menu = mutableMapOf ("name" to "野菜炒め定食", "price" to 750, "desc" to "商品説明")
        menuList.add(menu)
        menu = mutableMapOf ("name" to "とんかつ定食", "price" to 850, "desc" to "商品説明")
        menuList.add(menu)
        menu = mutableMapOf ("name" to "ミンチかつ定食", "price" to 800, "desc" to "商品説明")
        menuList.add(menu)
        menu = mutableMapOf ("name" to "コロッケ定食", "price" to 750, "desc" to "商品説明")
        menuList.add(menu)
        menu = mutableMapOf ("name" to "回鍋肉定食", "price" to 800, "desc" to "商品説明")
        menuList.add(menu)
        menu = mutableMapOf ("name" to "麻婆豆腐定食", "price" to 850, "desc" to "商品説明")
        menuList.add(menu)
        menu = mutableMapOf ("name" to "青椒肉絲定食", "price" to 900, "desc" to "商品説明")
        menuList.add(menu)
        menu = mutableMapOf ("name" to "八宝菜定食", "price" to 900, "desc" to "商品説明")
        menuList.add(menu)
        menu = mutableMapOf ("name" to "酢豚定食", "price" to 900, "desc" to "商品説明")
        menuList.add(menu)
        menu = mutableMapOf ("name" to "豚の角煮定食", "price" to 850, "desc" to "商品説明")
        menuList.add(menu)
        menu = mutableMapOf ("name" to "焼き鳥定食", "price" to 800, "desc" to "商品説明")
        menuList.add(menu)
        menu = mutableMapOf ("name" to "焼き魚定食", "price" to 850, "desc" to "商品説明")
        menuList.add(menu)
        menu = mutableMapOf ("name" to "焼肉定食", "price" to 800, "desc" to "商品説明")
        menuList.add(menu)

        return menuList
    }
    //endregion
    //region fun createCurryList | カレーリストを生成
    private fun createCurryList(): MutableList<MutableMap<String,Any>> {
        // 既存リストの初期化
        menuList.clear()
        // 新規追加
        var menu: MutableMap< String,Any>
             = mutableMapOf("name" to "ビーフカレー", "price" to 520, "desc" to "特選スパイスをきかせた国産ビーフ100％のカレーです。")
        menuList.add(menu)
        menu = mutableMapOf("name" to "ポークカレー", "price" to 520, "desc" to "特選スパイスをきかせた国産ポーク100％のカレーです。")
        menuList.add(menu)
        menu = mutableMapOf("name" to "ドライカレー", "price" to 800, "desc" to "商品説明")
        menuList.add(menu)
        menu = mutableMapOf("name" to "カツカレー", "price" to 800, "desc" to "商品説明")
        menuList.add(menu)
        menu = mutableMapOf("name" to "チキンカレー", "price" to 800, "desc" to "商品説明")
        menuList.add(menu)
        menu = mutableMapOf("name" to "シーフードカレー", "price" to 800, "desc" to "商品説明")
        menuList.add(menu)
        menu = mutableMapOf("name" to "キーマカレー", "price" to 800, "desc" to "商品説明")
        menuList.add(menu)
        menu = mutableMapOf("name" to "グリーンカレー", "price" to 800, "desc" to "商品説明")
        menuList.add(menu)

        return menuList
    }
    //endregion

    //region fun adaptListView | ListViewにAdapterを追加
    private fun adaptListView( listView: ListView, _menuList: MutableList<MutableMap<String,Any>>) {
        // SimpleAdapter 第４引数 from用データの用意
        val _from: Array<String> = arrayOf( "name", "price")
        // SimpleAdapter 第５引数 to用データの用意
        val _to: IntArray = intArrayOf( R.id.tvMenuNameRow, R.id.tvMenuPriceRow)

        // SimpleAdapter 生成
        val adapter = SimpleAdapter(this@MainActivity, _menuList, R.layout.list_row, _from, _to)
        // Adapter 登録
        listView.adapter = adapter
    }
    //endregion
    //region class ListItemClickListener : OnItemClickListener | ListView タップ時 処理
    private inner class ListItemClickListener : AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {
            // タップされた行のデータを取得
            val menu = parent.getItemAtPosition(position) as MutableMap<String, Any>
            // 注文 処理
            order(menu)
        }
    }
    //endregion
    //region fun order | 注文 処理
    private fun order( menu: MutableMap<String,Any>) {
        // 定食名と金額を取得
        val menuName: String = menu["name"].toString()
        val menuPrice: Int = menu["price"].toString().toInt()
        val strMenuPrice: String = "%,d".format(menuPrice)
        // インテントオブジェクトを生成
        val intentMenuThanksAct = Intent(this@MainActivity, MenuThanksAct::class.java)
        // 第2画面に送るデータを格納
        intentMenuThanksAct.putExtra( "menuName", menuName)
        intentMenuThanksAct.putExtra( "menuPrice", "${strMenuPrice} 円")
        // 第2画面を起動
        startActivity(intentMenuThanksAct)
    }
    //endregion

    //region fun onCreateOptionsMenu | オプションメニュー生成
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate( R.menu.menu_options_menu_list, menu)
        return true
    }
    //endregion
    //region fun onOptionsItemSelected | オプションメニュー選択時 処理
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var returnVal: Boolean = true
        var _menuList: MutableList<MutableMap<String,Any>> = mutableListOf()

        when( item.itemId) {
            R.id.menuListOptionTeishoku ->
                _menuList = createTeishokuList()
            R.id.menuListOptionCurry ->
                _menuList = createCurryList()
            else ->
                returnVal = super.onOptionsItemSelected(item)
        }
        // 画面部品 ListViewを取得
        val lvMenu: ListView = findViewById(R.id.lvMenu)
        // lvMenuにAdapterを追加
        adaptListView( lvMenu, _menuList)
        // リストタップのリスナクラス登録
        lvMenu.onItemClickListener = ListItemClickListener()

        return returnVal
    }
    //endregion

    //region fun onCreateContextMenu | コンテキストメニュー生成
    override fun onCreateContextMenu(
        menu: ContextMenu,
        view: View,
        menuInfo: ContextMenu.ContextMenuInfo
    ) {
        super.onCreateContextMenu( menu, view, menuInfo)
        menuInflater.inflate( R.menu.menu_context_menu_list, menu)
        menu.setHeaderTitle(R.string.menu_list_context_header)
    }
    //endregion
    //region fun onContextItemSelected | コンテキストメニュー選択時 処理
    override fun onContextItemSelected(item: MenuItem): Boolean {
        var returnVal: Boolean = true
        // 該当メニューに関する情報が格納されたオブジェクトを取得
        val info = item.menuInfo as AdapterView.AdapterContextMenuInfo
        // 該当メニューのリストにおける位置(index)を取得
        val position: Int = info.position
        // 該当メニュー情報Mapオブジェクトを取得
        val menu: MutableMap<String,Any> = menuList[position]

        // 該当メニューのIDのR値による処理の分岐
        when( item.itemId) {
            R.id.menuListContextDesc -> {
                // メニューの商品説明文字列を取得
                val desc: String = menu["desc"].toString()
                // トーストを表示
                Toast.makeText(this@MainActivity, desc, Toast.LENGTH_LONG).show()
            }
            R.id.menuListContextOrder -> {
                // 注文処理
                order(menu)
            }
            else -> {
                returnVal = super.onContextItemSelected(item)
            }
        }
        return returnVal
    }
    //endregion
}