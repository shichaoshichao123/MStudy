package com.sc.study.memory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yingqi
 * @version 1.0
 * @date 2020-12-07 21:02
 * @desc
 */
public class Demo {
    public static void main(String[] args) {
        List<Demo> demoList = new ArrayList<>();
        for (; ; ) {
            demoList.add(new Demo());
            System.gc();

        }

    }

}
