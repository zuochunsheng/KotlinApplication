package edz.example.com.kotlinapplication.service

/**
 * @author： zcs
 * @time：2019/9/23 on 17:20
 * @description：DisposableObserver 的子类，用来接收网络数据回调
 */
abstract class HttpResultObserver2<T> : HttpResultObserver<ResultBean<T>>() {


    override fun onNext(t: ResultBean<T>) {
        when (t.code) {
            "000000" ->
                //T data = t.getData();
                onSuccessResult(t.data)
            else ->
                //HttpResultException e = new HttpResultException(t.getCode(), t.getMessage());
                onFailure(t.code, t.message)
        }
    }

    override fun onError(e: Throwable) {
        super.onError(e)
    }

    override fun onComplete() {
        super.onComplete()
    }


    /* ====================================*/

    protected abstract fun onSuccessResult(result: T)


}
