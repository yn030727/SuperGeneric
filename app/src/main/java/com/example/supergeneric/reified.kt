package com.example.supergeneric

import android.content.Context
import android.content.Intent
//经过封装后，我们无法通过正常的方法对Intent进行参数的传递，因为Intent写到了这个内联函数中
inline fun <reified T> startActivity(context:Context){
    val intent= Intent(context,T::class.java)
    context.startActivity(intent)
}

//我们可以用高阶函数解决这个问题，将Intent的传参当成函数类型的参数往函数里传
//对函数进行了重载
inline fun<reified T>startActivity(context: Context,block:Intent.()->Unit){
    val intent=Intent(context,T::class.java)
    intent.block()
    context.startActivity(intent)
}