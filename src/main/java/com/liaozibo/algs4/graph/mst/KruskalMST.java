package com.liaozibo.algs4.graph.mst;

import com.liaozibo.algs4.base.MinPQ;
import com.liaozibo.algs4.base.Queue;
import com.liaozibo.algs4.base.UnionFind;
import com.liaozibo.algs4.graph.mst.adt.Edge;
import com.liaozibo.algs4.graph.mst.adt.EdgeWeightedGraph;

/**
 * 使用克鲁斯卡尔算法找出加权连通图的最小生成树
 * */
public class KruskalMST implements MST {
    private Queue<Edge> mst;

    public KruskalMST(EdgeWeightedGraph G) {
        mst = new Queue<>(); // 使用优先队列保存最小生成树的边
        MinPQ<Edge> pq = new MinPQ<>(); // 使用优先队列按边从小到大顺序处理
        UnionFind unionFind = new UnionFind(G.V()); // 使用 union-find 算法检测是否会产生环

        // 将所有边添加到优先队列
        for (Edge e : G.edges()) {
            pq.add(e);
        }
        // 开始生成最小生成树
        while (!pq.isEmpty() && mst.size() < G.V() - 1) {
            Edge e = pq.remove();
            int v = e.either();
            int w = e.other(v);
            if (unionFind.connected(v, w)) {
                continue;
            }
            mst.add(e);
            unionFind.union(v, w);
        }
    }

    @Override
    public Iterable<Edge> edges() {
        return mst;
    }

    @Override
    public double weight() {
        double weight = 0.0;
        for (Edge e : mst) {
            weight += e.weight();
        }
        return weight;
    }
}
