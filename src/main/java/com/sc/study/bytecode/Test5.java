package com.sc.study.bytecode;

/**
 * @author yingqi
 * @version 1.0
 * @date 2020-12-05 11:17
 * @desc
 */
public class Test5 {

    public static void main(String[] args) {
        Fluter banana = new Banana();
        Fluter apple = new Apple();
        banana.name();
        apple.name();
        banana = new Apple();
        banana.name();
    }
}

class Fluter {
    public void name() {
        System.out.println("Fluter");
    }
}

class Banana extends Fluter {
    @Override
    public void name() {
        System.out.println("Banana");
    }
}

class Apple extends Fluter {
    @Override
    public void name() {
        System.out.println("Apple");
    }
}
