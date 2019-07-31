package com.example.zhangtianzhu.kotlindemo.utils

import android.util.Log
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*
import java.io.IOException
import java.lang.ArithmeticException
import java.lang.IndexOutOfBoundsException
import kotlin.system.measureTimeMillis

private val tag = "CoroutineTest"

private fun testLaunch() = runBlocking {
    //GlobalScope.launch 返回一个Job对象，Job协程要执行的任务，将Job对象看成协程本身，协程的状态与生命周期都是Job反应出来的
    val job = GlobalScope.launch {
        //使用launch启动一个协程
        //delay 是挂起函数，不会造成线程阻塞，只能在协程中使用
        delay(1000L)//无阻塞1秒然后输出
        Log.i(tag, "world")//延迟后将打印输出
    }
    Log.i(tag, "hello")//主线程协程将继续等待,主线程代码立即执行
//        Thread.sleep(2000L)//阻塞主线程2秒，保证JVM存活
//        runBlocking {//阻塞主线程2秒，保证JVM存活
//            delay(2000L)
//        }
//        delay(2000L)
    job.join() //等待子线程直到结束 结果虽然相同，但主协程与后台任务持续时间没有任何关系
}

//作用域构建器
//可以使用 coroutineScope 构建器来声明你自己的作用域的。它启动了一个新的协程作用域并且在所有子协程执行结束后并没有执行完毕。
// runBlocking 和 coroutineScope 主要的不同之处在于后者在等待所有的子协程执行完毕时并没有使当前线程阻塞
private fun testCoro() = runBlocking {
    launch {
        delay(200L)
        Log.i(tag, "Task from runBlocking")
    }

    coroutineScope {
        //创建一个新的协程作用域
        launch {
            delay(500L)
            Log.i(tag, "Task from nested")
        }
        delay(100L)
        Log.i(tag, "Task from CoroutineScope")
    }
    Log.i(tag, "The CoroutineScope is over")
}

//挂起函数
private fun main() = runBlocking {
    //        launch {
//            doNext()
//        }
//        Log.i(tag,"Hello,")
    val job = GlobalScope.launch {
        repeat(1000) { i ->
            Log.i(tag, "This is slepping $i")
            delay(500L)
        }
    }
    delay(1300L)//在延迟之后结束程序
    job.cancel()
}

//第一个挂起函数
private suspend fun doNext() {
    delay(1000L)
    Log.i(tag, "World!")
}

private fun show() = runBlocking {
    val job = GlobalScope.launch {
        try {
            repeat(1000) { i ->
                print("i am sleep $i")
                delay(500)//挂起延迟500ms
            }
        } catch (e: CancellationException) {
            e.printStackTrace()
        } finally {
//                //在协程取消时执行终结任务,如果代码块可以被取消，那么在finally中运行挂起函数就会抛异常
//                print("i am running finally")
            //可以将相应的代码块包装在withContext(NonCancellable)中，就不会抛异常
            withContext(NonCancellable) {
                print("i am running finally")
                delay(1000)
                print("i can delay 1 sec beacuse i am non-cancellable")
            }
        }
    }
    delay(1300)
    print("main i ma tired of wating")
    job.cancel()//取消该任务 一旦main函数调用了cancel，我们就看不到输出
    job.join()//等待子协程结束
    print("now i can quit")
}

//用户关闭了协程界面，那么协程结束就没有必要了，它可以被取消
//协程取消是协作的，一段代码必须协作才能取消，挂起函数可以被取消，他们在取消时会抛CancellationException异常,该异常被认为取消协程正常原因
// 正在执行计算的任务，如果没有检查取消，他们是不能取消的
private fun showOne() = runBlocking {
    val startTime = System.currentTimeMillis()
    val job = launch(Dispatchers.Default) {
        var nextPrint = startTime
        val i = 0
        //调用取消后，仍然会执行代码，直到循环结束
//            while(i<5){
//                //每秒消息打印两次
//                if(System.currentTimeMillis()>=nextPrint) {
//                    print("i am sleeping ($i++)")
//                    nextPrint += 500
//                }
//            }
        //使计算任务取消,调用取消直接结束，不会继续循环
        while (isActive) {
            if (System.currentTimeMillis() >= nextPrint) {
                print("i am sleeping ($i++)")
                nextPrint += 500
            }
        }
    }
    delay(1300)//等待一段时间
    print("i am waiting")
    job.cancelAndJoin()//取消任务并等待结束
    print("i can quit")
}


