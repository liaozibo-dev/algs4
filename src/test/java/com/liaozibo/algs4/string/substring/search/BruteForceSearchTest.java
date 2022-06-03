package com.liaozibo.algs4.string.substring.search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BruteForceSearchTest {
    @Test
    public void testBruteForceSearch() {
        Assertions.assertEquals(0, BruteForceSearch.search("hello", "hello world"));
        Assertions.assertEquals(2, BruteForceSearch.search("hello", "!!hello world"));
        Assertions.assertEquals(-1, BruteForceSearch.search("hi", "hello world"));
    }
}
