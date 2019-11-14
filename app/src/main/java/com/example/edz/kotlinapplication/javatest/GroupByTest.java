package com.example.edz.kotlinapplication.javatest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Scheduler;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.observables.GroupedObservable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author： zcs
 * @time：2019/11/14 on 9:42
 * @description：
 */
public class GroupByTest {

    public static void main(String... args) {


        //testScheduler();

        testGroupBy();

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void testGroupBy() {
        //Observable.interval(1, TimeUnit.SECONDS)
        //.take(10)
//        Observable.range(1, 10)
//                .groupBy(new Function<Integer, Integer>() {
//                    @Override
//                    public Integer apply(Integer integer) throws Exception {
//                        //按照key为0,1,2分为3组
//                        return integer % 3;
//                    }
//                }).subscribe(new Consumer<GroupedObservable<Integer, Integer>>() {
//            @Override
//            public void accept(GroupedObservable<Integer, Integer> result) {
//                result.subscribe(new Consumer<Integer>() {
//                    @Override
//                    public void accept(Integer value) {
//                        System.out.println("key:" + result.getKey() + ", value:" + value);
//                    }
//                });
//            }
//        });

        Observable.range(1, 10)
                .groupBy(integer -> integer % 3)
                .subscribe(result ->
                                result.take(9).subscribe(value ->
                                       System.out.println("key:" + result.getKey() + ", value:" + value)
                                )
                );

    }

    public static void testSchedulerNewThread() {
        Scheduler.Worker worker = Schedulers.newThread().createWorker();
        worker.schedule(() -> System.out.println("111111"));

        boolean disposed = worker.isDisposed();
        System.out.println("value is:" + disposed);
    }

    public static void testScheduler() {
        Observable.create(new ObservableOnSubscribe<String>() {

            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                for (int i = 0; i < 60; i++) {
                    System.out.println("发射线程：" + Thread.currentThread().getName() + " ---->发射: " + i);
                    if (i > 20 && i < 30) {
                        Thread.sleep(100L);
                    }
                    emitter.onNext("===>" + i);
                }
                emitter.onComplete();
            }
        }).subscribeOn(Schedulers.io())
                //.observeOn(Schedulers.single())
                .observeOn(Schedulers.computation())
                //.observeOn(Schedulers.trampoline())
                .subscribe(new Consumer<String>() {

                    @Override
                    public void accept(String t) throws Exception {
                        System.out.println("接收线程：" + Thread.currentThread().getName() + " ---->接收: " + t);
                    }

                });
    }

//    Schedulers.single()
//    发射线程：RxCachedThreadScheduler-1 ---->发射: 18
//    发射线程：RxCachedThreadScheduler-1 ---->发射: 19
//    发射线程：RxCachedThreadScheduler-1 ---->发射: 20
//    发射线程：RxCachedThreadScheduler-1 ---->发射: 21
//    接收线程：RxSingleScheduler-1 ---->接收: ===>18
//    接收线程：RxSingleScheduler-1 ---->接收: ===>19
//    接收线程：RxSingleScheduler-1 ---->接收: ===>20
//    发射线程：RxCachedThreadScheduler-1 ---->发射: 22
//    接收线程：RxSingleScheduler-1 ---->接收: ===>21
//    发射线程：RxCachedThreadScheduler-1 ---->发射: 23
//    接收线程：RxSingleScheduler-1 ---->接收: ===>22

//Schedulers.computation()
//    发射线程：RxCachedThreadScheduler-1 ---->发射: 22
//    接收线程：RxComputationThreadPool-1 ---->接收: ===>21
//    发射线程：RxCachedThreadScheduler-1 ---->发射: 23
//    接收线程：RxComputationThreadPool-1 ---->接收: ===>22

//   Schedulers.trampoline()
//    发射线程：RxCachedThreadScheduler-1 ---->发射: 0
//    接收线程：RxCachedThreadScheduler-1 ---->接收: ===>0
//    发射线程：RxCachedThreadScheduler-1 ---->发射: 1
//    接收线程：RxCachedThreadScheduler-1 ---->接收: ===>1
}
