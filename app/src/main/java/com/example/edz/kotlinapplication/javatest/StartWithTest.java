package com.example.edz.kotlinapplication.javatest;

import android.util.Log;
import android.view.View;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author： zcs
 * @time：2019/11/15 on 9:55
 * @description：
 */
public class StartWithTest {

    public static void main(String... args){
        //test();

        create();
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void test(){

//        //插入普通数据
//        //startWith 数据序列的开头插入一条指定的项
//        Observable observable = Observable.just( "aa" , "bb" , "cc" ) ;
//        Observable.just( "aa" , "bb" , "cc" )
//                //.startWith("55")
//                .startWithArray("11","22")
//                .subscribe(o -> System.out.println("startWith1 -- " + o) ) ;
//
//        //插入Observable对象
//        List<String> list = new ArrayList<>() ;
//        list.add( "ww" ) ;
//        list.add( "tt" ) ;
//        observable.startWith(Observable.fromIterable( list ))
//                .subscribe(o -> System.out.println("startWith2 -- " + o)) ;
//
//

//        Observable<String> observable = Observable.just( "1" , "2" , "3" , "4" , "5" , "6" , "7" , "8" ) ;
//        //延迟数据发射的时间，仅仅延时一次，也就是发射第一个数据前延时。发射后面的数据不延时
//        observable
//                 .delay( 3 , TimeUnit.SECONDS )  //延迟3秒钟
//                 .subscribe(o -> System.out.println("delay-- " + o)) ;
//
//        //创建操作符 Observable 开头，
//        //timer使用场景：xx秒后，执行xx
        Observable.timer( 5 , TimeUnit.SECONDS )
//                .doOnSubscribe()
//                .doOnComplete()
//                .doOnError()
//                .doOnNext()
                //.observeOn(AndroidSchedulers.mainThread() )
                .subscribe(o -> System.out.println("timer-- " + o)) ;// 0

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


    public static void create(){

//快速创建中的特殊的操作符
        //empty() 该创建符创建的被观察者直接发送complete事件通知完成 即观察者直接调用onComplete()方法
        Observable.empty().subscribe(new Observer<Object>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println( "onSubscribe: ");
            }

            @Override
            public void onNext(Object o) {
                System.out.println( "onNext: " + o.toString());
            }

            @Override
            public void onError(Throwable e) {
                System.out.println( "onError: ");
            }

            @Override
            public void onComplete() {
                System.out.println( "empty --- onComplete: ");
            }
        });

        //error()操作符创建的被观察者只会产生error事件 因此观察者只会调用onError进行响应
        Observable.error(new RuntimeException("只产生error事件，观察者只调用onError()进行响应")).subscribe(new Observer<Object>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println( "onSubscribe: ");
            }

            @Override
            public void onNext(Object o) {
                System.out.println( "onNext: ");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println( "error onError: " + e.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println( "onComplete: ");
            }
        });

        //never()该创建符创建的被观察者不会发送任何的事件 因此观察者也不会调用任何的响应事件的方法
        Observable.never().subscribe(new Observer<Object>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println( "onSubscribe: ");
            }

            @Override
            public void onNext(Object o) {
                System.out.println( "onNext: ");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError: ");
            }

            @Override
            public void onComplete() {
                System.out.println( "onComplete: ");
            }
        });


    }
}
