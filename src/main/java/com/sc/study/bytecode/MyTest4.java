package com.sc.study.bytecode;

/**
 * @author yingqi
 * @version 1.0
 * @date 2020-12-05 10:59
 * @desc
 */
public class MyTest4 {
    public void test(Grandpa grandpa) {
        System.out.println("Grandpa");
    }

    public void test(Father father) {
        System.out.println("Father");
    }

    public void test(Son son) {
        System.out.println("Son");
    }

    public static void main(String[] args) {
        Grandpa g1 = new Father();
        Grandpa g2 = new Son();
        MyTest4 myTest = new MyTest4();
        myTest.test(g1);
        myTest.test(g2);
    }

}

class Grandpa {

}

class Father extends Grandpa {

}

class Son extends Father {

}