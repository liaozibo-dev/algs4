package com.liaozibo.algs4.string.huffman.coding;

/**
 * 哈夫曼树结点（单词查找树）
 * */
public class Node implements Comparable<Node> {
    private char c; // 叶子结点保存被编码的字符
    private int freq; // 字符在比特流出现的频率
    private Node left;
    private Node right;

    public Node(char c, int freq, Node left, Node right) {
        this.c = c;
        this.freq = freq;
        this.left = left;
        this.right = right;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    @Override
    public int compareTo(Node that) {
        return this.freq - that.freq;
    }

    public Node left() {
        return left;
    }

    public Node right() {
        return right;
    }

    public char c() {
        return c;
    }

    public int freq() {
        return freq;
    }
}
