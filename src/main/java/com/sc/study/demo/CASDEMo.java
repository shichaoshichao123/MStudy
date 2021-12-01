package com.sc.study.demo;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/9/29 7:57 下午
 * @desc
 */
public class CASDEMo {

    public static void main(String[] args) {
        boolean flag = true;
        boolean flag2 = true;
        if(flag){
            flag2 = false;
            System.out.println(1);
        }else if(!flag2){
            System.out.println("2");
        }
    }
}
