package com.liaozibo.algs4.graph.graph.path;

import com.liaozibo.algs4.graph.graph.Graph;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 基于深度优先搜索解决单点路径问题
 * */
public class DepthFirstPaths implements Paths {
    private boolean[] marked;
    private int[] pathTo;
    private int source;

    public DepthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        pathTo = new int[G.V()];
        source = s;
        dfs(G, s);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                pathTo[w] = v;
                dfs(G, w);
            }
        }
    }

    @Override
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    @Override
    public Iterable<Integer> pathTo(int v) {
        if (!marked[v]) {
            return null;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        while (v != source) {
            stack.push(v);
            v = pathTo[v];
        }
        stack.push(v);
        return stack;
    }
}
