package com.liaozibo.algs4.graph.mst.adt;

import com.liaozibo.algs4.base.Bag;
import edu.princeton.cs.algs4.In;

/**
 * 加权无向图
 * */
public class EdgeWeightedGraph {
    private final int V; // 顶点数
    private int E; // 边数
    private Bag<Edge>[] adj; // 邻接表

    public EdgeWeightedGraph(int V) {
        this.V = V;
        this.E = 0;
        adj = new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<>();
        }
    }

    public EdgeWeightedGraph(In in) {
        this.V = in.readInt();
        int E = in.readInt();
        adj = new Bag[V];
        for (int v = 0 ; v < V; v++) {
            adj[v] = new Bag<>();
        }
        for (int e = 0 ; e < E; e++) {
            int v = in.readInt();
            int w = in.readInt();
            double weight = in.readDouble();
            addEdge(new Edge(v, w, weight));
        }
    }

    public void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }

    public Iterable<Edge> adj(int v) {
        return adj[v];
    }

    public Iterable<Edge> edges() {
        Bag<Edge> bag = new Bag<>();
        for (int v = 0; v < V; v++) {
            for (Edge e : adj[v]) {
                if (e.other(v) > v) bag.add(e); // 避免将边重复加入结果集
            }
        }
        return bag;
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }
}
