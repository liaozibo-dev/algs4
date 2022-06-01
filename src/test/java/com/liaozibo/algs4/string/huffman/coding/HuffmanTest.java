package com.liaozibo.algs4.string.huffman.coding;

import com.liaozibo.algs4.util.ResourceUtils;
import edu.princeton.cs.algs4.BinaryIn;
import edu.princeton.cs.algs4.BinaryOut;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class HuffmanTest {

    private static final String abra = "abra.txt";
    private static final String tinyTale = "tinytinyTale.txt";
    private static final String medTale = "medTale.txt";

    private static final String filename = medTale;

    @Test
    public void testCompress() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        // 编码
        BinaryIn binaryIn = new BinaryIn(ResourceUtils.getResource(filename));
        BinaryOut binaryOut = new BinaryOut(byteArrayOutputStream);
        Huffman.compress(binaryIn, binaryOut);

        byte[] byteArray = byteArrayOutputStream.toByteArray();
        // printBytes(byteArray);

        // 解码
        binaryIn = new BinaryIn(new ByteArrayInputStream(byteArray));
        binaryOut = new BinaryOut();
        Huffman.expand(binaryIn, binaryOut);
    }

    private void printBytes(byte[] byteArray) {
        for (Byte bytes : byteArray) {
            System.out.print(Long.toBinaryString(bytes));
        }
        System.out.println();
    }
}
