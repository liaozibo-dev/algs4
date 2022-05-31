package com.liaozibo.algs4.base;

import edu.princeton.cs.algs4.In;

/**
 * union-find 算法
 * * 初始化时所有的触点属于不同分量
 * * 每添加一条连接 p-q 时，将 p 连接到 q 所属的分量中（即 id[p] = id[q]），根触电 id[q] == q
 * */
public class UnionFind {
    private int[] id;
    private int count;

    public UnionFind(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
        count = N;
    }

    public UnionFind(In in) {
        this(in.readInt());
        int N = count;
        for (int i = 0; i < N; i++) {
            union(in.readInt(), in.readInt());
        }
    }

    // union-find 算法实现
    public void union(int p, int q){
        int pID = find(p);
        int qID = find(q);
        if (pID == qID) return;

        id[pID] = id[qID];
        count--;
    }

    // 从 id[p] 所属分量的根，即 id[p] = p
    public int find(int p) {
        while (id[p] != p) {
            p = id[p];
        }
        return p;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int count() {
        return count;
    }
}
