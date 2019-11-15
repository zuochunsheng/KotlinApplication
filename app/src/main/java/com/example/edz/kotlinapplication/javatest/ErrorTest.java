package com.example.edz.kotlinapplication.javatest;

import org.reactivestreams.Subscriber;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.reactivex.Notification;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @author： zcs
 * @time：2019/11/15 on 11:28
 * @description：
 */
//5 错误处理
//onErrorResumeNext( ) — 指示Observable在遇到错误时发射一个数据序列
//onErrorReturn( ) — 指示Observable在遇到错误时发射一个特定的数据
//onExceptionResumeNext( ) — 指示Observable遇到错误时继续发射数据
//
//retry( ) — 指示Observable遇到错误时重试
//retryWhen( ) — 指示Observable遇到错误时，将错误传递给另一个Observable 来决定是否要重新给订阅这个Observable
//
//辅助操作
//materialize( ) — 将Observable转换成一个通知列表
//dematerialize( ) — 将上面的结果逆转回一个Observable
//
//timestamp( ) — 给Observable发射的每个数据项添加一个时间戳
//serialize( ) — 强制Observable按次序发射数据并且要求功能是完好的
//cache( ) — 记住Observable发射的数据序列并发射相同的数据序列给后续的订阅者
//
//subscribeOn( ) — 指定Observable执行任务的调度器
//observeOn( ) — 指定观察者 观察Observable的调度器
//
//doOnEach( ) — 注册一个动作，对Observable发射的每个数据项使用
//
//doOnCompleted( ) — 注册一个动作，对正常完成的Observable使用
//doOnError( ) — 注册一个动作，对发生错误的Observable使用
//doOnNext() - 注册一个动作，在每次 OnNext()方法被调用前执行,使用场景：从网络请求数据，在数据被展示前，缓存到本地
//doOnTerminate( ) — 注册一个动作，对完成的Observable使用，无论是否发生错误
//
//doOnSubscribe( ) — 注册一个动作，在观察者订阅时使用, 使用场景：可以在事件发出之前做一些初始化的工作，比如弹出进度条等等
//
//delay( ) — 延时发射Observable的结果
//delaySubscription( ) — 延时处理订阅请求
//
//timeInterval( ) — 定期发射数据
//using( ) — 创建一个只在Observable生命周期存在的资源
//
//singleElement() — 强制返回单个数据，否则抛出异常
//single(defaultItem) — 如果Observable完成时返回了单个数据，就返回它，否则返回默认数据
//singleOrError
//
//toFuture( ), toIterable( ), toList( ) — 将Observable转换为其它对象或数据结构

public class ErrorTest {

