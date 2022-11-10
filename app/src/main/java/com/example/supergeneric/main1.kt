package com.example.supergeneric

fun main(){
    val result1= getGenericType<Int>()
    val result2= getGenericType<String>()
    //内联函数将代码块直接换到这个地方
    println("result1 is $result1")
    println("result2 is $result2")

}
//将泛型进行实化，该函数必须是内联函数
//在声明泛型的地方必须加上reified关键字来表示该泛型要进行实化
inline fun <reified T>getGenericType()=T::class.java
//这个函数直接返回了当前指定泛型的实际类型
//T.class这种语法在Java中是不合法的，但在Kotlin中，借助泛型实化功能就可以使用T::class.java