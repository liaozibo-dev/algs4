package com.liaozibo.algs4.graph.mst.adt;

/**
 * 带权重的边
 * */
public class Edge implements Comparable<Edge> {
    private int v; // 一个顶点
    private int w; // 另一个顶点
    private double weight; // 边的权重

    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int either() {
        return v;
    }

    public int other(int vertex) {
        if (vertex == v) return w;
        else if (vertex == w) return v;
        else throw new RuntimeException("Inconsistent edge");
    }

    @Override
    public int compareTo(Edge that) {
        if (this.weight > that.weight) return 1;
        else if (this.weight < that.weight) return -1;
        else return 0;
    }

    @Override
    public String toString() {
        return String.format("%d-%d %.2f", v, w, weight);
    }

    public int v() {
        return v;
    }

    public int w() {
        return w;
    }

    public double weight() {
        return weight;
    }
}
