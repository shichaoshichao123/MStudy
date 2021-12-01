package com.sc.study.jiuzhang.recursive;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/11/16 5:34 下午
 * @desc
 */
public class RecursiveDemo {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[] origin = new int[]{1, 2};
//        System.out.println(fibonacci(4001));
        //1489622139
//        System.out.println(fibonacciByDp(4001));
//        System.out.println(findPosition(origin, 2));
//        System.out.println(findPositionByRecursive(origin, 1111111));
        System.out.println(mySqrt(9));
        System.out.println(process(9, 0, 9));
        System.out.println("花费时间:" + (System.currentTimeMillis() - start));
    }

    /**
     * 递归求斐波那契数
     *
     * @param n
     * @return
     */
    public static int fibonacci(int n) {
        if (n <= 2) {
            return n - 1;
        }
        return fibonacci(n - 2) + fibonacci(n - 1);
    }


    /**
     * 动态规划的方式求解斐波那契
     *
     * @param n
     * @return
     */
    public static int fibonacciByDp(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 0;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 使用普通二分法查询目标元素所在位置
     *
     * @param nums
     * @param target
     * @return
     */
    public static int findPosition(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 通过递归方式实现二分查找，确定目标元素所在位置
     *
     * @param nums
     * @param target
     * @return
     */
    public static int findPositionByRecursive(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            return -1;
        }
        return doFindPositionByRecursive(nums, 0, nums.length - 1, target);
    }

    /**
     * 具体的递归逻辑（减小范围）
     *
     * @param nums
     * @param start
     * @param end
     * @param target
     * @return
     */
    private static int doFindPositionByRecursive(int[] nums, int start, int end, int target) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return doFindPositionByRecursive(nums, mid + 1, end, target);
        } else {
            return doFindPositionByRecursive(nums, start, mid - 1, target);
        }
    }

    /**
     * 开根号
     *
     * @param n
     * @return
     */
    public static double mySqrt(double n) {
        double left = 0.0;
        double right = n;
        double mid = (right + left) / 2;
        while (mid * mid - n >= 0.001 || n - mid * mid >= 0.001) {
            if (mid * mid > n) {
                right = mid;
            } else if (mid * mid < n) {
                left = mid;
            } else {
                return mid;
            }
            mid = (left + right) / 2;
        }
        return mid;
    }

    public static double process(double number, double min, double max) {
        double mid = min + (max - min) / 2;
        double result = mid * mid;

        //设置精度为0.001
        if (Math.abs(result - number) <= 0.001) {
            return mid;
        }
        if (result > number) {
            max = mid;
        } else {
            min = mid;
        }
        //递归调用
        return process(number, min, max);
    }

}
