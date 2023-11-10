package org.example;

public class BSTNode {
    int key;
    String value;
    BSTNode left, right;
    public BSTNode(int key, String value) {
        this.key = key;
        this.value = value;
        left = null;
        right = null;
    }
    public String getValue() {
        return value;
    }
    public BSTNode insert(BSTNode root, int key, String value) {
        if (root == null) {
            return new BSTNode(key, value);
        }
        if (key < root.key) {
            root.left = insert(root.left, key, value);
        } else if (key > root.key) {
            root.right = insert(root.right, key, value);
        } else {
            root.value = value;
        }
        return root;
    }
    public BSTNode delete(BSTNode root, int key) {
        if (root == null)
            return null;
        if (key < root.key) {
            root.left = delete(root.left, key);
        } else if (key > root.key) {
            root.right = delete(root.right, key);
        }
        else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                BSTNode maxInLeft = getMax(root.left);
                root.key = maxInLeft.key;
                root.value = maxInLeft.value;
                root.right = maxInLeft.right;
            }
        }
        return root;
    }
    public BSTNode search(BSTNode root, int key) {
        if (root == null)
            return null;
        if (root.key == key)
            return root;
        return (key < root.key) ? search(root.left, key) : search(root.right, key);
    }
    private BSTNode getMax(BSTNode root) {
        if (root == null) {
            return null;
        }
        if (root.right == null) {
            return root;
        }
        return getMax(root.right);
    }
    public int countNodes(BSTNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
