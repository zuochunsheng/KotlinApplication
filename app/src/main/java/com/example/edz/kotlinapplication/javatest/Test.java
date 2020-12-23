package com.example.edz.kotlinapplication.javatest;


import com.example.edz.kotlinapplication.data.Persion;
import com.example.edz.kotlinapplication.data.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * @author： zcs
 * @time：2019/11/5 on 16:51
 * @description：
 */

// java默认不支持，在声明处泛型，不能让这个类，拥有权限模式
public class Test  {//<? extends T>

    private Persion persion  = new Persion();
    private Student student = new Student()

    public static void main(String... args){
       // ExtensionKt.empty("adbd");

        //SingleInstance.
        //SingleInstance.INSTANCE

       //java://  ? extends ,list集合 只能获取 ，不能修改
       List<? extends  Persion> list = new ArrayList<Student>();
       Persion p = list.get(0);

       //list.add(persion);//error
    }
   public static void test2 (String... args){
       //java:// ? supper ,list集合 不能获取 ，能修改
        List<? super Student> list = new ArrayList<Persion>();

        //Student student = list.get(0);//error
        list.add(student);
    }


}
