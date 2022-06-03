package com.liaozibo.algs4.string.substring.search;

/**
 * KMP 算法
 * */
public class KMP {
    private static final int R = 256; // 字母表
    private int dfa[][]; // 确定有限状态自动机
    private int M;

    /**
     * 对模式字符串进行预处理，生成确定有限状态自动机 dfa
     * */
    public KMP(String pattern) {
        // 当匹配失败时，我们可以知道当前匹配的子串是 pattern[i-j, j]，接下来需要匹配的子串是从 pattern[i-j+1] 开始
        // 所以我们知道接下要放入自动机的字符，而将字符放入自动机又可以得到 j 的新值
        // 所以在生成 dfa 的同时也在将模式字符串输入到自动机中，以此更新 X 的值
        // dfa 的第一个索引表示的是输入的字符 c，第二个索引表示当前模式字符串的位置 j，值表示下一个状态（即需要将 j 重置到哪个位置）
        M = pattern.length();
        dfa = new int[R][M];
        // 初始化自动机的状态，第一个字符匹配成功进入下一个状态，否则保持不动
        dfa[pattern.charAt(0)][0] = 1;
        // 从这里开始一边生成自动机，一边使用自动机
        int X = 0; // 记录使用自动机的当前状态
        for (int j = 1; j < M; j++) { // 在生成自动机时，从第二个字符开始使用自动机
            for (int c = 0; c < R; c++) {
                dfa[c][j] = dfa[c][X]; // 枚举字符集，并将每个字符放入自动机
            }
            dfa[pattern.charAt(j)][j] = j + 1; // 匹配成功进入下一个状态
            X = dfa[pattern.charAt(j)][X]; // 将当前字符放入自动机，更新状态 X
        }
    }

    /**
     * 在文本中查找模式字符串
     * */
    public int search(String text) {
        int N = text.length();
        int i, j;
        for (i = 0, j = 0; i < N && j < M; i++) {
            j = dfa[text.charAt(i)][j];
        }
        if (j == M) {
            return i - j;
        } else {
            return -1;
        }
    }
}
