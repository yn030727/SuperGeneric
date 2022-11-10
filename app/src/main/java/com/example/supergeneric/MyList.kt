package com.example.supergeneric
//自己实现的List简化版源码
public interface MyList<out E>:Collection<E>{
    //这里对泛型E的前面加上了out关键字，说明List在泛型E上是协变的。
    //所有原则上泛型E只会出现在out位置上
    override val size:Int
    override fun isEmpty(): Boolean
    override fun contains(element: @UnsafeVariance E): Boolean
    //这里泛型E出现在了in位置上(会有安全隐患)
    //因为contains()方法的目的非常明确，他只是为了判断当前集合中是否包含传入的这个元素
    //不会修改当前集合的任何内容
    //所以对于这种实质上是安全的操作.我们用UnsafeVariance注解，就允许出现在in位置
    override fun iterator(): Iterator<E>
    public operator fun get(index:Int):E
}