package com.sc.study.aware;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author yingqi
 * @version 1.0
 * @date 2020-11-17 18:18
 * @desc
 */
public class GetTest {

    public static void main(String[] args) {
        List<Integer> shopIdList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            shopIdList.add(i);
        }
        Set<Integer> shopIdSet = new HashSet<>();
        shopIdSet.add(5);
        shopIdSet.add(6);
        shopIdSet.add(7);
        shopIdSet.add(8);

        doChoose(shopIdList, 5, shopIdSet);

    }

    private static void doChoose(List<Integer> shopIdList, Integer num, Set<Integer> shopIdSet) {

        List<Integer> target = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        List<Integer> chooseShop = new ArrayList<>();
        for (int i = 0; i < shopIdList.size(); i++) {
            if (!shopIdSet.contains(shopIdList.get(i))) {
                target.add(shopIdList.get(i));

            }

        }
        Collections.shuffle(target);
        int currentSize = target.size();
        if (currentSize <= num) {
            num = currentSize;
        }
        for (int i = 0; i < num; i++) {
            result.add(target.get(i));
        }

        System.out.println(result);

        System.out.println(12%3);
        System.out.println(12/3);
        System.out.println(12%5);
        System.out.println(12/5);

    }
}
