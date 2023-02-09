package com.sparta;

public class BinaryTree implements IBinaryTree {

    Node root;

    public BinaryTree(int value) {
        root = new Node(value);
    }

    @Override
    public int getRootElement() {
        return this.root.getValue();
    }

    @Override
    public int getNumberOfElements() {
        return 0;
    }

    @Override
    public void addElement(int element) {
        Node currentNode = root;
        while (currentNode.getValue() != element) {
            if (element > currentNode.getValue()) {
                if (currentNode.isRightChildEmpty()) {
                    currentNode.setRightChild(new Node(element));
                } else {
                    currentNode = currentNode.getRightChild();
                }
            } else {
                if (currentNode.isLeftChildEmpty()) {
                    currentNode.setLeftChild(new Node(element));
                } else {
                    currentNode = currentNode.getLeftChild();
                }
            }
        }
        System.out.println(root.getValue());
        System.out.println(root.getRightChild().getValue());
        if (!root.isLeftChildEmpty())
            System.out.println(root.getLeftChild().getValue());
    }

    @Override
    public void addElements(int[] elements) {

    }

    @Override
    public boolean findElement(int value) {
        return false;
    }

    @Override
    public int getLeftChild(int element) {
        return 0;
    }

    @Override
    public int getRightChild(int element) {
        return 0;
    }

    @Override
    public int[] getSortedTreeAsc() {
        return new int[0];
    }

    @Override
    public int[] getSortedTreeDesc() {
        return new int[0];
    }
}
