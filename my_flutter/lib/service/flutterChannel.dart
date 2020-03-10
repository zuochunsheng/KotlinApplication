

import 'package:flutter/services.dart';



Future<void> getChannel() async {
  const channel = MethodChannel('foo');

  final String greeting = await channel.invokeMethod('bar', 'world');
  print(greeting);

  channel.setMethodCallHandler((MethodCall call) async {
    switch (call.method) {
      case 'bar':
        return 'Hello, ${call.arguments}';
      case 'baz':
        throw PlatformException(code: '400', message: 'This is bad');
      default:
        throw MissingPluginException();
    }
  });



}

