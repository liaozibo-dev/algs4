package com.liaozibo.algs4.string.trie;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TrieStTest {
    @Test
    public void testTreeST() {
        TrieST<Integer> trie = new TrieST<>();
        trie.put("hello", 1);
        trie.put("world", 2);
        Assertions.assertEquals(1, trie.get("hello"));
        Assertions.assertEquals(2, trie.get("world"));
        Assertions.assertEquals(null, trie.get("hi"));

        Assertions.assertEquals(2, trie.size());
        Assertions.assertIterableEquals(Arrays.asList("hello", "world"), trie.keys());
        Assertions.assertIterableEquals(Arrays.asList("world"), trie.keysPrefixWith("wo"));
        Assertions.assertIterableEquals(Arrays.asList("world"), trie.keysThatMatch("wo..."));
        Assertions.assertEquals("", trie.longestPrefixOf("hello!!!"));
    }
}
