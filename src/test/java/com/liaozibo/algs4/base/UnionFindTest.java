package com.liaozibo.algs4.base;

import com.liaozibo.algs4.util.ResourceUtils;
import edu.princeton.cs.algs4.In;
import org.junit.jupiter.api.Test;

public class UnionFindTest {
    private static final String tinyUF = "tinyUF.txt";
    private static final String mediumUF = "mediumUF.txt";
    private static final String largeUF = "largeUF.txt";

    private static final String filename = tinyUF;

    @Test
    public void testUF() {
        In in = new In(ResourceUtils.getResource(filename));
        UnionFind unionFind = new UnionFind(in);
        System.out.println(unionFind.count() + " components");
    }
}
