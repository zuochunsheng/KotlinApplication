package com.example.edz.kotlinapplication.javatest;

/**
 * @author： zcs
 * @time：2019/11/15 on 18:16
 * @description：
 */

import java.io.IOException;

import io.reactivex.Observable;
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

public class ConditionsTest {

    public static void main(String... args) {
        test();
        //testDo();
        // testSingle();

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void test() {
        Observable<String> observable = Observable.just("1", "2", "3", "4", "5", "6", "7", "8");
        Observable<String> observable2 = Observable.just("a", "b", "c", "d", "e", "f");
        Observable<Integer> range = Observable.range(11, 9);

        //        Observable.create(emitter ->
//                    {
//                        //产生结果的间隔时间分别为100、200、300...900毫秒
//                        for (int i = 1; i < 10; i++) {
//                            emitter.onNext(i);
//                            Thread.sleep(i * 100);
//                        }
//                        emitter.onComplete();
//                    }
//                )

        Observable.range(1, 9)
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
//                 .takeUntil(range)

//                .skipWhile(new Predicate<Integer>() {
//                    @Override
//                    public boolean test(Integer integer) throws Exception {
//                        System.out.println("skipWhile = "+integer.toString());
//                        System.out.println("skipWhile = "+(integer.intValue() < 5));
//                       // 5<5  false
//                        return integer.intValue() < 5;
//                    }
//                })
                // .skipUntil(range)

                .subscribe(x -> System.out.println("next = " + x),
                        error -> System.out.println("error =" + error),
                        () -> System.out.println("complete")
                );
    }
}
