package com.sc.study.jvm;

/**
 * @author yingqi
 * @version 1.0
 * @date 2020-11-23 21:15
 * @desc
 * 该例子说明：使用类加载器加载某个类并不会触发类的初始化，也就是说这种方式并不属于对一个类的主动使用，
 *相反如果使用反射的方式去获取一个类对象，就会触发类的初始化，所以反射属于对类的主动使用
 */
public class ClassLoaderDemo3 {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        Class<?> clazz = classLoader.loadClass("com.sc.study.jvm.TG");
        System.out.println(clazz);
        System.out.println("---------");
        Class<?> clazz1 = Class.forName("com.sc.study.jvm.TG");
        System.out.println(clazz1);
    }

}

class TG {
    static {
        System.out.println("class TG init");
    }
}
