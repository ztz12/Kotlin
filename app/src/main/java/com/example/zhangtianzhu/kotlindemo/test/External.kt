package com.example.zhangtianzhu.kotlindemo.test

import kotlin.properties.Delegates


//扩展函数
fun <T> MutableList<T>.swap(indexOne:Int,indexTwo:Int){
    val temp = this[indexOne]//this 对应列表
    this[indexOne] = this[indexTwo]
    this[indexTwo] = temp
}

//密封类表示一种受限的类继承结构，在有限的集中类型，不能有任何其它的类型，与枚举相似，但是枚举只有一个实例，而密封类可以有多个实例
sealed class Exer
data class Const(val number:Double):Exer()
data class Sum(val expOne:Double,val expTwo:Double):Exer()
object NoNumber:Exer()

//嵌套类，无法访问父类成员
class Outer{
    private val value = 2
    class Nested{
        private val foo = 1
    }
}

//内部类，可以访问父类成员
class OuterInner{
    private val value = 2
    inner class NestedInner{
        private val foo = value
    }
}

//枚举类最基本的用法是实现类型安全的枚举类
enum class Color(val rgba:Int){
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}

/**
 * 接受两个参数：初始值与修改时处理程序（handler）。
 * 每当我们给属性赋值时会调用该处理程序（在赋值后执行）。它有三个参数：被赋值的属性、旧值与新值：
 */
//可观察属性observable 它有三个属性 被赋值属性，旧值与新值
class User{
    var name by Delegates.observable("no-name"){
        //参数未使用，可以使用下划线替代
        _,old,new ->
        print("name")
    }

    fun main(){
        val user=User()
        user.name ="1+1=11"
    }
}


//匿名类
enum class ColorState{
    RED{
        override fun signal(): ColorState = WHITE
    },

    WHITE{
        override fun signal(): ColorState = RED
    };

    abstract fun signal():ColorState
}

//匿名对象可以作为本地或私有作用域的类型
class C{
    //私有函数返回的对象是匿名对象
    private fun Foo()=object {
        val x = "x"
    }

    //公有函数返回的对象是Any
    fun publicFoo() = object {
        val x = "X"
    }

    fun get(){
        val x= Foo().x
//        val x2= publicFoo().x  //wrong
    }
}

//高阶函数是将函数方法作为参数，高阶函数会带来运行效率损失问题，即每一个函数都是一个对象，都会捕获一个闭包，那些在函数体内访问的变量，
// 内存分配或者虚拟调用带来性能开销，但在许多情况可以通过内联lambda来消除此类带来的开销,可以使用noinline来禁用内联
//在 Kotlin 中，我们可以只使用一个正常的、非限定的 return 来退出一个命名或匿名函数。
// 这意味着要退出一个 lambda 表达式，我们必须使用一个标签，并且在 lambda 表达式内部禁止使用裸 return，
//非局部返回
//fun foo(){
//    inline{
//        return
//    }
//}
//因为 lambda 表达式不能使包含它的函数返回
//内联函数可以具体化参数
//inline fun <reified T> TreeNode.findParentOfType(): T? {
//    var p = parent
//    while (p != null && p !is T) {
//        p = p.parent
//    }
//    return p as T?
//}
//就可以这样调用myTree.findParentOfType<MyTreeNodeType>()

//for(var i in 1..10){等同于i>=1并且i<=10
//    print(i)
//}

//for(var i in 1 until 10)等同于 i>=1&&i<10
//for(var i in 10 downTo 1)//倒序迭代数字
//for(var i in 1..10 step 2)步长为2输出数字

class A { // 隐式标签 @A
    inner class B { // 隐式标签 @B
        fun Int.foo() { // 隐式标签 @foo
            val a = this@A // A 的 this
            val b = this@B // B 的 this

            val c = this // foo() 的接收者，一个 Int
            val c1 = this@foo // foo() 的接收者，一个 Int

            val funLit = lambda@ fun String.() {
                val d = this // funLit 的接收者
            }


            val funLit2 = { s: String ->
                // foo() 的接收者，因为它包含的 lambda 表达式
                // 没有任何接收者
                val d1 = this
            }
        }
    }
}

//二元操作符
//a + b	a.plus(b)
//a - b	a.minus(b)
//a * b	a.times(b)
//a / b	a.div(b)
//a % b	a.rem(b)、 a.mod(b) （已弃用）
//a..b	a.rangeTo(b)

//比较操作符
//表达式	翻译为
//a > b	a.compareTo(b) > 0
//a < b	a.compareTo(b) < 0
//a >= b	a.compareTo(b) >= 0
//a <= b	a.compareTo(b) <= 0

//空类型安全
//1.在条件中检查是否为null
val b = arrayOf(1212,2,3)
//val n = if(b!=null) b.length else null

//2. 安全调用
val a:String = "as"
val bb:String? = null
//如果bb不为空返回值bb.length，否则返回null

//3.Elvis操作符

val l = b?.size ?: -1
//?: 左侧非空返回，右侧为空返回-1

//4.非空断言
//b!!.size

//5.安全类型转换
//val aInt :Int? = a as? Int

//6.可空类型集合
val nullList:List<Int?> = listOf(1,2,3,null)
//filterNotNull 过滤非空元素
val filterList:List<Int> = nullList.filterNotNull()

//反射
//可调用引用
fun isOdd(x: Int) = x % 2 != 0
fun isOdd(s: String) = s == "brillig" || s == "slithy" || s == "tove"

val list:List<Int> = listOf(1,2,4)
fun test(){
    print(list.filter(::isOdd))
}

//属性引用
var y=1
fun main(){
    ::y.set(2)
    print(y)
}

val x = 2
fun xM(){
    println(::x.get())
    println(::x.name)
}