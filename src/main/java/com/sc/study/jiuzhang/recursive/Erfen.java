package com.sc.study.jiuzhang.recursive;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/11/17 12:01 下午
 * @desc 二分法学习
 */
public class Erfen {
    public static void main(String[] args) {
        int[] origin = new int[]{1, 2, 3, 4, 4, 4, 4, 4, 4, 4, 4, 5, 6, 7, 8, 9, 11};
        System.out.println(findPosition(origin, 3));
        System.out.println(getFirstPosition(origin, 3));
        System.out.println(getLastPosition(origin, 3));
        System.out.println(getLastPosition(origin, 3) - getFirstPosition(origin, 3) + 1);
        int[] result = findNearTarget(origin, 7, 3);
        System.out.println(result);

        int[] origin2 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 4, 3, 2, 1};
        System.out.println(getMaxNum(origin2));

        int[] origin3 = new int[]{5, 6, 7, 8, 9, 1, 2, 3, 4};
        System.out.println(getTargetMinIndex(origin3));
        System.out.println(getTargetMinIndex(origin3, 91));
        int[] origin4 = new int[]{2, 3, 4, 2, 7, 1};
        System.out.println(getAnyTopFromNoSortArray(origin4));
        int[] origin5 = new int[]{1,2, 3, 4, 7,9};
        System.out.println(erfenSearch(origin5, 9));

    }

    public static int erfenSearch(int[] origin, Integer target) {
        if (null == origin || null == target) {
            return -1;
        }
        int left = 0;
        int right = origin.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (origin[mid] < target) {
                left = mid;
            } else if (origin[mid] > target) {
                right = mid;
            } else {
                return mid;
            }
        }
        if (origin[left] == target) {
            return left;
        }
        if (origin[right] == target) {
            return right;
        }
        return -1;
    }

    /**
     * 获取指定元素在数组中最后一次出现的位置
     *
     * @param origin
     * @param target
     * @return
     */
    public static int getLastPosition(int[] origin, int target) {
        if (null == origin || origin.length == 0) {
            return -1;
        }
        int left = 0;
        int right = origin.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (origin[mid] == target) {
                //注意更新的左指针要包含当前的mid位置，防止后门没有同值的元素
                left = mid;
            } else if (origin[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        //注意这里是判断最后一个位置所以先判断right
        if (origin[right] == target) {
            return right;
        }
        if (origin[left] == target) {
            return left;
        }
        return -1;
    }

    /**
     * 获取指定元素在数组中第一次出现的位置
     *
     * @param origin
     * @param target
     * @return
     */
    public static int getFirstPosition(int[] origin, int target) {
        if (null == origin || origin.length == 0) {
            return -1;
        }
        int left = 0;
        int right = origin.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (origin[mid] == target) {
                //注意更新的右指针要包含当前的mid位置，防止后门没有同值的元素
                right = mid;
            } else if (origin[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        //注意这里是判断最后一个位置所以先判断left
        if (origin[left] == target) {
            return left;
        }
        if (origin[right] == target) {
            return right;
        }
        return -1;
    }

    /**
     * 获取指定元素在数组中是否存在（不需要考虑重复或者位置）
     *
     * @param origin
     * @param target
     * @return
     */
    public static int findPosition(int[] origin, int target) {
        if (null == origin || origin.length == 0) {
            return -1;
        }
        int left = 0;
        int right = origin.length - 1;
        //少比较一个防止死循环
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (origin[mid] == target) {
                return mid;
            } else if (origin[mid] < target) {
                left = mid;
            } else {
                right = target;
            }
        }
        //对最后两个元素进行比较
        if (origin[left] == target) {
            return left;
        }
        if (origin[right] == target) {
            return right;
        }
        return -1;
    }

    /**
     * 获取指定有序数组中最接近target的num个元素
     *
     * @param origin
     * @param target
     * @param num
     * @return
     */
    public static int[] findNearTarget(int[] origin, int target, int num) {
        //使用二分查找获取第一个小于等于target的索引
        int leftIndex = getFirstPosition(origin, target);
        int rightIndex = leftIndex + 1;
        //使用双向指针从定位到的位置去获取目标元素
        int[] result = new int[num];
        for (int i = 0; i < num; i++) {
            if (leftIsNearTarget(origin, target, leftIndex, rightIndex)) {
                result[i] = origin[leftIndex--];
            } else {
                result[i] = origin[rightIndex++];

            }
        }
        return result;
    }

    /**
     * 使用左边的第一个值（双指针比较）
     *
     * @param origin
     * @param target
     * @param leftIndex
     * @param rightIndex
     * @return
     */
    private static boolean leftIsNearTarget(int[] origin, int target, int leftIndex, int rightIndex) {
        if (leftIndex < 0) {
            return false;
        }
        if (rightIndex > origin.length - 1) {
            return true;
        }
        return target - origin[leftIndex] <= origin[rightIndex] - target;
    }

    /**
     * 从一个先增后减的数组中找到递增的最后一个元素（找山峰）
     * 可以通过二分查找的方式处理
     * 具体思路是判断mid与mid+1个元素的关系去进行二分剔除
     *
     * @param origin
     * @return
     */
    public static int getMaxNum(int[] origin) {
        if (null == origin || origin.length == 0) {
            return -1;
        }
        int left = 0;
        int right = origin.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (origin[mid] > origin[mid + 1]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (origin[left] > origin[right]) {
            return left;
        } else {
            return right;
        }
    }

    /**
     * 在一个两段递增的数组里找到第二段递增的起点也就是最小元素索引
     *
     * @param origin
     * @return
     */
    public static int getTargetMinIndex(int[] origin) {
        if (null == origin || origin.length == 0) {
            return -1;
        }
        int left = 0, right = origin.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (origin[mid] < origin[right]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (origin[left] < origin[right]) {
            return left;
        } else {
            return right;
        }
    }

    /**
     * 在一个两段递增的数组（无重复）里找目标元素的所在位置
     *
     * @param origin
     * @param target
     * @return
     */
    public static int getTargetMinIndex(int[] origin, int target) {
        if (null == origin || origin.length == 0) {
            return -1;
        }
        int left = 0, right = origin.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (origin[mid] < origin[right]) {
                //进行跟目标值比较的细化切分，省去一次二分
                if (origin[mid] <= target && target <= origin[right]) {
                    left = mid;
                } else {
                    right = mid;
                }
            } else {
                //进行跟目标值比较的细化切分，省去一次二分
                if (origin[mid] <= target && target <= origin[right]) {
                    right = mid;
                } else {
                    left = mid;
                }
            }
        }
        if (origin[left] == target) {
            return left;
        }
        if (origin[right] == target) {
            return right;
        }
        return -1;
    }

//    无序的数组内的二分查找

    /**
     * 从一个无序数组（波浪型）中查找任意一个山峰（递增后递减的临界值索引）
     *
     * @param origin
     * @return
     */
    public static int getAnyTopFromNoSortArray(int[] origin) {
        if (null == origin || origin.length == 0) {
            return -1;
        }
        int left = 0, right = origin.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (origin[mid] < origin[mid - 1]) {
                //舍弃右半边
                right = mid;
            } else if (origin[mid] > origin[mid - 1]) {
                //舍弃右半边
                left = mid;
            } else {
                //刚好处于某个顶峰
                return mid;
            }
        }
        if (origin[left] > origin[right]) {
            return left;
        } else {
            return right;
        }
    }


}
