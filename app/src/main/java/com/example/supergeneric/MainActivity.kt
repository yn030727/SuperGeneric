package com.example.supergeneric

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //应该是this跳转到一个新的Activity(这里没有创建新的Activity)
        startActivity<MainActivity>(context=this)
        startActivity<MainActivity>(this){
            //高阶函数写成Lambda表达式形式
            putExtra("param1","data")
            putExtra("param2",123)
        }
    }

}