package com.example.fragment

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class MenuThanksFragment : Fragment(R.layout.fragment_menu_thanks) {
    //region | 状態変化の確認-1
    override fun onInflate(context: Context, attrs: AttributeSet, savedInstanceState: Bundle?) {
        Log.i("MyApp", "MenuThanks onInflate() is called.")
        super.onInflate(context, attrs, savedInstanceState)
    }
    override fun onAttach(context: Context) {
        Log.i("MyApp", "MenuThanks onAttach() is called.")
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("MyApp", "MenuThanks onCreate() is called.")
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i("MyApp", "MenuThanks onCreateView() is called.")
        return super.onCreateView(inflater, container, savedInstanceState)
    }
    //endregion
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.i("MyApp", "MenuThanks onViewCreated() is called.")
        super.onViewCreated(view, savedInstanceState)

        // 定食名と金額を取得
        val menuName: String = arguments?.getString("menuName") ?: ""
        val menuPrice: String = arguments?.getString("menuPrice") ?: ""

        // 定食名と金額を表示させる TextViewを取得
        val tvMenuName: TextView = view.findViewById(R.id.tvMenuName)
        val tvMenuPrice: TextView = view.findViewById(R.id.tvMenuPrice)

        // TextViewに格納
        tvMenuName.text = menuName
        tvMenuPrice.text = menuPrice

        // [リストに戻る]Button を取得
        val btBack: Button = view.findViewById(R.id.btThxBack)
        // Button にリスナを設定
        btBack.setOnClickListener( ButtonClicklistener())

    }
    //region | 状態変化の確認-2
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.i("MyApp", "MenuThanks onActivityCreated() is called.")
        super.onActivityCreated(savedInstanceState)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        Log.i("MyApp", "MenuThanks onViewStateRestored() is called.")
        super.onViewStateRestored(savedInstanceState)
    }
    override fun onStart() {
        Log.i("MyApp", "MenuThanks onStart() is called.")
        super.onStart()
    }

    override fun onResume() {
        Log.i("MyApp", "MenuThanks onResume() is called.")
        super.onResume()
    }

    override fun onPause() {
        Log.i("MyApp", "MenuThanks onPause() is called.")
        super.onPause()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.i("MyApp", "MenuThanks onSaveInstanceState() is called.")
        super.onSaveInstanceState(outState)
    }

    override fun onStop() {
        Log.i("MyApp", "MenuThanks onStop() is called.")
        super.onStop()
    }

    override fun onDestroyView() {
        Log.i("MyApp", "MenuThanks onDestroyView() is called.")
        super.onDestroyView()
    }

    override fun onDestroy() {
        Log.i("MyApp", "MenuThanks onDestory() is called.")
        super.onDestroy()
    }

    override fun onDetach() {
        Log.i("MyApp", "MenuThanks onDetach() is called.")
        super.onDetach()
    }
    //endregion

    //region class ButtonClicklistener: OnClickListener | [リストに戻る]Button が押された時の処理
    private inner class ButtonClicklistener: View.OnClickListener {
        override fun onClick( view: View) {
            Log.i("MyApp", "---- popBackStack() ------")
            parentFragmentManager.popBackStack()
        }
    }
    //endregion
}