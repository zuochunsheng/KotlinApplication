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
