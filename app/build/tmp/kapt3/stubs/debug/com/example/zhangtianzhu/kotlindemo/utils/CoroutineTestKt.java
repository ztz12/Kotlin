package com.example.zhangtianzhu.kotlindemo.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000L\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0011\u0010\u0004\u001a\u00020\u0003H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u001a\u0011\u0010\u0006\u001a\u00020\u0007H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u001a\u0011\u0010\b\u001a\u00020\u0007H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u001a\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n\u001a\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\n\u001a\u0006\u0010\f\u001a\u00020\u0003\u001a\u0011\u0010\r\u001a\u00020\u0007H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u001a\u000e\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010\u001a\u0006\u0010\u0011\u001a\u00020\u0003\u001a\u000e\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0001\u001a\b\u0010\u0014\u001a\u00020\u0003H\u0002\u001a\u0006\u0010\u0015\u001a\u00020\u0003\u001a\u0006\u0010\u0016\u001a\u00020\u0003\u001a\u0006\u0010\u0017\u001a\u00020\u0003\u001a/\u0010\u0018\u001a\u00020\u00032\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001dH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001e\u001a\b\u0010\u001f\u001a\u00020\u0003H\u0002\u001a\u0006\u0010 \u001a\u00020\u0003\u001a\u0006\u0010!\u001a\u00020\u0003\u001a\b\u0010\"\u001a\u00020\u0003H\u0002\u001a\u0006\u0010#\u001a\u00020\u0003\u001a\b\u0010$\u001a\u00020\u0003H\u0002\u001a\u0010\u0010%\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001\u001a\u0011\u0010&\u001a\u00020\u0007H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u001a\b\u0010\'\u001a\u00020\u0003H\u0002\u001a\u0006\u0010(\u001a\u00020\u0003\u001a\u0006\u0010)\u001a\u00020\u0003\u001a\b\u0010*\u001a\u00020\u0007H\u0002\u001a\u0006\u0010+\u001a\u00020,\u001a\u0006\u0010-\u001a\u00020,\u001a\u0006\u0010.\u001a\u00020\u0003\u001a\u0006\u0010/\u001a\u00020\u0003\u001a\b\u00100\u001a\u00020\u0003H\u0002\u001a\u0006\u00101\u001a\u00020\u0010\u001a\u0006\u00102\u001a\u00020\u0003\u001a\u0006\u00103\u001a\u00020\u0003\u001a\u0006\u00104\u001a\u00020\u0003\u001a\u0006\u00105\u001a\u00020,\u001a\u0006\u00106\u001a\u00020\u0003\u001a(\u00107\u001a\b\u0012\u0004\u0012\u00020\u000708*\u0002092\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u0007082\u0006\u0010;\u001a\u00020\u0007H\u0002\u001a\"\u0010<\u001a\u00020,*\u0002092\u0006\u0010=\u001a\u00020\u00072\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000708H\u0002\u001a\u001a\u0010>\u001a\b\u0012\u0004\u0012\u00020\u000708*\u0002092\u0006\u0010?\u001a\u00020\u0007H\u0002\u001a\u0012\u0010@\u001a\b\u0012\u0004\u0012\u00020\u000708*\u000209H\u0002\u001a \u0010A\u001a\b\u0012\u0004\u0012\u00020\u000708*\u0002092\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u000708H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082D\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006B"}, d2 = {"tag", "", "cancelException", "", "doNext", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doSome1", "", "doSome2", "doSomeAsync", "Lkotlinx/coroutines/Deferred;", "doSomeAsync2", "done", "failureSum", "foo", "lock", "", "jump", "log", "msg", "main", "parentLaunch", "parentLaunchTwo", "resultShow", "sendString", "channel", "Lkotlinx/coroutines/channels/SendChannel;", "s", "time", "", "(Lkotlinx/coroutines/channels/SendChannel;Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "show", "showFive", "showFour", "showOne", "showThree", "showTwo", "so", "sum", "test", "testCancelException", "testChildException", "testCoro", "testDispatcher", "Lkotlinx/coroutines/Job;", "testDispatcherMain", "testException", "testExceptionTow", "testLaunch", "testOne", "testSuperSscope", "testSupervisor", "testSupervisorScope", "testWithContext", "ttest", "filter", "Lkotlinx/coroutines/channels/ReceiveChannel;", "Lkotlinx/coroutines/CoroutineScope;", "numbers", "prime", "launchProcessor", "id", "produceNumbers", "start", "produceSquare", "square", "app_debug"})
public final class CoroutineTestKt {
    private static final java.lang.String tag = "CoroutineTest";
    
