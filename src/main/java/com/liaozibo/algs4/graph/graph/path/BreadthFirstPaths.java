package com.liaozibo.algs4.graph.graph.path;

import com.liaozibo.algs4.base.Queue;
import com.liaozibo.algs4.graph.graph.Graph;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 基于广度优先搜索解决单点最短路径问题
 * */
public class BreadthFirstPaths implements Paths {
    private boolean[] marked;
    private int[] pathTo;
    private int source;

    public BreadthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        pathTo = new int[G.V()];
        source = s;
        bfs(G, s);
    }

    private void bfs(Graph G, int s) {
        Queue<Integer> queue = new Queue<>();
        marked[s] = true;
        queue.add(s);
        while (!queue.isEmpty()) {
            int v = queue.remove();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    marked[w] = true;
                    pathTo[w] = v;
                    queue.add(w);
                }
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
