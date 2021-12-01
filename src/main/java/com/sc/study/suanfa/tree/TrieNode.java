package com.sc.study.suanfa.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/3/31 8:18 下午
 * @desc 字典树节点
 */
public class TrieNode {
    /**
     * 当前节点对应的字符
     */
    private Character value;
    /**
     * 当前节点对应的子节点集合
     */
    private List<TrieNode> childrens = new ArrayList<>();

    /**
     * 标识该节点是不是一个单词的结尾
     */
    private boolean isWord;

    public TrieNode(Character value) {
        this.value = value;
    }

    public Character getValue() {
        return value;
    }

    public void setValue(Character value) {
        this.value = value;
    }

    public List<TrieNode> getChildrens() {
        return childrens;
    }

    public void setChildrens(List<TrieNode> childrens) {
        this.childrens = childrens;
    }

    public boolean isWord() {
        return isWord;
    }

    public void setWord(boolean word) {
        isWord = word;
    }
}
