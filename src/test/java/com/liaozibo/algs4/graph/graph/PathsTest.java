package com.liaozibo.algs4.graph.graph;

import com.liaozibo.algs4.graph.graph.path.BreadthFirstPaths;
import com.liaozibo.algs4.graph.graph.path.Paths;
import com.liaozibo.algs4.util.ResourceUtils;
import edu.princeton.cs.algs4.In;
import org.junit.jupiter.api.Test;

public class PathsTest {

    private static final String filename = "tinyCG.txt";

    @Test
    public void testPaths() {
        In in = new In(ResourceUtils.getResource(filename));
        Graph G = new Graph(in);
        int source = 0;
//        Paths paths = new DepthFirstPaths(G, source);
        Paths paths = new BreadthFirstPaths(G, source);
        for (int v = 0; v < G.V(); v++) {
            if (paths.hasPathTo(v)) {
                System.out.printf("%d to %d: ", source, v);
                for (int w : paths.pathTo(v)) {
                    System.out.print(w + " ");
                }
                System.out.println();
            }
        }
    }
}
