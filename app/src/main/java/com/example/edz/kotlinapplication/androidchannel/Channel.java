package com.example.edz.kotlinapplication.androidchannel;

import io.flutter.plugin.common.MethodChannel;
import io.flutter.view.FlutterView;

public class Channel {

    public static void getChannel(FlutterView  flutterView){

        MethodChannel channel = new MethodChannel(flutterView, "foo");

        channel.setMethodCallHandler((methodCall, result) -> {
            if (methodCall.method.equals("bar")) {
                result.success("success, " + methodCall.arguments);
            }
        });

        channel.invokeMethod("bar", "message", new MethodChannel.Result() {
            @Override
            public void success(Object result) {
                // 发送成功时回调
            }

            @Override
            public void error(String errorCode, String errorMessage, Object errorDetails) {
                 // 发送失败时回调
            }

            @Override
            public void notImplemented() {
                // 如果该通道在Flutter端未实现，会回调这里
            }
        });



    }

}
