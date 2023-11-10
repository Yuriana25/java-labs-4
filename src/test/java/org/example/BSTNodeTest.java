package org.example;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class BSTNodeTest {
    public static Map<Integer, String> map = new LinkedHashMap<>();
    public static BSTNode root;
    @Test
    void test1() {
        Random random = new Random();
        int n = 16;
        for (int i = 0; i < 20; i++) {
            int randomKey;
            do {
                randomKey = random.nextInt(20) + n; // [16,36)
            } while (map.containsKey(randomKey));
            String randomValue = "Value " + randomKey;
            map.put(randomKey, randomValue);
        }
    }

    @Test
    void test2() {
        int firstKey = map.keySet().iterator().next();
        root = new BSTNode(firstKey, map.get(firstKey));
        for (int key : map.keySet()) {
                String value = map.get(key);
                root.insert(root, key, value);
        }
        int nodeCount = root.countNodes(root);
        assertEquals(map.size(), nodeCount);
    }

    @Test
    void test3() {
        BSTNode node;
        node = root.search(root, 16);
        assertEquals("Value 16", node.getValue());

        node = root.search(root, 35);
        assertEquals("Value 35", node.getValue());

        node = root.search(root, 25);
        assertEquals("Value 25", node.getValue());

        node = root.search(root, 5);
        assertNull(node);
    }

    @Test
    void test4() {
        BSTNode node;

        int firstKey = map.keySet().iterator().next();
        root = new BSTNode(firstKey, map.get(firstKey));
        int number = 26;
        if (firstKey == number)
            number++;
        for (int key : map.keySet()) {
            if (key == number) {
                continue;
            }
            String value = map.get(key);
            root.insert(root, key, value);
        }
        int nodeCount = root.countNodes(root);
        assertEquals(map.size() - 1, nodeCount);

        root.insert(root, number, "Value " + number);
        node = root.search(root, number);
        assertEquals("Value " + number, node.getValue());

        root.insert(root, 18, "Value 18 double");
        nodeCount = root.countNodes(root);
        assertEquals(map.size(), nodeCount);

        node = root.search(root, 18);
        assertEquals("Value 18 double", node.getValue());
    }

    @Test
    void test5() {
        BSTNode node;
        root = root.delete(root, 25);
        int nodeCount = root.countNodes(root);
        assertEquals(map.size() - 1, nodeCount);
        node = root.search(root, 25);
        assertNull(node);
    }
}