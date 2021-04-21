package com.sc.study.jvm;

/**
 * @author yingqi
 * @version 1.0
 * @date 2020-11-23 21:49
 * @desc 用于说明数组类型的类加载器与其包含的元素是一致的
 */
public class Demo {

    public static void main(String[] args){
        //与String类型一致是根类型加载 在hotSpotVm中是用null表示
        String[] strings = new String[]{};
        System.out.println(strings.getClass().getClassLoader());
        System.out.println("-----");
        //与Demo类型的加载器一致，是系统应用加载
        Demo[] demos = new Demo[5];
        System.out.println(demos.getClass().getClassLoader());
        System.out.println("-----");
        //基础类型的类加载器是null
        int[] ints = new int[5];
        try {
            System.out.println(ints.getClass().getClassLoader());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
