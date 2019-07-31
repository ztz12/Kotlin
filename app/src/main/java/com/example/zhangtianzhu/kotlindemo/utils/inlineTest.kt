package com.example.zhangtianzhu.kotlindemo.utils

//使用inline lambda表达式可以返回值,但是使用noinline lambda就无法返回值，禁止内联，使用crossinline也是一样，禁止返回值
//但是与noinline区别是，使用noinline就不是个内联函数，无法直接调用函数代码内容，而使用crossinline还是个内联函数，
// 继续调用的是函数代码具体内容
fun inlineTest() {
     mainOne{ return print("1") }
//    mainTwo { return print("1") }
//    mainThree { return print("1") }
}

inline fun mainOne(f: () -> Unit) {
    print("noinline")
    f()
}

inline fun mainTwo(noinline f: () -> Unit) {
    print("noinline")
    f()
}

inline fun mainThree(crossinline f: () -> Unit) {
    print("noinline")
    f()
}