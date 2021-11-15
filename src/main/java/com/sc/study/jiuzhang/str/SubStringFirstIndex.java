package com.sc.study.jiuzhang.str;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/11/10 11:00 上午
 * @desc 求某个子串首次出现在字符串中的位置
 */
public class SubStringFirstIndex {

    public static void main(String[] args) {
        System.out.println(findFirstIndex("1234567878990", "78"));
        System.out.println(findFirstIndexByHash("1234567878990", "78"));
    }

    /**
     * 暴力遍历求解
     * n平方的时间复杂度
     *
     * @param origin
     * @param target
     * @return
     */
    public static int findFirstIndex(String origin, String target) {
        if (null == origin || "".equals(origin) || null == target || "".equals(target)) {
            return -1;
        }
        int originLen = origin.length();
        int targetLen = target.length();
        //遍历母串的开始为止，注意最少要保留子串相同的长度
        for (int i = 0; i < originLen - targetLen + 1; i++) {
            boolean currentFlag = true;
            for (int j = 0; j < targetLen; j++) {
                if (origin.charAt(i + j) != target.charAt(j)) {
                    currentFlag = false;
                    break;
                }
            }
            if (currentFlag) {
                return i;
            }
        }
        return 0;
    }

    /**
     * 通过Hsah的方式去查找（Rabin-Karp）
     * 思想：通过计算子串hash值，如果不等坑定是不符合，如果相等再匹配内部字符串是否相同,算法效率取决于hash算法
     * 具体Hash算法使用静置转换的方式
     *
     * @param origin
     * @param target
     * @return
     */
    private static final Integer BASE = 1000000;

    public static int findFirstIndexByHash(String origin, String target) {
        if (null == origin || null == target) {
            return -1;
        }
        if ("".equals(target)) {
            return 0;
        }
        int targetLen = target.length();
        //求出power值用于减去某个字符后求hash
        int power = 1;
        for (int i = 0; i < targetLen; i++) {
            power = (i * 31) % BASE;
        }
        //求出目标串的hash值
        int targetHash = 0;
        for (int i = 0; i < targetLen; i++) {
            targetHash = (targetHash * 31 + target.charAt(i)) % BASE;
        }
        //进行遍历查找
        int currentHashCode = 0;
        for (int i = 0; i < origin.length(); i++) {
            currentHashCode = (currentHashCode * 31 + origin.charAt(i)) % BASE;
            //遍历的字符长度还没达到目标串的长度，继续遍历
            if (i < targetLen - 1) {
                continue;
            }
            //遍历长度已经超过了目标串的长度，需要对前面的字符进行hash减操作
            if (i >= targetLen) {
                currentHashCode = currentHashCode - (origin.charAt(i - targetLen) * power) % BASE;
                if (currentHashCode < 0) {
                    currentHashCode += BASE;
                }
            }
            //如果遍历到hash相同，进行字符确认判断
            if (currentHashCode == targetHash) {
                for (int j = 0; j < targetLen; j++) {
                    if (origin.charAt(i - targetLen + 1) != target.charAt(j)) {
                        break;
                    }
                }
                return i - targetLen;
            }
        }
        return -1;
    }


}
