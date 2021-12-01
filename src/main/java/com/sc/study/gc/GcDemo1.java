package com.sc.study.gc;

/**
 * @author yingqi
 * @version 1.0
 * @date 2020-12-12 17:58
 * @desc GC例子
 */
public class GcDemo1 {

    public static void main(String[] args) {
        int size = 1024 * 1024;
        byte[] byteArray2 = new byte[4 * size];
        System.out.println("1------------");
        byte[] byteArray3 = new byte[4 * size];
        System.out.println("2------------");

        byte[] byteArray4 = new byte[4 * size];
        System.out.println("3------------");

        byte[] byteArray5 = new byte[2 * size];
        System.out.println("4------------");
        Boolean flag = null;
        if(!Boolean.TRUE.equals(flag)){
            System.out.println("isFalse");
        }
        if(flag){
            System.out.println("11111");
        }

        System.out.println("done");


    }

}