    public static void main(String... args) {
        //test();
        testDo();
        // testSingle();

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void test() {

//        Observable.create(emitter -> {
//                    emitter.onNext("a");
//                    emitter.onNext("b");
//                    emitter.onNext("c");
//                    emitter.onComplete();
//                }
//        )
//                .materialize()
//                .subscribe(x -> System.out.println("next = " + x),
//                        error -> System.out.println("error =" + error.toString()),
//                        ()-> System.out.println("complete")
//                );

        Observable.fromArray("aa", "bb", "cc")
                //.timestamp()
                //.serialize()
                //.cache()
                .subscribe(x -> System.out.println("next = " + x),
                        error -> System.out.println("error =" + error.toString()),
                        () -> System.out.println("complete")
                );
    }

    private static void testDo() {
        Observable<String> observable = Observable.just("1", "2", "3", "4", "5", "6", "7", "8");
//        //延迟数据发射的时间，仅仅延时一次，也就是发射第一个数据前延时。发射后面的数据不延时
        observable
//                 //.delay( 3 , TimeUnit.SECONDS )  //延迟发射
                   .delaySubscription(3 , TimeUnit.SECONDS)//延时订阅
                // .timeInterval(TimeUnit.SECONDS, Schedulers.newThread())

//                .doOnSubscribe(new Consumer<Disposable>() {
//                    @Override
//                    public void accept(Disposable disposable) throws Exception {
//                        System.out.println("doOnSubscribe");
//                    }
//                })

//                .doOnEach(new Consumer<Notification<String>>() {
//                    @Override
//                    public void accept(Notification<String> stringNotification) throws Exception {
//                        System.out.println("doOnEach ---" + stringNotification.toString());
//                    }
//                })

//                .doOnNext(new Consumer<String>() {
//                    @Override
//                    public void accept(String s) throws Exception {
//                        System.out.println("doOnNext ====" + s);
//                    }
//                })
//                .doOnComplete(new Action() {
//                    @Override
//                    public void run() throws Exception {
//                        System.out.println("doOnComplete");
//
//                    }
//                })
//                .doOnError(new Consumer<Throwable>() {
//                    @Override
//                    public void accept(Throwable throwable) throws Exception {
//                        System.out.println("doOnError");
//                    }
//                })
//
//                .doOnTerminate(new Action() {
//                    @Override
//                    public void run() throws Exception {
//                        System.out.println("doOnTerminate");
//                    }
//                })

                .subscribe(x -> System.out.println("next = " + x),
                        error -> System.out.println("error =" + error),
                        () -> System.out.println("complete")
                );



//        //创建操作符 Observable 开头，
//        //timer使用场景：xx秒后，执行xx
//        Observable.timer(5, TimeUnit.SECONDS)
//                //.observeOn(AndroidSchedulers.mainThread() )
//                .subscribe(o -> System.out.println("timer-- " + o));// 0

//        11、doOnNext() 操作符，在每次 OnNext() 方法被调用前执行
//        使用场景：从网络请求数据，在数据被展示前，缓存到本地

//16      doOnSubscribe()
//        使用场景： 可以在事件发出之前做一些初始化的工作，比如弹出进度条等等
//        注意：
//        1、doOnSubscribe() 默认运行在事件产生的线程里面，然而事件产生的线程一般都会运行在 io 线程里。那么这个时候做一些，更新UI的操作，是线程不安全的。
//
//        所以如果事件产生的线程是io线程，但是我们又要在doOnSubscribe() 更新UI ， 这时候就需要线程切换。
//
//        2、如果在 doOnSubscribe() 之后有 subscribeOn() 的话，它将执行在离它最近的 subscribeOn() 所指定的线程。
//
//        3、 subscribeOn() 事件产生的线程 ； observeOn() : 事件消费的线程


//        Observable.create(onSubscribe)
//                .subscribeOn(Schedulers.io())

//                .doOnSubscribe(new Action0() {
//                    @Override
//                    public void call() {
//                        progressBar.setVisibility(View.VISIBLE); // 需要在主线程执行
//                    }
//                })
//                .subscribeOn(AndroidSchedulers.mainThread()) // 指定主线程

//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(subscriber);


    }

    private static void testRetry() {

        //error()操作符创建的被观察者只会产生error事件 因此观察者只会调用onError进行响应
//        Observable.error(new RuntimeException("只产生error事件，观察者只调用onError()进行响应"))
//                .retry()
//                .retry(3)
//
//                .subscribe(new Observer<Object>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        System.out.println("onSubscribe: ");
//                    }
//
//                    @Override
//                    public void onNext(Object o) {
//                        System.out.println("onNext: ");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        System.out.println("error onError: " + e.getMessage());
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        System.out.println("onComplete: ");
//                    }
//                });


        Observable.create(emitter -> {
                    System.out.println("create subscribing");
                    emitter.onError(new RuntimeException("always fails"));
                }
        ).retryWhen(attempts -> {
            return attempts.zipWith(Observable.range(1, 3), (n, i) -> i)
                    .flatMap(i -> {
                        System.out.println("delay retry by " + i + " second(s)");
                        return Observable.timer(i, TimeUnit.SECONDS);
                    });
        }).forEach(System.out::println);
    }

    private static void testSingle() {
        Observable.just(1, 2)
                //.single(20)
                //.singleOrError()
                //.singleElement()
                .subscribe(new Consumer<Object>() {

                    @Override
                    public void accept(Object o) throws Exception {
                        System.out.println("accept: " + o);
                    }
                });

//                .subscribe(new SingleObserver<Integer>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onSuccess(Integer integer) {
//                        System.out.println("Next: " + integer);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        System.err.println("Error: " + e.getMessage());
//                    }
//                });

    }
}
