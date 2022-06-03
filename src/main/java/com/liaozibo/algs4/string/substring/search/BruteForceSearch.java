package com.liaozibo.algs4.string.substring.search;


public class BruteForceSearch {
    /**
     * 暴力查找子字符串
     * */
    public static int search(String pattern, String text) {
        int M = pattern.length();
        int N = text.length();
        int i, j;
        for (i = 0, j = 0; i <= N - M && j < M; i++) {
            if (text.charAt(i) == pattern.charAt(j)) {
                j++;
            } else {
                // 不匹配时
                i = i - j; // 回退指针 i
                j = 0; // 重置指针 j
            }
        }
        if (j == M) {
            return i - j;
        } else {
            return -1;
        }
    }
}
