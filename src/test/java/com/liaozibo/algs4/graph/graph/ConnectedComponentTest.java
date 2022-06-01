package com.liaozibo.algs4.graph.graph;

import com.liaozibo.algs4.graph.graph.cc.DepthFirstCC;
import com.liaozibo.algs4.util.ResourceUtils;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import org.junit.jupiter.api.Test;

public class ConnectedComponentTest {
    private static final String filename = "tinyG.txt";

    @Test
    public void testCC() {
        In in = new In(ResourceUtils.getResource(filename));
        Graph G = new Graph(in);
        DepthFirstCC cc = new DepthFirstCC(G);
        int count = cc.count();
        System.out.printf("%d components\n", count);

        Bag<Integer>[] components = new Bag[count];
        for (int i = 0; i < count; i++) {
            components[i] = new Bag<>();
        }
        for (int v = 0; v < G.V(); v++) {
            components[cc.id(v)].add(v);
        }
        for (int i = 0; i < count; i++) {
            for (int v : components[i]) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }
}
