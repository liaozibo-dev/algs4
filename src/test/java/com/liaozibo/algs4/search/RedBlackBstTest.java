package com.liaozibo.algs4.search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RedBlackBstTest {

    @Test
    public void testRedBlackBST() {
        RedBlackBST<String, Integer> tree = new RedBlackBST<>();
        tree.put("Tom", 18);
        tree.put("John", 20);

        Assertions.assertEquals(18, tree.get("Tom"));
        Assertions.assertEquals(20, tree.get("John"));
        Assertions.assertEquals(null, tree.get("Mike"));
        Assertions.assertEquals(2, tree.size());
    }
}