//绝大多数情况下取消一个协程都会超时，可以追踪一个job引用，并手动的启动一个单独的协程在延迟后取消追踪,
// 但这里会抛出一个TimeoutCancellationException异常
private fun showTwo() = runBlocking {
    val job = withTimeout(1300) {
        repeat(1000) { i ->
            print("i am sleep $i")
            delay(500)
        }
    }
    //可以通过withTimeutOrNull来返回null解决抛出异常问题
    val jobb = withTimeoutOrNull(1300) {
        repeat(1000) { i ->
            print("i am sleep $i")
            delay(500)
        }
        "Done"//在运行得到结果之前取消它
    }
    print("result is $jobb")
}

//channel与BlcokQueue非常类似，它使用挂起的send方法代替了阻塞的put方法，使用receive方法代替了阻塞的take方法
fun showThree() = runBlocking {
    val channel = Channel<Int>(4)//带缓冲通道，允许发送者被挂起前发射多个元素，但也会像BlockQueue会阻塞元素
    //这里会消耗大量CPU,所以这这里只做5次平方运算
    launch {
        for (i in 1..5) channel.send(i * i)
        //channel.close 向channel通道发送一个关闭的特殊操作，receive会收到指令前所有操作
        channel.close()
    }
    repeat(5) { print(channel.receive()) }
    //for循环迭代 channel通道
    for (i in channel) print(i)
    print("end")

    //构建通道的生产者
    val square = produceSquare()
    //使用consumeEach 在消费者端来替代for循环
    square.consumeEach { print(it) }
    print("done")
}

private fun CoroutineScope.produceSquare(): ReceiveChannel<Int> = produce {
    for (i in 1..5) send(i * i)
}

//管道是一个协程在流中生产无数个元素的模式
private fun CoroutineScope.produceNumbers(start: Int) = produce {
    var x = start
    while (true) {
        send(x++)
        delay(10)
    }
}

private fun CoroutineScope.square(numbers: ReceiveChannel<Int>): ReceiveChannel<Int> = produce {
    for (i in 1..5) send(i * i)
}

fun showFour() = runBlocking {
    val numbers = produceNumbers(2)//生产无穷数字
    val square = square(numbers)//将1到5数字转换成平方数
    for (i in 1..5) print(square.receive())//打印前5个数字
    //生产素数
    var cur = produceNumbers(2)
    for (i in 1..10) {
        val prime = cur.receive()
        print(prime)
        cur = filter(cur, prime)
    }
    print("Done")
    coroutineContext.cancelChildren()//取消子协程
}

private fun CoroutineScope.filter(numbers: ReceiveChannel<Int>, prime: Int): ReceiveChannel<Int> = produce {
    for (x in numbers) if (x % prime != 0) send(x)
}


//扇出，多个子协程可以接收相同的管道，使它们进行分布式工作
private fun CoroutineScope.launchProcessor(id: Int, channel: ReceiveChannel<Int>) = launch {
    for (msg in channel) {
        print("Processor $id receive $msg")
    }
}

private fun test() = runBlocking {
    val producer = produceNumbers(2)
    repeat(5) { launchProcessor(it, producer) }//重复创建5个协程
    delay(950)
    producer.cancel()
}

//扇入，多个子协程发送同一个管道
private suspend fun sendString(channel: SendChannel<String>, s: String, time: Long) {
    while (true) {
        delay(time)
        channel.send(s)
    }
}

fun showFive() = runBlocking {
    val channel = Channel<String>()
    launch { sendString(channel, "a", 200L) }
    launch { sendString(channel, "b", 500L) }
    repeat(6) {
        //接收前6个
        print(channel.receive())
    }
    print("Done")
    coroutineContext.cancelChildren()
}

//Kotlin 1.3新特性，契约，让一个函数能够以编译器的理解方式显示的描述其行为
//1.声明函数调用的结果与所传入的参数值之间的关系来智能转换类型
fun so(s: String?) {
    require(s is String)
}

//2.高阶函数情况下改变变量进行初始化
fun foo(lock: Any) {
    val x: Int
    synchronized(lock) {
        //编译器知道lambda表达式只调用一次，因此不会重复赋值
        x = 42
    }
    print(x)//编译器一定知道会调用lambda表达式执行初始化操作，因此这里已经初始化
}

//组合挂起函数
suspend fun doSome1(): Int {
    delay(200)
    return 12
}

