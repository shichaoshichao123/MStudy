package com.sc.study.suanfa.tree;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/3/31 8:21 下午
 * @desc 字典书
 */
public class Trie {

    public static void main(String[] args) {
        Trie myTree = new Trie();
        myTree.addWord("shi");
        myTree.addWord("sho");
        System.out.println(myTree.searchWord("shi"));
        System.out.println(myTree.searchWord("sh"));
        System.out.println(myTree.searchWordByPrefix("shi"));
        System.out.println(myTree.searchWordByPrefix("sh"));
        System.out.println("end");

    }

    /**
     * 字典树的跟节点
     */
    private TrieNode root;

    public Trie() {
        this.root = new TrieNode(null);
    }

    /**
     * 往字典树内添加单词
     *
     * @param word
     */
    public void addWord(String word) {
        if (StringUtils.isEmpty(word)) {
            return;
        }
        TrieNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            List<TrieNode> children = currentNode.getChildrens();
            TrieNode target = nodeInChildren(word.charAt(i), children);
            TrieNode currentNewNode = new TrieNode(word.charAt(i));
            if (null == target) {
                if (i == word.length() - 1) {
                    currentNewNode.setWord(true);
                }
                children.add(currentNewNode);
                target = currentNewNode;
            }
            currentNode = target;
        }
        currentNode.setWord(true);

    }

    /**
     * 在字典树内查询指定的单词是否存在
     *
     * @param word
     * @return
     */
    public boolean searchWord(String word) {
        if (StringUtils.isEmpty(word)) {
            return true;
        }
        TrieNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            List<TrieNode> children = currentNode.getChildrens();
            TrieNode target = nodeInChildren(word.charAt(i), children);
            if (null == target) {
                return false;
            }
            currentNode = target;
        }
        return currentNode.isWord();
    }

    /**
     * 在字典书内查询是否有以自定单词开头的单词
     *
     * @param prefix
     * @return
     */
    public boolean searchWordByPrefix(String prefix) {
        if (StringUtils.isEmpty(prefix)) {
            return true;
        }
        TrieNode currentNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            List<TrieNode> children = currentNode.getChildrens();
            TrieNode target = nodeInChildren(prefix.charAt(i), children);
            if (null == target) {
                return false;
            }
            currentNode = target;
        }
        return true;
    }

    /**
     * 校验是否有指定值的子节点
     *
     * @param character
     * @param children
     * @return
     */
    private TrieNode nodeInChildren(Character character, List<TrieNode> children) {
        if (CollectionUtils.isEmpty(children)) {
            return null;
        }
        for (TrieNode child : children) {
            if (character.equals(child.getValue())) {
                return child;
            }
        }
        return null;
    }

}
