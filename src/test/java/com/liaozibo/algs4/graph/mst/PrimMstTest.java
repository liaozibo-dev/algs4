package com.liaozibo.algs4.graph.mst;

import com.liaozibo.algs4.graph.mst.adt.Edge;
import com.liaozibo.algs4.graph.mst.adt.EdgeWeightedGraph;
import com.liaozibo.algs4.util.ResourceUtils;
import edu.princeton.cs.algs4.In;
import org.junit.jupiter.api.Test;

public class PrimMstTest {

    private static final String tinyEWG = "tinyEWG.txt";
    private static final String mediumEWG = "mediumEWG.txt";

    private static final String filename = tinyEWG;


    @Test
    public void TestPrimMST() {
        EdgeWeightedGraph G = new EdgeWeightedGraph(new In(ResourceUtils.getResource(filename)));
        MST mst = new LazyPrimMST(G);
        for (Edge e : mst.edges()) {
            System.out.println(e);
        }
        System.out.println(mst.weight());
    }
}
