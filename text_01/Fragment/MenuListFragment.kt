package com.example.fragment

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import android.widget.SimpleAdapter
import androidx.fragment.app.FragmentTransaction


class MenuListFragment : Fragment(R.layout.fragment_menu_list) {
    //region | 状態変化の確認-1
    override fun onInflate(context: Context, attrs: AttributeSet, savedInstanceState: Bundle?) {
        Log.i("MyApp", "MenuList onInflate() is called.")
        super.onInflate(context, attrs, savedInstanceState)
    }
    override fun onAttach(context: Context) {
        Log.i("MyApp", "MenuList onAttach() is called.")
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("MyApp", "MenuList onCreate() is called.")
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i("MyApp", "MenuList onCreateView() is called.")
        return super.onCreateView(inflater, container, savedInstanceState)
    }
    //endregion
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.i("MyApp", "MenuList onViewCreated() is called.")
        super.onViewCreated(view, savedInstanceState)

        // メニューリスト用ListView を取得
        val lvMenu: ListView = view.findViewById(R.id.lvMenu)

        // SimpleAdapterで使用する MutableListオブジェクトを用意
        val menuList: MutableList<MutableMap<String,String>> = createMenuList()

        // ListViewに Adapterを追加
        adaptListView( lvMenu, menuList)

        // ListViewタップ時のリスナ設定
        lvMenu.onItemClickListener = ListItemClickListener()

    }
    //region | 状態変化の確認-2
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.i("MyApp", "MenuList onActivityCreated() is called.")
        super.onActivityCreated(savedInstanceState)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        Log.i("MyApp", "MenuList onViewStateRestored() is called.")
        super.onViewStateRestored(savedInstanceState)
    }
    override fun onStart() {
        Log.i("MyApp", "MenuList onStart() is called.")
        super.onStart()
    }

    override fun onResume() {
        Log.i("MyApp", "MenuList onResume() is called.")
        super.onResume()
    }

    override fun onPause() {
        Log.i("MyApp", "MenuList onPause() is called.")
        super.onPause()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.i("MyApp", "MenuList onSaveInstanceState() is called.")
        super.onSaveInstanceState(outState)
    }

    override fun onStop() {
        Log.i("MyApp", "MenuList onStop() is called.")
        super.onStop()
    }

    override fun onDestroyView() {
        Log.i("MyApp", "MenuList onDestroyView() is called.")
        super.onDestroyView()
    }

    override fun onDestroy() {
        Log.i("MyApp", "MenuList onDestory() is called.")
        super.onDestroy()
    }

    override fun onDetach() {
        Log.i("MyApp", "MenuList onDetach() is called.")
        super.onDetach()
    }
    //endregion

    //region fun createMenuList | メニューリスト生成
    private fun createMenuList(): MutableList<MutableMap<String,String>>  {
        val menuList: MutableList<MutableMap<String,String>> = mutableListOf()

        var menu: MutableMap< String,String>
                = mutableMapOf("name" to "から揚げ定食", "price" to "800円")
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
    //region fun adaptListView | ListViewにAdapterを追加
    private fun adaptListView( listView: ListView, menuList: MutableList<MutableMap<String,String>>) {
        // SimpleAdapter 第４引数 from用データの用意
        val from: Array<String> = arrayOf( "name", "price")
        // SimpleAdapter 第５引数 to用データの用意
        val to: IntArray = intArrayOf( android.R.id.text1, android.R.id.text2)
        // SimpleAdapter 生成
        val adapter = SimpleAdapter(activity, menuList, android.R.layout.simple_list_item_2, from, to)
        // Adapter 登録
        listView.adapter = adapter
    }
    //endregion

    //region class ListItemClickListener : OnItemClickListener | ListView タップ時 処理
    private inner class ListItemClickListener : AdapterView.OnItemClickListener {
        override fun onItemClick( parent: AdapterView<*>, view: View, position: Int, id: Long) {
            // タップされた行のデータを取得
            val item = parent.getItemAtPosition(position) as MutableMap<String, String>
            // 定食名と金額を取得
            val menuName: String = item["name"].toString()
            val menuPrice: String = item["price"].toString()

            // データ引き継ぎ用 Bundleインスタンスを生成
            val bundle = Bundle()
            // 引き継ぎデータの格納
            bundle.putString( "menuName", menuName)
            bundle.putString( "menuPrice", menuPrice)

            // フラグメントトランザクションの開始
            val transaction: FragmentTransaction = parentFragmentManager.beginTransaction()
            transaction.setReorderingAllowed(true)
            // 現在の表示内容をバックスタックに追加 (スマホ固有のバック処理で戻れる)
            transaction.addToBackStack("Only list")
            // 現在フラグメントを注文完了フラグメントに置き換え
            transaction.replace( R.id.fragmentMainContainer, MenuThanksFragment::class.java, bundle)
            // トランザクションの反映
            transaction.commit()

            Log.i("MyApp", "----- transaction commit ------")
        }
    }
    //endregion
}