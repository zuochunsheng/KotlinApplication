package edz.example.com.kotlinapplication.service;

import android.text.TextUtils;


/**
 * @author： zcs
 * @time：2019/9/24 on 15:49
 * @description：
 */
public class ResultBean<T> extends AbstractResultBean {
    private String code;
    private String message;
    private T data;

    @Override
    public boolean success() {
        return TextUtils.equals(code,"000000");
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }


}
