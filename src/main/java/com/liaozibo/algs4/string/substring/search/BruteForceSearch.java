package com.liaozibo.algs4.string.substring.search;


public class BruteForceSearch {
    /**
     * 暴力查找子字符串
     * */
    public static int search(String pattern, String text) {
        int M = pattern.length();
        int N = text.length();
        for (int i = 0; i <= N - M; i++) {
            int j;
            for (j = 0; j < M; j++) {
                if (text.charAt(i+j) != pattern.charAt(j)) {
                    break;
                }
            }
            if (j == M) {
                return i; // 找到子字符串，返回其首字母位置
            }
        }
        return -1;
    }
}
