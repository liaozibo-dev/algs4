package com.liaozibo.algs4.string.huffman.coding;

import com.liaozibo.algs4.base.MinPQ;
import edu.princeton.cs.algs4.BinaryIn;
import edu.princeton.cs.algs4.BinaryOut;

public class Huffman {
    private static final int R = 256; // ASCII 字母表
    private static BinaryIn binaryIn;
    private static BinaryOut binaryOut;

    // 编码过程
    public static void compress(BinaryIn binaryIn, BinaryOut binaryOut) {
        Huffman.binaryIn = binaryIn;
        Huffman.binaryOut = binaryOut;
        // 读取字符串
        String s = binaryIn.readString();
        char[] input = s.toCharArray();
        // 统计每个字符出现的频率
        int[] freq = new int[R];
        for (int i = 0; i < input.length; i++) {
            freq[input[i]]++;
        }
        // 根据字符频率构造哈夫曼树
        Node root = buildTire(freq);
        // 构造编译表（ASCII 字符 -> 比特字符串）
        String[] table = buildTable(root);
        // 输出哈夫曼树、字符数量和每个字符的字符编码
        writeTire(root);
        binaryOut.write(input.length);
        for (int i = 0; i < input.length; i++) {
            String code = table[input[i]]; // 从编译表中查出字符对应的字符编码
            for (int j = 0; j < code.length(); j++) {
                if (code.charAt(j) == '1') {
                    binaryOut.write(true);
                } else {
                    binaryOut.write(false);
                }
            }
        }
        binaryOut.close();
    }

    // 解码过程
    public static void expand(BinaryIn binaryIn, BinaryOut binaryOut) {
        Huffman.binaryIn = binaryIn;
        Huffman.binaryOut = binaryOut;
        // 读取哈夫曼树
        Node root = readTire();
        // 读取字符总数
        int N = binaryIn.readInt();
        // 读取比特流并根据哈夫曼树进行解码
        for (int i = 0; i < N; i++) {
            Node x = root;
            // 根据比特流遍历哈夫曼树直到叶子结点
            while (!x.isLeaf()) {
                if (binaryIn.readBoolean()) {
                    x = x.right();
                } else {
                    x = x.left();
                }
            }
            // 输出叶子结点保存的字符
            Huffman.binaryOut.write(x.c());
        }
        Huffman.binaryOut.close();
    }

    // 根据哈夫曼树构构造译表（字符 -> 比特字符串）
    private static String[] buildTable(Node root) {
        String[] table = new String[R];
        buildTable(table, root,  "");
        return table;
    }

    private static void buildTable(String[] table, Node node, String code) {
        if (node.isLeaf()) {
            table[node.c()] = code;
            return;
        }
        buildTable(table, node.left(), code + "0");
        buildTable(table, node.right(), code + "1");
    }

    // 使用哈夫曼编码算法构造单词查找树
    private static Node buildTire(int[] freq) {
        // 根据字符频率将所有字符放到优先队列
        MinPQ<Node> pq = new MinPQ<>();
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                pq.add(new Node((char)i, freq[i], null, null));
            }
        }

        // 从出现频率较低的字符开始构建哈夫曼树，父结点的频率是子结点的频率之和
        while (pq.size() > 1) {
            Node x = pq.remove();
            Node y = pq.remove();
            Node parent = new Node('\0', x.freq() + y.freq(), x, y);
            pq.add(parent);
        }
        return pq.remove();
    }

    private static void writeTire(Node node) {
        if (node.isLeaf()) {
            binaryOut.write(true);
            binaryOut.write(node.c());
            return;
        }
        binaryOut.write(false);
        writeTire(node.left());
        writeTire(node.right());
    }

    private static Node readTire() {
        if (binaryIn.readBoolean()) {
            return new Node(binaryIn.readChar(), 0, null, null);
        }
        return new Node('\0', 0, readTire(), readTire());
    }
}
