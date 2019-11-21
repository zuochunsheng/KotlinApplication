package com.example.edz.kotlinapplication.javatest;

/**
 * @author： zcs
 * @time：2019/11/15 on 18:16
 * @description：
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Predicate;

//7 条件操作符
// - amb() — 给定多个Observable，只让第一个发射数据的Observable发射全部数据
// - defaultIfEmpty() — 发射来自原始Observable的数据，如果原始Observable没有发射数据，就发射一个默认数据
//
// -  takeUntil() — 发射来自原始Observable的数据，直到第二个Observable发射了一个数据或一个通知。
// -  **takeWhile()** —  根据指定条件，发射Observable数据，直到指定的条件不成立。
// **指定条件为ture,就发射，一旦为false,就不再发射**。
//
// -  skipUntil() — 丢弃原始Observable发射的数据，直到第二个Observable发射了一个数据，然后发射原始Observable的剩余数据
// -  **skipWhile()** — 根据指定条件,丢弃Observable发射的数据，直到指定的条件不成立，它开始发射剩下原始数据。
// **指定条件为ture,就丢弃，一旦为false,就发射**

//8 布尔操作符
//all( ) — 判断是否所有的数据项都满足某个条件
//contains( ) — 判断Observable是否会发射一个指定的值
//exists( ) and isEmpty( ) — 判断Observable是否发射了一个值
//sequenceEqual( ) — 判断两个Observables发射的序列是否相等

// 9 算术操作
//average — 求序列平均数并发射
//sum( ) — 求和并发射

//max( ) — 求序列最大值并发射
//maxBy( ) — 求最大key对应的值并发射
//min( ) — 求最小值并发射
//minBy( ) — 求最小Key对应的值并发射

// 聚合操作
//concat( ) — 顺序连接多个Observables
//count( ) and countLong( ) — 计算数据项的个数并发射结果
//reduce( ) — 对序列使用reduce()函数并发射最终的结果
//collect( ) — 将原始Observable发射的数据放到一个单一的可变的数据结构中，然后返回一个发射这个数据结构的Observable

public class ConditionsTest {

    public static void main(String... args) {
        test();
        //mathTest();

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void test() {


        Observable observable1 = Observable.create(emitter ->
                {
                    //产生结果的间隔时间分别为300毫秒
                    for (int i = 61; i < 71; i++) {
                        Thread.sleep(300);
                        System.out.println(" ---->发射: " + i);
                        emitter.onNext(i);

                    }
                    emitter.onComplete();
                }
        );

        Observable observable2 =   Observable.create(new ObservableOnSubscribe<String>() {

            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                for (int i = 1; i < 31; i++) {

                    Thread.sleep(100L);
                    System.out.println("---->发射: " + i);
                    emitter.onNext("===>" + i);
                }
                emitter.onComplete();
            }
        });

        observable2

                //       Observable.range(1, 9)
                //.ambWith(observable2)
                //.defaultIfEmpty("xx")

//                .takeWhile(new Predicate<Integer>() {
//                    @Override
//                    public boolean test(Integer integer) throws Exception {
//                        System.out.println("takeWhile = " + integer.toString());
//                        return integer.intValue() < 5;
//                    }
//                })
//                .takeUntil(new Predicate<Integer>() {
//                    @Override
//                    public boolean test(Integer integer) throws Exception {
//                        System.out.println("takeUntil = " + integer.toString());
//                        System.out.println("takeUntil = " + (integer.intValue() > 5));
//                        return integer.intValue() > 5;
//                    }
//                })

                 .takeUntil(observable1)

//                .skipWhile(new Predicate<Integer>() {
//                    @Override
//                    public boolean test(Integer integer) throws Exception {
//                        System.out.println("skipWhile = "+integer.toString());
//                        System.out.println("skipWhile = "+(integer.intValue() < 5));
//                       // 5<5  false
//                        return integer.intValue() < 5;
//                    }
//                })
                 //.skipUntil(observable2)

                .subscribe(x -> System.out.println("next = " + x),
                        error -> System.out.println("error =" + error),
                        () -> System.out.println("complete")
                );


    }


    private static void mathTest() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Observable.fromIterable(list)
                //.count()
                //.reduce()
                //.collect()

                .subscribe(x -> System.out.println("next = " + x),
                        error -> System.out.println("error =" + error),
                        () -> System.out.println("complete")
                );
    }
}
