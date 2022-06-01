package com.liaozibo.algs4.graph.graph.cc;

/**
 * 连通分量 API
 * */
public interface ConnectedComponent {
    boolean connected(int v, int w); // 两个顶点是否连通
    int id(int v); // 顶点所属的连通分量id
    int count(); // 连通分量数量
}
