package com.example.edz.kotlinapplication.javatest;


import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;

/**
 * @author： zcs
 * @time：2019/11/13 on 19:03
 * @description：
 */
public class BufferTest {

    public static void main(String... args) {
        //bufferTest();
        windowTest();
        //operate();
    }

//    1 用法：使用buffer的地方都可以替换成window;
//2 window与buffer区别：window是把数据分割成了Observable，buffer是把数据分割成List
    private static void windowTest() {
        //缓冲区在大小达到2时和时间窗口末尾时都会发出
//        Observable.interval(100, TimeUnit.MILLISECONDS)
//                .take(10)
//                .window(250,TimeUnit.MILLISECONDS,2)
//                .subscribe(System.out::println);


        //缓冲区在时间窗口末尾时会发出
//        Observable.interval(100, TimeUnit.MILLISECONDS)
//                .take(10)
//                .window(250,TimeUnit.MILLISECONDS)
//                .subscribe(System.out::println);
//        //等同上
//        Observable.interval(100, TimeUnit.MILLISECONDS)
//                .take(10)
//                .window(Observable.interval(250,TimeUnit.MILLISECONDS))
//                .subscribe(System.out::println);


        Observable.range(0, 10)
                .window(4)
                //.window(4,3)
                .subscribe(new Consumer<Observable<Integer>>() {
                    @Override
                    public void accept(Observable<Integer> integerObservable) throws Exception {

                        System.out.println("window=" + integerObservable.toString());
                        Single<List<Integer>> listSingle = integerObservable.toList();
                        listSingle.subscribe(new Consumer<List<Integer>>() {
                            @Override
                            public void accept(List<Integer> integers) throws Exception {
                                System.out.println("window list=" + integers.toString());
                            }
                        });

                    }
                });

        Observable.range(0, 10)
                .buffer(4)
                .subscribe(new Consumer<List<Integer>>() {
                    @Override
                    public void accept(List<Integer> integers) throws Exception {
                        System.out.println("buffer list=" + integers.toString());
                    }
                });


        //类似于buffer(count,skip)
        //每200 ms创建一个新的缓冲区，每个缓冲区会发射接下来350 ms时间内的数据
//        Observable.interval(100, TimeUnit.MILLISECONDS)
//                .take(10)
//                .window(350,200,TimeUnit.MILLISECONDS)
//                .subscribe(System.out::println);

        //等同上
//        Observable.interval(100, TimeUnit.MILLISECONDS)
//                .take(10)
//                .window(Observable.interval(250,TimeUnit.MILLISECONDS),
//                        i ->Observable.timer(200,TimeUnit.MILLISECONDS))
//                .subscribe(System.out::println);


        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void bufferTest() {

//        //缓冲区在大小达到2时和时间窗口末尾时都会发出
//        Observable.interval(100, TimeUnit.MILLISECONDS)
//                .take(10)
//                .buffer(250,TimeUnit.MILLISECONDS,2)
//                .subscribe(System.out::println);
//
//
//        //缓冲区在时间窗口末尾时会发出
        Observable.interval(100, TimeUnit.MILLISECONDS)
                .take(10)
                .buffer(250, TimeUnit.MILLISECONDS)
                .subscribe(new Consumer<List<Long>>() {
                    @Override
                    public void accept(List<Long> longs) throws Exception {

                    }
                });
//        //等同上
//        Observable.interval(100, TimeUnit.MILLISECONDS)
//                .take(10)
//                .buffer(Observable.interval(250,TimeUnit.MILLISECONDS))
//                .subscribe(System.out::println);
//
//
//
//        Observable.range(0, 10)
//                .buffer(4,3)
//                .subscribe(System.out::println);
//
//
//        //类似于buffer(count,skip)
//        //每200 ms创建一个新的缓冲区，每个缓冲区会发射接下来350 ms时间内的数据
        Observable.interval(100, TimeUnit.MILLISECONDS)
                .take(10)
                .buffer(350, 200, TimeUnit.MILLISECONDS)
                .subscribe(System.out::println);
//
//        //等同上
//        Observable.interval(100, TimeUnit.MILLISECONDS)
//                .take(10)
//                .buffer(Observable.interval(250,TimeUnit.MILLISECONDS),
//                        i ->Observable.timer(200,TimeUnit.MILLISECONDS))
//                .subscribe(System.out::println);



        /*-----------------*/
        //取最后N个元素
        Observable.range(0, 10)
                .takeLast(4)
                .subscribe(System.out::println);

        //取time时间后的作为缓冲区发射的元素
        Observable.interval(100, TimeUnit.MILLISECONDS)
                .take(10)
                .takeLast(200, TimeUnit.MILLISECONDS)
                .subscribe(System.out::println);

        //取time时间后的作为缓冲区发射的最后N个元素（可能小于N）
        Observable.interval(100, TimeUnit.MILLISECONDS)
                .take(10)
                .takeLast(4, 200, TimeUnit.MILLISECONDS)
                .subscribe(System.out::println);


        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
