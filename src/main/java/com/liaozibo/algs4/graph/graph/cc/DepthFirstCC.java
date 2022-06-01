package com.liaozibo.algs4.graph.graph.cc;

import com.liaozibo.algs4.graph.graph.Graph;

/**
 * 使用深度优先搜索找出图中的所有连通分量
 * */
public class DepthFirstCC implements ConnectedComponent {
    private boolean[] marked;
    private int[] id; // 记录每个顶点所属的连通分量id
    private int count;

    public DepthFirstCC(Graph G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) {
                dfs(G, v);
                count++;
            }
        }
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    @Override
    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }

    @Override
    public int id(int v) {
        return id[v];
    }

    @Override
    public int count() {
        return count;
    }
}
