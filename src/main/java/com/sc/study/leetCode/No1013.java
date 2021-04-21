package com.sc.study.leetCode;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/4/16 1:32 下午
 * @desc 给你一个整数数组A，只有可以将其划分为三个和相等的非空部分时才返回true，否则返回 false。
 * <p>
 * 形式上，如果可以找出索引i+1 < j且满足A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1]就可以将数组三等分。
 */
public class No1013 {

    public static void main(String[] args) {
//        System.out.println(canThreePartsEqualSum(new int[]{0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1}));
//        System.out.println(canThreePartsEqualSum(new int[]{0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1}));
//        System.out.println(canThreePartsEqualSum(new int[]{3, 3, 6, 5, -2, 2, 5, 1, -9, 4}));
        System.out.println(canThreePartsEqualSum(new int[]{0, 0, 0, 0}));

    }

    /**
     * 示例 1：
     * <p>
     * 输入：[0,2,1,-6,6,-7,9,1,2,0,1]
     * 输出：true
     * 解释：0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
     * 示例 2：
     * <p>
     * 输入：[0,2,1,-6,6,7,9,-1,2,0,1]
     * 输出：false
     * 示例 3：
     * <p>
     * 输入：[3,3,6,5,-2,2,5,1,-9,4]
     * 输出：true
     * 解释：3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
     *
     * @param arr
     * @return
     */
    public static boolean canThreePartsEqualSum(int[] arr) {
        if (null == arr) {
            return false;
        }
        //判断总和十分能被3整除
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        if (sum % 3 != 0) {
            return false;
        }
        int target = sum / 3;
        int leftIndex = 0;
        int rightIndex = arr.length - 1;
        boolean leftIsExists = false;
        boolean rightIsExists = false;
        //左右两指针，前后向中间便利，求得是否有两个1/3的指并且不重合
        int temp = 0;
        for (int i = leftIndex; i < arr.length; i++) {
            temp += arr[i];
            if (target == temp) {
                temp = 0;
                leftIsExists = true;
                break;
            }
            leftIndex++;
        }
        for (int i = rightIndex; i > leftIndex+1; i--) {
            temp += arr[i];
            if (target == temp) {
                rightIsExists = true;
                break;
            }
            rightIndex--;
        }
        return leftIsExists && rightIsExists;
    }
}
