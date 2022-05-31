package com.liaozibo.algs4.base;

import edu.princeton.cs.algs4.In;

/**
 * union-find 算法
 * * 初始化时所有初始点都属于不同分量（有不同id）
 * * 每添加一条连接 p-q 时，将所有属于 pID 的触点归并到 qID 中
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

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID) {
                id[i] = qID;
            }
        }
        count--;
    }

    public int find(int p) {
        return id[p];
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int count() {
        return count;
    }
}
