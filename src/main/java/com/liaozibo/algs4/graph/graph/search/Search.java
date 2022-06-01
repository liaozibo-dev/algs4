package com.liaozibo.algs4.graph.graph.search;

public interface Search {
    boolean marked(int v); // 顶点    v 是否与起点连通
    int count(); // 返回起点连通的顶点总数
}
