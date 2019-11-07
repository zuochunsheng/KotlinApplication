package com.example.edz.kotlinapplication.service

/**
 * @author： zcs
 * @time：2019/9/23 on 17:20
 * @description：DisposableSingleObserver 的子类，用来接收网络数据回调
 */
abstract class HttpResultSingleObserver2<T> : HttpResultSingleObserver<ResultBean<T>>() {

    override fun onSuccess(t: ResultBean<T>) {
        when (t.code) {
            "000000" ->
                //T data = t.getData();
                onSuccessResult(t.data!!)
            else ->
                //HttpResultException e = new HttpResultException(t.getCode(), t.getMessage());
                onFailure(t.code, t.message)
        }//onSuccess(t.getData());
    }

    override fun onError(e: Throwable) {
        super.onError(e)
    }


    /* ====================================*/


    /**
     * 请求成功回调
     *
     * @param result 回调数据
     */
    protected abstract fun onSuccessResult(result: T)

    /**
     * 请求失败回调
     * @param error ，自定义异常
     * @param e       失败异常信息
     */
    //public abstract void onFailure(HttpError error, @NonNull Throwable e);


}
