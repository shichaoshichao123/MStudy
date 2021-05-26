package com.sc.study.leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/5/26 3:27 下午
 * @desc 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
 */
public class No763 {

    /**
     * 示例：
     * <p>
     * 输入：S = "ababcbacadefegdehijhklij"
     * 输出：[9,7,8]
     * 解释：
     * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
     * 每个字母最多出现在一个片段中。
     * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
     * <p>
     * 提示：
     * <p>
     * S的长度在[1, 500]之间。
     * S只包含小写字母 'a' 到 'z' 。
     *
     * @param s
     * @return
     */
    public List<Integer> partitionLabels(String s) {
        if (s.isEmpty()) {
            return Collections.emptyList();
        }
        //使用双指针碰撞的方式
        List<Integer> result = new ArrayList<>();
        int start = 0;
        while (start != s.length()) {
            int end;
            char current = s.charAt(start);
            end = s.lastIndexOf(current);
            if (end == start) {
                result.add(1);
            } else {
                for (int j = start + 1; j < end; j++) {
                    char current1 = s.charAt(j);
                    int subLast = s.lastIndexOf(current1);
                    if (subLast > end) {
                        end = subLast;
                    }
                }
                result.add(end - start + 1);
            }
            start = end + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        No763 no763 = new No763();
        System.out.println(no763.partitionLabels("ababcbacadefegdehijhklij"));
    }
}
