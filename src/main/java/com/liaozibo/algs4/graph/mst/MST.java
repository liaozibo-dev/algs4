package com.liaozibo.algs4.graph.mst;

import com.liaozibo.algs4.graph.mst.adt.Edge;

/**
 * 最小生成树
 * */
public interface MST {
    Iterable<Edge> edges();
    double weight();
}
