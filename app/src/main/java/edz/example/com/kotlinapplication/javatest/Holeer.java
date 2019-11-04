package edz.example.com.kotlinapplication.javatest;

import edz.example.com.kotlinapplication.netchapter.Utils;

/**
 * @author： zcs
 * @time：2019/10/31 on 19:54
 * @description：
 */
public  class Holeer {

    public static final InnerHoleer INSTANCE;

    static {
        InnerHoleer innerHoleer = new InnerHoleer();
        INSTANCE = innerHoleer;
    }


    public static class InnerHoleer {
        public static String  c = "c";
        public void a(){
            String c = InnerHoleer.c;
            InnerHoleer.b();
        }

        public static void b(){
            String c = InnerHoleer.c;


        }
    }


    public static String connect(String... strings) {
        StringBuilder sb = new StringBuilder();
        for (String string : strings) {
            sb.append(string).append(",");
        }
        return sb.toString();
    }
    public static boolean is(String value, String value1) {
        return value.equals(value1);
    }

}
