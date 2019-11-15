package com.example.edz.kotlinapplication.javatest;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.observers.ConsumerSingleObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * @author： zcs
 * @time：2019/11/14 on 15:25
 * @description：
 */
public class FilterTest {

    public static void main(String... args) {

        testFilter();

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void testFilter() {

//        Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
//                //产生结果的间隔时间分别为100、200、300...900毫秒
//                for (int i = 1; i < 10; i++) {
//                    emitter.onNext(i);
//                    Thread.sleep(i * 100);
//                }
//                emitter.onComplete();
//
//            }
//        }).subscribeOn(Schedulers.newThread())
//                .debounce(400, TimeUnit.MILLISECONDS)  //超时时间为400毫秒
//                .subscribe(new Observer<Integer>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        System.out.println("Next:" + integer);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        System.out.println("Error:" + e.getMessage());
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        System.out.println("completed!");
//                    }
//                });
//
//        Observable.create(emitter ->
//                    {
//                        //产生结果的间隔时间分别为100、200、300...900毫秒
//                        for (int i = 1; i < 10; i++) {
//                            emitter.onNext(i);
//                            Thread.sleep(i * 100);
//                        }
//                        emitter.onComplete();
//                    }
//                ).subscribeOn(Schedulers.newThread())
//                        //.debounce(400, TimeUnit.MILLISECONDS)  //超时时间为400毫秒
//                        .subscribe(
//                                (integer -> System.out.println("Next:" + integer)),
//                                (e -> System.out.println("Error:" + e.getMessage()) ),
//                                () -> System.out.print("complete")
//                        );
//

//    Next:5
//    Next:6
//    Next:7
//    Next:8
//    Next:9
//    completed!




//        Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
//                //前8个数字产生的时间间隔为1秒，后一个间隔为3秒
//                for (int i = 1; i < 9; i++) {
//                    emitter.onNext(i);
//                    Thread.sleep(1000);
//                }
//                Thread.sleep(2000);
//                emitter.onNext(9);
//                emitter.onComplete();
//            }
//        }).subscribeOn(Schedulers.newThread())
//                .sample(2200, TimeUnit.MILLISECONDS)  //采样间隔时间为2200毫秒
//                .subscribe(new Observer<Integer>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(Integer item) {
//                        System.out.println("Next: " + item);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        System.err.println("Error: " + e.getMessage());
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        System.out.println("Sequence complete.");
//                    }
//                });

                Observable.create(emitter ->
                    {
                        //前8个数字产生的时间间隔为1秒，后一个间隔为3秒
                        for (int i = 1; i < 9; i++) {
                            emitter.onNext(i);
                            Thread.sleep(1000);
                        }
                        Thread.sleep(2000);
                        emitter.onNext(9);
                        emitter.onComplete();
                    }
                ).subscribeOn(Schedulers.newThread())
                        .sample(2200, TimeUnit.MILLISECONDS)  //采样间隔时间为2200毫秒
                        .subscribe(
                                (item -> System.out.println("Next:" + item)),
                                (e -> System.out.println("Error:" + e.getMessage()) ),
                                () -> System.out.print("complete")
                        );


//        Next:3
//        Next:5
//        Next:7
//        Next:8
//        complete
    }


}