suspend fun doSome2(): Int {
    delay(100)
    return 24
}

fun done() = runBlocking {
    val time = measureTimeMillis {
        //使用async进行协程并发，减少执行时间 协程并发总是显示的
//            val one = async { doSome1() }
//            val two = async { doSome2() }
        //惰性async，结果await或者一个被start函数调用协程才会启动
        val one = async(start = CoroutineStart.LAZY) { doSome1() }
        val two = async(start = CoroutineStart.LAZY) { doSome2() }
        one.start()//启动第一个
        two.start()
        print("result is ${one.await() + two.await()}")
    }
    print("complete time is $time")
}

//async类似于launch可以启动一个新的协程，这个协程是轻量级的，与其他协程一起并发工作，与launch启动协程不同，launch启动返回一个Job对象
// 不带有任何返回值，而async返回一个Defrred对象一个轻量级非阻塞future，使用await在一个延期的值上得到结果，它是一个接口继承自Job对象，也就是说它也是一个job对象，可以进行取消操作
//async 风格函数   该函数不是挂起函数,可以在任何地方执行
fun doSomeAsync() = GlobalScope.async {
    doSome1()
}

fun doSomeAsync2() = GlobalScope.async {
    doSome2()
}

fun ttest() {
    val time = measureTimeMillis {
        //在协程外面异步执行，执行完成，在调用挂起函数进行阻塞,这种异步函数编程风格在协程中不受欢迎
        val one = doSomeAsync()
        val two = doSomeAsync2()
        //等待的结果必须调用挂起或阻塞
        runBlocking {
            print("result is ${one.await() + two.await()}")
        }
    }
    print("time is $time")
}

//使用async进行结构并发
suspend fun sum(): Int = coroutineScope {
    val one = doSomeAsync()
    val two = doSomeAsync2()
    one.await() + two.await()
}

fun resultShow() = runBlocking {
    val time = measureTimeMillis {
        print("answer is ${sum()}")
    }
    print("time is $time")
}


private suspend fun failureSum(): Int = coroutineScope {
    val one = async {
        try {
            delay(Long.MAX_VALUE)
            12
        } finally {
            print("first is canced")
        }
    }
    val two = async<Int> {
        print("second throw execption")
        throw ArrayIndexOutOfBoundsException()
    }
    one.await() + two.await()
}

fun testOne() = runBlocking {
    try {
        failureSum()
    } catch (e: ArithmeticException) {
        println("Computation failed with ArithmeticException")
    }
}

//协程上下文与调度器 ,协程上下文包括一个调度器，它确定相应的协程在执行时使用一个或多个线程，协程调度器会让协程执行在指定的局部线程中，调用它
//运行在线程池中或者不受它限制运行
fun testDispatcher() = runBlocking {
    launch { print("main runBlocking 运行在主协程") }
    launch(Dispatchers.Unconfined) { print("不受限，将工作在主协程") }
    launch(Dispatchers.Default) { print("将获取默认调度器") }
    //使用专门的协程将会非常耗费资源，所以必须用完释放
    launch(newSingleThreadContext("myThread")) { print("获得一个新的线程用于自身使用") }
}

//Dispatcher.Unconfig 调度器会在线程中启用协程，但是直到程序运行到第一个挂起点时才行。挂起后，它将完全由所运行的线程中恢复挂起函数，
//非受限调度器是合适的，它在协程没有消耗CPU时间或共享数据时被限制在指定线程中
fun testDispatcherMain() = runBlocking {
    //非受限将会和主协程一起工作
    launch(Dispatchers.Unconfined) {
        print("i am working in thread ${Thread.currentThread().name}")
        delay(500)
        print("after delay ,i am working in thread ")
    }

    launch {
        //父协程上下文
        print("i am working in thread ${Thread.currentThread().name}")
        delay(500)
        print("after delay ,i am working in thread ")
    }
}

fun log(msg: String) {
    print("[${Thread.currentThread().name}] $msg")
}

//在不同协程中跳转
fun jump() {
    newSingleThreadContext("cx1").use { cx1 ->
        newSingleThreadContext("cx2").use { cx2 ->
            //runBlocking 显示的指定上下文
            runBlocking(cx1) {
                log("Start in cx1")
                //改变协程的上下文
                withContext(cx2) {
                    log("run in cx2")
                }
                //仍然驻留在相同的协程中
                log("Back to cx1")
            }
        }
    }
}

