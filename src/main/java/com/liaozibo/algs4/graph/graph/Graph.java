package com.liaozibo.algs4.graph.graph;

import com.liaozibo.algs4.base.Bag;
import edu.princeton.cs.algs4.In;

/**
 * 基于邻接表数组实现的无向图
 * 邻接表数组：数组的索引表示顶点 v；数组的元素是一个集合，表示与 v 相邻的所有顶点
 * */
public class Graph {
    private int V; // 顶点数
    private int E; // 边数
    private Bag<Integer>[] adj; // 邻接表数组

    public Graph(int V) {
        this.V = V;
        this.adj = new Bag[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new Bag<>();
        }
    }

    public Graph(In in) {
        this(in.readInt());
        int E = in.readInt(); // 新建一个变量，而不是赋值给对象的属性
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }
}
