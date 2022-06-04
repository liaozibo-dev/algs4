package com.liaozibo.algs4.string.substring.search;

/**
 * Boyer Moore 算法
 * */
public class BoyerMoore {
    private static final int R = 256; // 字母表
    private int[] right; // 记录字符集中的字符在模式字符串中出现的最后位置，不存在则是 -1
    private String pattern;

    public BoyerMoore(String pattern) {
        right = new int[R];
        this.pattern = pattern;
        int M = pattern.length();
        for (int i = 0; i < R; i++) {
            right[i] = -1;
        }
        for (int i = 0; i < M; i++) {
            right[pattern.charAt(i)] = i;
        }
    }

    public int search(String text) {
        int M = pattern.length();
        int N = text.length();
        int skip;
        for (int i = 0; i <= N - M; i += skip) {
            skip = 0;
            for (int j = M - 1; j >= 0; j--) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    skip = j - right[text.charAt(i + j)];
                    if (skip < 1) skip = 1; // 至少需要向右移动一个位置
                    break;
                }
            }
            if (skip == 0) {
                return i;
            }
        }
        return -1;
    }
}
