package com.example.dynamiclistgeneration

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class OrderConfirmDialogFragment : BaseFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // activity が nullでないなら、ダイアログオブジェクトを生成
        val dialog: AlertDialog? = activity?.let {
            val item: String = arguments?.getString("item").toString()
            val msg: String = item + space(1) + getString(R.string.dialog_msg)
            // ダイアログの生成
            AlertDialog.Builder(it)  //it = activity (.let内ではitに置き換わる)
                .setTitle( R.string.dialog_title)
                .setMessage( msg)
                .setPositiveButton( R.string.dialog_btn_ok, DialogButtonClickListener())
                .setNegativeButton( R.string.dialog_btn_ng, DialogButtonClickListener())
                .setNeutralButton( R.string.dialog_btn_nu, DialogButtonClickListener())
                .create()
        }
        // 生成したダイアログオブジェクトを返す
        return dialog ?: throw IllegalStateException("アクティビティが nullです")
    }
    //region DialogButtonClickListener: OnClickListener | ダイアログ_ボタンクリック時のリスナ
    private inner class DialogButtonClickListener : DialogInterface.OnClickListener {
        override fun onClick( dialog: DialogInterface?, which: Int) {
            var msg: String = ""
            when( which) {
                // 注文用
                DialogInterface.BUTTON_POSITIVE ->
                    msg = getString(R.string.dialog_ok_toast)
                // キャンセル用
                DialogInterface.BUTTON_NEGATIVE ->
                    msg = getString(R.string.dialog_ng_toast)
                //問合せ用
                DialogInterface.BUTTON_NEUTRAL ->
                    msg = getString(R.string.dialog_nu_toast)
            }
            // トーストの表示
            Toast.makeText( activity, msg, Toast.LENGTH_LONG).show()
        }
    }
    //endregion
}