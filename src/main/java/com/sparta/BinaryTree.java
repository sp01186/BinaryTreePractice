package com.sparta;

public class BinaryTree implements IBinaryTree {

    Node root;
    Node currentNode;

    @Override
    public int getRootElement() {
        currentNode = root;
        return this.root.getValue();

    }

    @Override
    public int getNumberOfElements() {
        if (root == null) {
            return 0;
        }
        int total = 1;
        Node tempNode = currentNode;
        if (!currentNode.isLeftChildEmpty()) {
            currentNode = currentNode.getLeftChild();
            total += getNumberOfElements();
        }
        currentNode = tempNode;
        if (!currentNode.isRightChildEmpty()) {
            currentNode = currentNode.getRightChild();
            total += getNumberOfElements();
        }
        return total;
    }

    @Override
    public void addElement(int element) {
//if root node does not exist then create it, if it does exist then insert node
        if(root == null){
            root=new Node(element);
            currentNode=root;
        }

        Node tempNode = root;
        if (element<currentNode.getValue()){
            if(currentNode.isLeftChildEmpty()){
                currentNode.setLeftChild(new Node(element));
                currentNode = root;
            } else {
                currentNode=currentNode.getLeftChild();
                addElement(element);
            }
        }

        if(element>currentNode.getValue()){
            if(currentNode.isRightChildEmpty()){
                currentNode.setRightChild(new Node(element));
                currentNode = root;
            } else {
                currentNode=currentNode.getRightChild();
                addElement(element);
            }
        }
    }

    @Override
    public void addElements(int[] elements) {
        for (int element: elements) {
            this.addElement(element);
        }
    }

    @Override
    public boolean findElement(int value) {

        if (value == currentNode.getValue()) {
            return true;
        }

        if (value<currentNode.getValue()){
            if(currentNode.isLeftChildEmpty()){
                return false;
            } else {
                currentNode=currentNode.getLeftChild();
                return findElement(value);
            }
        }

        if(value>currentNode.getValue()){
            if(currentNode.isRightChildEmpty()){
                return false;
            } else {
                currentNode=currentNode.getRightChild();
                return findElement(value);
            }
        }
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