//当一个父协程取消时，那么它所有的子协程也会取消，使用GlobalScope来启动一个协程，它与作用域无关且独立启动
/**
 * 输出
 *  job1: I run in GlobalScope and execute independently!
job2: I am a child of the request coroutine
job1: I am not affected by cancellation of the request
main: Who has survived request cancellation?
 */
fun parentLaunch() = runBlocking {
    //启用一个协程来处理请求
    val request = launch {
        //孵化两个子任务，一个使用GlobalScope启动,这与request协程无关，它取消后，这个独立协程并不会取消
        GlobalScope.launch {
            println("job1: I run in GlobalScope and execute independently!")
            delay(1000)
            println("job1: I am not affected by cancellation of the request")
        }
        //一个承接父协程上下文，是request协程中的子协程，request协程取消后，它就会取消
        launch {
            delay(100)
            println("job2: I am a child of the request coroutine")
            delay(1000)
            println("job2: I will not execute this line if my parent request is cancelled")
        }
    }
    delay(500)
    request.cancel()//取消request请求
    delay(1000) // 延迟一秒钟来看看发生了什么
    println("main: Who has survived request cancellation?")
}

//父协程总是等待所有子协程执行结束，父协程不会跟踪子协程也不必调用join方法在最后等待子协程
/**
 * 输出
 *  request: I'm done and I don't explicitly join my children that are still active
Coroutine 0 is done
Coroutine 1 is done
Coroutine 2 is done
Now processing of the request is complete
 */
fun parentLaunchTwo() = runBlocking {
    val request = launch {
        repeat(3) { i ->
            //启动少量子任务
            launch {
                delay((i + 1) * 200L)
                print("Coroutine is $i done")
            }
            println("request: I'm done and I don't explicitly join my children that are still active")
        }
    }
    request.join()//等待子协程，包括其所有子协程
    println("Now processing of the request is complete")
}

//协程构建器有两种，一种是自动传播异常，这个与Java中相似不对异常处理，还有一种暴露给用户（async与produce），让用户最终来消耗这些异常
/**
 *  输出
 *  Throwing exception from launch
Exception in thread "DefaultDispatcher-worker-2 @coroutine#2" java.lang.IndexOutOfBoundsException
Joined failed job
Throwing exception from async
Caught ArithmeticException
 */
fun testException() = runBlocking {
    val job = GlobalScope.launch {
        println("Throw Exception from launch")
        throw IndexOutOfBoundsException()
    }
    job.join()
    println("Joined failed Job")
    val deferred = GlobalScope.async {
        println("Throw Exception from async")
        throw ArithmeticException()//依赖用户去调用等待
    }
    try {
        //使用await延期获得一个结果
        deferred.await()
        println("Unreached")
    } catch (e: ArithmeticException) {
        println("Caught ArithmeticException")
    }
}

//CoroutineExceptionHandler仅在预计不会由用户处理的异常所调用,该方法中都是通过GlobalScope.launch创建协程,将异常处理
//设置在runBlocking作用域是无效的，尽管子协程设置了异常处理，但主协程还是会取消
//输出 Caught java.lang.AssertionError
fun testExceptionTow() = runBlocking {
    val handler = CoroutineExceptionHandler { _, exception ->
        println("Caught $exception")
    }
    val job = GlobalScope.launch(handler) {
        throw AssertionError()
    }

    val deferred = GlobalScope.async(job) {
        //数学运算异常，它0作为分母时
        throw ArithmeticException()//没有打印任何东西，依赖用户去调用await获取结果
    }
    joinAll(job, deferred)
}

//取消与异常紧密关联，协程内部使用CancellationException取消，当一个协程无理由调用job.cancel进行取消。它将会被取消
//但它父协程将不会被取消，因为无理由取消父协程只会取消其子协程而不是取消其自身
/**
 * 输出
 * Cancelling child
Child is cancelled
Parent is not cancelled
 */
fun cancelException() = runBlocking {
    val job = launch {
        val child = launch {
            try {
                delay(Long.MAX_VALUE)
            } finally {
                println("Child cancel")
            }
        }
        print("Child is canceling")
        yield()
        child.cancel()
        child.join()
        yield()
        print("Parent is not cancel")
    }
    job.join()
}

//如果协程遇到CancellationException以外的协程，它将取消具有该协程的父协程
/**
 * 输出
 * Second child throws an exception
Children are cancelled, but exception is not handled until all children terminate
The first child finished its non cancellable block
Caught java.lang.ArithmeticException
 */
