package com.liaozibo.algs4.string.substring.search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class KmpTest {
    @Test
    public void testBruteForceSearch() {
        KMP kmp = new KMP("hello");
        Assertions.assertEquals(0, kmp.search("hello world"));
        Assertions.assertEquals(2, kmp.search("!!hello world"));
        Assertions.assertEquals(-1, kmp.search("world"));
    }
}
