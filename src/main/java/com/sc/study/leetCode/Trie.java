package com.sc.study.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/4/14 2:05 下午
 * @desc
 */
public class Trie {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        // 返回 True
        System.out.println(trie.search("apple"));
        // 返回 False
        System.out.println(trie.search("app"));
        // 返回 True
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        // 返回 True
        System.out.println(trie.search("app"));

    }

    private Node root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new Node(null);
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        if (null != word) {
            Node current = root;
            for (int i = 0; i < word.length(); i++) {
                Node option = getTargetNodeFromChildren(current, word.charAt(i));
                if (null == option) {
                    option = new Node(word.charAt(i));
                    current.getChildrens().add(option);
                }
                current = option;
            }
            current.isWord = true;
        }
    }

    /**
     * 从指定节点的自节点中获取指定值的子节点，没有则返回null
     *
     * @param node
     * @param target
     * @return
     */
    private static Node getTargetNodeFromChildren(Node node, Character target) {
        if (null == node || null == target) {
            return null;
        }
        List<Node> children = node.getChildrens();
        for (Node child : children) {
            if (child.getValue().equals(target)) {
                return child;
            }
        }
        return null;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        if (null == word) {
            return true;
        }
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            Node option = getTargetNodeFromChildren(current, word.charAt(i));
            if (null == option) {
                return false;
            }
            current = option;
        }
        return current.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        if (null == prefix) {
            return true;
        }
        Node current = root;
        for (int i = 0; i < prefix.length(); i++) {
            Node option = getTargetNodeFromChildren(current, prefix.charAt(i));
            if (null == option) {
                return false;
            }
            current = option;
        }
        return true;
    }


    static class Node {
        private Character value;
        private List<Node> childrens;
        private Boolean isWord;

        public Node(Character value) {
            this.value = value;
            this.childrens = new ArrayList<Node>();
            this.isWord = false;
        }

        public Character getValue() {
            return value;
        }

        public void setValue(Character value) {
            this.value = value;
        }

        public List<Node> getChildrens() {
            return childrens;
        }

        public void setChildrens(List<Node> childrens) {
            this.childrens = childrens;
        }

        public Boolean getWord() {
            return isWord;
        }

        public void setWord(Boolean word) {
            isWord = word;
        }
    }
}
