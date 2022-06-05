package com.liaozibo.algs4.search;

import java.awt.image.Kernel;

/**
 * 红黑二分查找树
 * */
public class RedBlackBST<K extends Comparable<K>, V> {
    private Node root;

    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private class Node {
        private K key;
        private V value;
        private boolean color; // 指向该结点连接的颜色
        private int N; // 结点数量
        private Node left;
        private Node right;

        public Node(K key, V value, int N, boolean color) {
            this.key = key;
            this.value = value;
            this.color = color;
        }
    }

    private boolean isRed(Node node) {
        if (node == null) return BLACK;
        return node.color;
    }

    // 传入指向父结点连接
    // 返回父节点，并在调用函数重置指向父结点的连接
    // 左旋转：将红色右连接变成红色左连接
    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        x.left.color = RED;
        x.N = h.N;
        h.N = size(h);
        return x;
    }

    // 右旋转
    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        x.right.color = RED;
        x.N = h.N;
        h.N = size(h);
        return x;
    }

    // 颜色变换
    // 左右链表由红变黑，父连接变红
    private void flipColors(Node h) {
        h.left.color = BLACK;
        h.right.color = BLACK;
        h.color = RED;
    }

    // 插入算法
    public void put(K key, V value) {
        root = put(root, key, value);
        root.color = BLACK;
    }

    private Node put(Node node, K key, V value) {
        if (node == null) {
            return new Node(key, value, 1, RED);
        }

        int cmp = node.key.compareTo(key);
        if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else if (cmp > 0){
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }

        if (!isRed(node.left) && isRed(node.right)) node = rotateLeft(node);
        if (isRed(node.left) && isRed(node.left.left)) node = rotateRight(node);
        if (isRed(node.left) && isRed(node.right)) flipColors(node);

        node.N = size(node);
        return node;
    }

    public V get(K key) {
        Node node = get(root, key);
        return node == null ? null : node.value;
    }

    private Node get(Node node, K key) {
        if (node == null) {
            return null;
        }
        int cmp = node.key.compareTo(key);
        if (cmp < 0) {
            return get(node.left, key);
        } else if (cmp > 0) {
            return get(node.right, key);
        } else {
            return node;
        }
    }

    public int size() {
        if (root == null) {
            return 0;
        }
        return root.N;
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return size(node.left) + size(node.right) + 1;
    }
}
