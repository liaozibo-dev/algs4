package com.liaozibo.algs4.graph.mst;

import com.liaozibo.algs4.base.MinPQ;
import com.liaozibo.algs4.base.Queue;
import com.liaozibo.algs4.graph.mst.adt.Edge;
import com.liaozibo.algs4.graph.mst.adt.EdgeWeightedGraph;

/**
 * 最小生成树 Prime 算法的延迟实现（失效的边是延迟删除的）
 * * 使用 marked 数组标记最小生成树的顶点
 * * 使用保存最小生成树的边
 * * 使用优先队列保存横切边
 * */
public class LazyPrimMST implements MST {
    private boolean[] marked; // 最小生成树的顶点
    private Queue<Edge> mst; // 最小生成树的边
    private MinPQ<Edge> pq; // 横切边（包括失效的边）

    public LazyPrimMST(EdgeWeightedGraph G) {
        marked = new boolean[G.V()];
        mst = new Queue<>();
        pq = new MinPQ<>();
        // 起点
        visit(G, 0);
        // Prim
        while (!pq.isEmpty()) {
            Edge e = pq.remove();
            int v = e.either();
            int w = e.other(v);
            if (marked[v] && marked[w]) continue; // 跳过失效的边
            mst.add(e);
            if (!marked[v]) visit(G, v);
            if (!marked[w]) visit(G, w);
        }
    }

    private void visit(EdgeWeightedGraph G, int v) {
        marked[v] = true;
        for (Edge e : G.adj(v)) {
            if (!marked[e.other(v)]) pq.add(e);
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }

    public double weight() {
        double weight = 0.0;
        for (Edge e : mst) {
            weight += e.weight();
        }
        return weight;
    }
}
