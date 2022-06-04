package com.liaozibo.algs4.string.substring.search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoyerMooreTest {
    @Test
    public void test() {
        BoyerMoore bm = new BoyerMoore("hello");
        Assertions.assertEquals(0, bm.search("hello world"));
        Assertions.assertEquals(2, bm.search("!!hello world"));
        Assertions.assertEquals(-1, bm.search("world"));
    }
}