    private static final void testLaunch() {
    }
    
    private static final int testCoro() {
        return 0;
    }
    
    private static final void main() {
    }
    
    private static final void show() {
    }
    
    private static final void showOne() {
    }
    
    private static final void showTwo() {
    }
    
    public static final void showThree() {
    }
    
    private static final kotlinx.coroutines.channels.ReceiveChannel<java.lang.Integer> produceSquare(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineScope $this$produceSquare) {
        return null;
    }
    
    private static final kotlinx.coroutines.channels.ReceiveChannel<java.lang.Integer> produceNumbers(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineScope $this$produceNumbers, int start) {
        return null;
    }
    
    private static final kotlinx.coroutines.channels.ReceiveChannel<java.lang.Integer> square(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineScope $this$square, kotlinx.coroutines.channels.ReceiveChannel<java.lang.Integer> numbers) {
        return null;
    }
    
    public static final void showFour() {
    }
    
    private static final kotlinx.coroutines.channels.ReceiveChannel<java.lang.Integer> filter(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineScope $this$filter, kotlinx.coroutines.channels.ReceiveChannel<java.lang.Integer> numbers, int prime) {
        return null;
    }
    
    private static final kotlinx.coroutines.Job launchProcessor(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineScope $this$launchProcessor, int id, kotlinx.coroutines.channels.ReceiveChannel<java.lang.Integer> channel) {
        return null;
    }
    
    private static final void test() {
    }
    
    public static final void showFive() {
    }
    
    public static final void so(@org.jetbrains.annotations.Nullable()
    java.lang.String s) {
    }
    
    public static final void foo(@org.jetbrains.annotations.NotNull()
    java.lang.Object lock) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final java.lang.Object doSome1(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> p0) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final java.lang.Object doSome2(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> p0) {
        return null;
    }
    
    public static final void done() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final kotlinx.coroutines.Deferred<java.lang.Integer> doSomeAsync() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final kotlinx.coroutines.Deferred<java.lang.Integer> doSomeAsync2() {
        return null;
    }
    
    public static final void ttest() {
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final java.lang.Object sum(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> p0) {
        return null;
    }
    
    public static final void resultShow() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.Object testOne() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final kotlinx.coroutines.Job testDispatcher() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final kotlinx.coroutines.Job testDispatcherMain() {
        return null;
    }
    
    public static final void log(@org.jetbrains.annotations.NotNull()
    java.lang.String msg) {
    }
    
    public static final void jump() {
    }
    
    /**
     * 输出
     *  job1: I run in GlobalScope and execute independently!
     * job2: I am a child of the request coroutine
     * job1: I am not affected by cancellation of the request
     * main: Who has survived request cancellation?
     */
    public static final void parentLaunch() {
    }
    
    /**
     * 输出
     *  request: I'm done and I don't explicitly join my children that are still active
     * Coroutine 0 is done
     * Coroutine 1 is done
     * Coroutine 2 is done
     * Now processing of the request is complete
     */
    public static final void parentLaunchTwo() {
    }
    
    /**
     * 输出
     *  Throwing exception from launch
     * Exception in thread "DefaultDispatcher-worker-2 @coroutine#2" java.lang.IndexOutOfBoundsException
     * Joined failed job
     * Throwing exception from async
     * Caught ArithmeticException
     */
    public static final void testException() {
    }
    
    public static final void testExceptionTow() {
    }
    
    /**
     * 输出
     * Cancelling child
     * Child is cancelled
     * Parent is not cancelled
     */
    public static final void cancelException() {
    }
    
    /**
     * 输出
     * Second child throws an exception
     * Children are cancelled, but exception is not handled until all children terminate
     * The first child finished its non cancellable block
     * Caught java.lang.ArithmeticException
     */
    public static final void testCancelException() {
    }
    
    public static final void testChildException() {
    }
    
    /**
     * 输出
     * First child is failing
     * First child is cancelled: true, but second one is still active
     * Cancelling supervisor
     * Second child is cancelled because supervisor is cancelled
     */
    public static final void testSupervisor() {
    }
    
    /**
     * 输出
     * Child is sleeping
     * Throwing exception from scope
     * Child is cancelled
     * Caught assertion error
     */
    public static final void testSupervisorScope() {
    }
    
    /**
     * 输出
     * Scope is completing
     * Child throws an exception
     * Caught java.lang.AssertionError
     * Scope is completed
     */
    public static final void testSuperSscope() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final kotlinx.coroutines.Job testWithContext() {
        return null;
    }
}