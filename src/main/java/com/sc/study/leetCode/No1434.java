package com.sc.study.leetCode;

import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/4/28 4:07 下午
 * @desc 总共有 n个人和 40 种不同的帽子，帽子编号从 1 到 40 。
 * <p>
 * 给你一个整数列表的列表hats，其中hats[i]是第 i个人所有喜欢帽子的列表。
 * <p>
 * 请你给每个人安排一顶他喜欢的帽子，确保每个人戴的帽子跟别人都不一样，并返回方案数。
 * <p>
 * 由于答案可能很大，请返回它对10^9 + 7取余后的结果。
 */
public class No1434 {

    /**
     * 示例 1：
     * <p>
     * 输入：hats = [[3,4],[4,5],[5]]
     * 输出：1
     * 解释：给定条件下只有一种方法选择帽子。
     * 第一个人选择帽子 3，第二个人选择帽子 4，最后一个人选择帽子 5。
     * 示例 2：
     * <p>
     * 输入：hats = [[3,5,1],[3,5]]
     * 输出：4
     * 解释：总共有 4 种安排帽子的方法：
     * (3,5)，(5,3)，(1,3) 和 (1,5)
     * 示例 3：
     * <p>
     * 输入：hats = [[1,2,3,4],[1,2,3,4],[1,2,3,4],[1,2,3,4]]
     * 输出：24
     * 解释：每个人都可以从编号为 1 到 4 的帽子中选。
     * (1,2,3,4) 4 个帽子的排列方案数为 24 。
     * 示例 4：
     * <p>
     * 输入：hats = [[1,2,3],[2,3,5,6],[1,3,7,9],[1,8,9],[2,5,7]]
     * 输出：111
     * <p>
     * <p>
     * 提示：
     * <p>
     * n == hats.length
     * 1 <= n <= 10
     * 1 <= hats[i].length <= 40
     * 1 <= hats[i][j] <= 40
     * hats[i]包含一个数字互不相同的整数列表。
     * tip: 一看就知道是个动态规划的题
     *
     * @param hats
     * @return
     */
    public int numberWays(List<List<Integer>> hats) {
        if (null == hats || CollectionUtils.isEmpty(hats)) {
            return 0;
        }
        return 0;
    }


}
