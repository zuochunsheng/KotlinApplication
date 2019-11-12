package com.example.edz.kotlinapplication.javatest;

import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author： zcs
 * @time：2019/11/12 on 19:06
 * @description：
 */
public class RxUtil {

//    private final static ObservableTransformer schedulersTransformer = new  ObservableTransformer() {
//        @Override public Observable apply(Observable observable) {
//            return observable.subscribeOn(Schedulers.newThread())
//                    .observeOn(AndroidSchedulers.mainThread());
//        }
//    };
//
//    public static  <T> ObservableTransformer<T, T> applySchedulers() {
//        return (ObservableTransformer<T, T>) schedulersTransformer;
//    }


    public static <T> ObservableTransformer<T, T> compose() {

//        return (ObservableTransformer<T, T>) (new  ObservableTransformer() {
//            @Override public Observable apply(Observable observable) {
//                return observable.subscribeOn(Schedulers.newThread())
//                        .observeOn(AndroidSchedulers.mainThread());
//            }
//        });
        return (observable ->
                observable.subscribeOn(Schedulers.io())
                          .observeOn(AndroidSchedulers.mainThread())
        );
    }


}
