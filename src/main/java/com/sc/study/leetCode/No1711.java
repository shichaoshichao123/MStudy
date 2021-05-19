package com.sc.study.leetCode;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/5/19 10:42 上午
 * @desc 大餐 是指 恰好包含两道不同餐品 的一餐，其美味程度之和等于 2 的幂。
 * <p>
 * 你可以搭配 任意 两道餐品做一顿大餐。
 * <p>
 * 给你一个整数数组 deliciousness ，其中 deliciousness[i] 是第 i 道餐品的美味程度，返回你可以用数组中的餐品做出的不同 大餐 的数量。结果需要对 109 + 7 取余。
 * <p>
 * 注意，只要餐品下标不同，就可以认为是不同的餐品，即便它们的美味程度相同。
 */
public class No1711 {
    /**
     * 示例 1：
     * <p>
     * 输入：deliciousness = [1,3,5,7,9]
     * 输出：4
     * 解释：大餐的美味程度组合为 (1,3) 、(1,7) 、(3,5) 和 (7,9) 。
     * 它们各自的美味程度之和分别为 4 、8 、8 和 16 ，都是 2 的幂。
     * 示例 2：
     * <p>
     * 输入：deliciousness = [1,1,1,3,3,3,7]
     * 输出：15
     * 解释：大餐的美味程度组合为 3 种 (1,1) ，9 种 (1,3) ，和 3 种 (1,7) 。
     * <p>
     * <p>
     * 提示：[]
     * <p>
     * 1 <= deliciousness.length <= 105
     * 0 <= deliciousness[i] <= 220
     *
     * @param deliciousness
     * @return
     */
    public int countPairs(int[] deliciousness) {
        int result = 0;
        for (int i = 0; i < deliciousness.length - 1; i++) {
            for (int j = i + 1; j < deliciousness.length; j++) {
                if ((deliciousness[i] + deliciousness[j])>0&&(deliciousness[i] + deliciousness[j] & (deliciousness[i] + deliciousness[j] - 1)) == 0) {
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        No1711 no1711 = new No1711();
        System.out.println(no1711.countPairs(new int[]{1, 3, 5, 7, 9}));
        System.out.println(no1711.countPairs(new int[]{1, 1, 1, 3, 3, 3, 7}));
        System.out.println(no1711.countPairs(new int[]{2160,1936,3,29,27,5,2503,1593,2,0,16,0,3860,28908,6,2,15,49,6246,1946,23,105,7996,196,0,2,55,457,5,3,924,7268,16,48,4,0,12,116,2628,1468}));
    }
}
