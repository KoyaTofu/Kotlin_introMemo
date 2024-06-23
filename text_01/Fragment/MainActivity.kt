package com.example.fragment

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import android.util.Log
import android.view.Menu

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("MyApp", "MainActivity onCreate() is called.")
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.fragmentMainContainer)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    //region | 状態変化の確認
    override fun onAttachFragment(fragment: Fragment) {
        Log.i("MyApp", "MainActivity onAttachFragment() is called.")
        super.onAttachFragment(fragment)
    }

    override fun onContentChanged() {
        Log.i("MyApp", "MainActivity onContentChanged() is called.")
        super.onContentChanged()
    }

    override fun onRestart() {
        Log.i("MyApp", "MainActivity onRestart() is called.")
        super.onRestart()
    }

    override fun onStart() {
        Log.i("MyApp", "MainActivity onStart() is called.")
        super.onStart()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        Log.i("MyApp", "MainActivity onActivityResult() is called.")
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        Log.i("MyApp", "MainActivity onRestoreInstanceState() is called.")
        super.onRestoreInstanceState(savedInstanceState)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        Log.i("MyApp", "MainActivity onPostCreate() is called.")
        super.onPostCreate(savedInstanceState)
    }

    override fun onResume() {
        Log.i("MyApp", "MainActivity onResume() is called.")
        super.onResume()
    }

    override fun onPostResume() {
        Log.i("MyApp", "MainActivity onPostResume() is called.")
        super.onPostResume()
    }

    override fun onAttachedToWindow() {
        Log.i("MyApp", "MainActivity onAttachToWindow() is called.")
        super.onAttachedToWindow()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        Log.i("MyApp", "MainActivity onCreateoptionsMenu() is called.")
        return super.onCreateOptionsMenu(menu)
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        Log.i("MyApp", "MainActivity onPrepareoptionsMenu() is called.")
        return super.onPrepareOptionsMenu(menu)
    }

    override fun onUserInteraction() {
        Log.i("MyApp", "MainActivity onUserInteraction() is called.")
        super.onUserInteraction()
    }

    override fun onUserLeaveHint() {
        Log.i("MyApp", "MainActivity onUserLeaveHint() is called.")
        super.onUserLeaveHint()
    }

    override fun onPause() {
        Log.i("MyApp", "MainActivity onPause() is called.")
        super.onPause()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.i("MyApp", "MainActivity onSaveInstanceState() is called.")
        super.onSaveInstanceState(outState)
    }

    override fun onStop() {
        Log.i("MyApp", "MainActivity onStop() is called.")
        super.onStop()
    }

    override fun onDestroy() {
        Log.i("MyApp", "MainActivity onDestroy() is called.")
        super.onDestroy()
    }
    //endregion
}