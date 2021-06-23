package com.sc.study.leetCode;

import java.util.*;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/6/23 5:08 下午
 * @desc 如果字符串 s 中 不存在 两个不同字符 频次 相同的情况，就称 s 是 优质字符串 。
 * <p>
 * 给你一个字符串 s，返回使 s 成为 优质字符串 需要删除的 最小 字符数。
 * <p>
 * 字符串中字符的 频次 是该字符在字符串中的出现次数。例如，在字符串 "aab" 中，'a' 的频次是 2，而 'b' 的频次是 1 。
 */
public class No1647 {
    /**
     * 示例 1：
     * <p>
     * 输入：s = "aab"
     * 输出：0
     * 解释：s 已经是优质字符串。
     * 示例 2：
     * <p>
     * 输入：s = "aaabbbcc"
     * 输出：2
     * 解释：可以删除两个 'b' , 得到优质字符串 "aaabcc" 。
     * 另一种方式是删除一个 'b' 和一个 'c' ，得到优质字符串 "aaabbc" 。
     * 示例 3：
     * <p>
     * 输入：s = "ceabaacb"
     * 输出：2
     * 解释：可以删除两个 'c' 得到优质字符串 "eabaab" 。
     * 注意，只需要关注结果字符串中仍然存在的字符。（即，频次为 0 的字符会忽略不计。）
     * <p>
     * 提示：
     * <p>
     * 1 <= s.length <= 105
     * s 仅含小写英文字母
     *
     * @param s
     * @return
     */
    public int minDeletions(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        Map<Character, Integer> characterTimes = new HashMap<>(8);
        for (int i = 0; i < s.length(); i++) {
            Character current = s.charAt(i);
            characterTimes.merge(current, 1, Integer::sum);
        }
        Set<Map.Entry<Character, Integer>> entrySet = characterTimes.entrySet();
        List<Integer> usedCount = new ArrayList<>();
        List<Integer> exitCount = new ArrayList<>();
        List<Map.Entry<Character, Integer>> entryList = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : entrySet) {
            entryList.add(entry);
            exitCount.add(entry.getValue());
        }
        int result = 0;
        for (Map.Entry<Character, Integer> current : entryList) {
            result += needDeleteNum(exitCount, usedCount, current.getValue());
        }
        return result;
    }

    /**
     * 获取需要进行删除的个数
     *
     * @param exitCount
     * @param usedCount
     * @param currentNum
     * @return
     */
    private int needDeleteNum(List<Integer> exitCount, List<Integer> usedCount, int currentNum) {
        if (!usedCount.contains(currentNum)) {
            usedCount.add(currentNum);
            return 0;
        }
        int exit = currentNum;
        for (int i = currentNum - 1; i > 0; i--) {
            if (!exitCount.contains(i)) {
                exit = exit - i;
                exitCount.add(i);
                break;
            }
        }
        return exit;
    }

    public static void main(String[] args) {
        No1647 no1647 = new No1647();
        System.out.println(no1647.minDeletions("aab"));
        System.out.println(no1647.minDeletions("aaabbbcc"));
        System.out.println(no1647.minDeletions("ceabaacb"));
        System.out.println(no1647.minDeletions("accdcdadddbaadbc"));
    }
}
