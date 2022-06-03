package com.liaozibo.algs4.graph.graph;

import com.liaozibo.algs4.graph.graph.search.DepthFirstSearch;
import com.liaozibo.algs4.graph.graph.search.Search;
import com.liaozibo.algs4.util.ResourceUtils;
import edu.princeton.cs.algs4.In;
import org.junit.jupiter.api.Test;

public class BruteForceSearchTest {

    private static final String filename = "tinyG.txt";

    @Test
    public void testSearch() {
        In in = new In(ResourceUtils.getResource(filename));
        Graph G = new Graph(in);
        int source = 7;
        Search search = new DepthFirstSearch(G, source);
        for (int v = 0; v < G.V(); v++) {
            if (search.marked(v)) {
                System.out.printf("%d-%d\n", source, v);
            }
        }
        if (search.count() < G.V()) {
            System.out.print("Not ");
        }
        System.out.println("connected");
    }
}
