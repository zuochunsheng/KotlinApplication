package com.example.edz.kotlinapplication.javatest;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author： zcs
 * @time：2019/11/18 on 17:37
 * @description：
 */
public class HotTest {

    public static void main(String... args){

        testPublish();


    }
//share = publish + connect
    private static void testPublish(){
        ConnectableObservable<Long> publish = Observable.interval(100, TimeUnit.MILLISECONDS, Schedulers.computation())
                .publish();
                //.replay();
                //.replay(2);

        Observable<Long> cache = Observable.interval(100, TimeUnit.MILLISECONDS, Schedulers.computation())
                .cache();

        publish.connect();
       // publish.autoConnect();
        System.out.println("connect");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Disposable subscribe = publish.subscribe(aLong -> System.out.println("first: " + aLong));


        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Disposable secondDis = publish.subscribe(new Consumer<Long>() {
            @Override
            public void accept(Long aLong) throws Exception {
                System.out.println("second: " + aLong);
            }
        });


        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("first dispose ");
        subscribe.dispose();

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("second dispose ");
        secondDis.dispose();

    }


}