fun testCancelException() = runBlocking {
    val handler = CoroutineExceptionHandler { _, exception ->
        println("Caught $exception")
    }
    val job = GlobalScope.launch {
        launch {
            //第一个子协程
            try {
                delay(Long.MAX_VALUE)
            } finally {
                withContext(NonCancellable) {
                    println("Children are canceled,but exception is not handled until all child terminate")
                    delay(100)
                    println("The first child finished is non cancellable block")
                }
            }
        }

        launch {
            //第二个子协程
            delay(10)
            println("Second throw Exception")
            throw ArithmeticException()
        }
    }
    job.join()
}

//如果一个协程中多个子协程抛出异常，那么第一个异常能够抛出处理，后面的异常丢失，比如在finally中抛出一个异常，后面异常无法处理
//输出 Caught java.io.IOException with suppressed [java.lang.ArithmeticException]
fun testChildException() = runBlocking {
    //CoroutineExceptionHandler 异常处理类
    val handler = CoroutineExceptionHandler { _, exception ->
        println("Caught $exception with suppressed ${exception.suppressed.contentToString()}")
    }

    val job = GlobalScope.launch(handler) {
        launch {
            try {
                delay(Long.MAX_VALUE)
            } finally {
                throw ArithmeticException()
            }
        }

        launch {
            delay(100)
            throw IOException()
        }
        delay(Long.MAX_VALUE)
    }
    job.join()
}

//监督任务 SupervisorJob,孵化一些子任务，监督它们故障，并在它们任务执行失败时进行重启，取消异常只会向下传播,一个异常取消被处理了，
//可以调用supervisor.cancel让第二个异常取消
/**
 * 输出
 * First child is failing
First child is cancelled: true, but second one is still active
Cancelling supervisor
Second child is cancelled because supervisor is cancelled
 */
fun testSupervisor() = runBlocking {
    val superVisor = SupervisorJob()
    //指定一个作用域上下文同时指定这是一个监督任务
    with(CoroutineScope(coroutineContext + superVisor)) {
        //启动第一个子任务，这个任务会忽略它对的异常
        val firstChild = launch(CoroutineExceptionHandler { _, _ -> }) {
            println("First child is Failing")
            throw AssertionError("First child is cancelled")
        }

        //启动第二个子任务
        val secondChild = launch {
            //等待第一个子任务执行结束
            firstChild.join()
            firstChild.join()
            println("supervisor is cancelled")

            println("First child is cancelled:${firstChild.isCancelled},but second child is active")
            try {
                delay(Long.MAX_VALUE)
            } finally {
                //取消监督传播，下一个任务就会被取消
                println("second is cancelled because supervisor is cancelled")
            }
        }
        //直到第一个子任务失败且执行完成        superVisor.cancel()
        secondChild.join()
    }

}

//监督作用域，使用supervisorScope取代coroutinueScope达到相同的目的，只会单向传播，并且当子任务执行全部失败时，
//将它们全部取消，等待子任务全部完成
/**
 * 输出
 * Child is sleeping
Throwing exception from scope
Child is cancelled
Caught assertion error
 */
fun testSupervisorScope() = runBlocking {
    try {
        supervisorScope {
            val child = launch {
                try {
                    println("Child is sleeping")
                    delay(Long.MAX_VALUE)
                } finally {
                    println("child is cancelled")
                }
            }
            //让出CPU空间，让其它协程执行
            yield()//给子任务打印异常的机会
            println("Throw exception from scope")
            throw AssertionError()
        }
    } catch (e: AssertionError) {
        println("Caught AssertionError")
    }
}

//常规任务与监督任务一个重要区别就是异常处理，每个子任务执行失败时会处理自身异常，而不是传递给父协程处理
/**
 * 输出
 * Scope is completing
Child throws an exception
Caught java.lang.AssertionError
Scope is completed
 */
fun testSuperSscope() = runBlocking {
    val handler = CoroutineExceptionHandler { _, exception ->
        println("Caught $exception")
    }

    supervisorScope {
        val child = launch(handler) {
            println("child throw Exception")
            throw AssertionError()
        }
        println("Scope is competing")
    }

    println("Scope is competed")
}

//组合上下文元素 使用+操作符来连接，比如：可以定义一个协程调取器同时显示的指定一个命名
fun testWithContext() = runBlocking {
    launch(Dispatchers.Default + CoroutineName("test")) {
        println("i am working in thread: ${Thread.currentThread().name}")
    }
}