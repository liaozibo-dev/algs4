package com.liaozibo.algs4.string.trie;

import com.liaozibo.algs4.base.Queue;

/**
 * 基于单词查找树实现的符号表（ST: Symbol Table）
 * */
public class TrieST<Value> {
    private static final int R = 256; // ASCII 字母表
    private Node root;

    private static class Node {
        private Object value;
        private Node[] next = new Node[R];
    }

    public Value get(String key) {
        Node node = get(root, key, 0);
        if (node == null) return null;
        return (Value) node.value;
    }

    private Node get(Node node, String key, int d) {
        // 查找未命中
        if (node == null) {
            return null;
        }
        // 查找命中
        if (d == key.length()) {
            return node;
        }
        // 继续向下查找
        return get(node.next[key.charAt(d)], key, d + 1);
    }

    public void put(String key, Value value) {
        root = put(root, key, value, 0);
    }

    private Node put(Node node, String key, Value value, int d) {
        // 插入时过程如果结点不存在，需要创建结点
        if (node == null) {
            node = new Node();
        }
        // 查找结束
        if (d == key.length()) {
            node.value = value;
            return node;
        }
        // 继续向下查找
        char c = key.charAt(d);
        node.next[c] = put(node.next[c], key, value, d + 1);
        return  node;
    }

    public int size() {
        return size(root);
    }

    // 延迟实现
    // 可以帮助理解树的结构，但在实际中应该避免，因为存在性能问题
    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        int count = 0;
        if (node.value != null) count++;
        for (char c = 0; c < R; c++) {
            count += size(node.next[c]);
        }
        return count;
    }

    // 获取所有的键
    public Iterable<String> keys() {
        Queue<String> queue = new Queue<>();
        collect(root, "", queue);
        return queue;
    }

    // 获取所有以 prefix 为前缀的键
    public Iterable<String> keysPrefixWith(String prefix) {
        Queue<String> queue = new Queue<>();
        collect(get(root, prefix, 0), prefix, queue);
        return queue;
    }

    private void collect(Node node, String key, Queue<String> queue) {
        if (node == null) {
            return;
        }
        if (node.value != null) {
            queue.add(key);
        }
        for (char c = 0; c < R; c++) {
            collect(node.next[c], key + c, queue);
        }
    }

    // 模式匹配
    // . 可以任意一个字符
    public Iterable<String> keysThatMatch(String pattern) {
        Queue<String> queue = new Queue<>();
        collect(root, pattern, "", queue);
        return queue;
    }

    private void collect(Node node, String pattern, String key, Queue<String> queue) {
        if (node == null) {
            return;
        }
        int d = key.length();
        if (d == pattern.length()) {
            if (node.value != null) {
                queue.add(key);
            }
            return;
        }
        char next = pattern.charAt(d);
        for (char c = 0; c < R; c++) {
            if (next == '.' || next == c) {
                collect(node.next[c], pattern, key + c, queue);
            }
        }
    }

    // 获取一个最长的键并且该键是 s 的前缀
    public String longestPrefixOf(String s) {
        int len = search(root, s, 0, 0);
        return s.substring(0, len);
    }

    private int search(Node node, String s, int d, int len) {
        if (node == null || d == s.length()) {
            return len;
        }
        if (node.value != null) {
            len = d;
        }
        return search(node.next[s.charAt(d)], s, d + 1, len);
    }

}
