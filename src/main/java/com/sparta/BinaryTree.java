package com.sparta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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

        currentNode = tempNode;

        return total;
    }

    @Override
    public void addElement(int element) {
//if root node does not exist then create it, if it does exist then insert node
        if(root == null){
            root=new Node(element);
            currentNode=root;
        }
        boolean elementSet = false;
        if (element<currentNode.getValue()){
            if(currentNode.isLeftChildEmpty()){
                currentNode.setLeftChild(new Node(element));
            } else {
                currentNode=currentNode.getLeftChild();
                addElement(element);
                elementSet = true;
            }
        }

        if(element>currentNode.getValue() && !elementSet){
            if(currentNode.isRightChildEmpty()){
                currentNode.setRightChild(new Node(element));
            } else {
                currentNode=currentNode.getRightChild();
                addElement(element);
            }
        }

        currentNode = root;
    }

    @Override
    public void addElements(int[] elements) {
        for (int element: elements) {
            this.addElement(element);
        }
    }

    @Override
    public boolean findElement(int value) {

        boolean element = value == currentNode.getValue();

        boolean elementFound = false;

        if (value<currentNode.getValue()){
            if(currentNode.isLeftChildEmpty()){
                element = false;
            } else {
                currentNode=currentNode.getLeftChild();
                element = findElement(value);
                elementFound = true;
            }
        }

        if(value>currentNode.getValue() && !elementFound){
            if(currentNode.isRightChildEmpty()){
                element = false;
            } else {
                currentNode=currentNode.getRightChild();
                element = findElement(value);
            }
        }

        currentNode = root;
        return element;
    }

    @Override
    public int getLeftChild(int element){
        boolean elementExists = element == currentNode.getValue();

        if (element<currentNode.getValue()){
            if(currentNode.isLeftChildEmpty()){
                elementExists = false;
            } else {
                currentNode=currentNode.getLeftChild();
                elementExists = getLeftChild(element) > 0;
            }
        }

        if(element>currentNode.getValue() && !elementExists){
            if(currentNode.isRightChildEmpty()){
                elementExists = false;
            } else {
                currentNode=currentNode.getRightChild();
                elementExists = getRightChild(element) > 0;
            }
        }

        if (elementExists && !currentNode.isLeftChildEmpty()) {
            return currentNode.getLeftChild().getValue();
        } else {
            return 0;
        }
        //return left child of the number 7
    }

    @Override
    public int getRightChild(int element) {
        return 0;
    }

    @Override
    public int[] getSortedTreeAsc() {
        //List<Integer> integerList = new ArrayList<Integer>();
        Node tempNode = currentNode;

        int[] leftArray;
        int[] rightArray;

        if (!currentNode.isLeftChildEmpty()) {
            currentNode = currentNode.getLeftChild();
            leftArray = getSortedTreeAsc();
        } else {
            leftArray = new int[0];
        }
        currentNode = tempNode;
        if (!currentNode.isRightChildEmpty()) {
            currentNode = currentNode.getRightChild();
            rightArray = getSortedTreeAsc();
        } else {
            rightArray = new int[0];
        }
        currentNode = tempNode;

        int[] value = new int[1];
        value[0] = currentNode.getValue();
        int[] temp = IntStream.concat(Arrays.stream(leftArray), Arrays.stream(value)).toArray();
        int[] result = IntStream.concat(Arrays.stream(temp), Arrays.stream(rightArray)).toArray();
        return result;
    }

    @Override
    public int[] getSortedTreeDesc() {
        Node tempNode = currentNode;

        int[] leftArray;
        int[] rightArray;

        if (!currentNode.isRightChildEmpty()) {
            currentNode = currentNode.getRightChild();
            leftArray = getSortedTreeDesc();
        } else {
            leftArray = new int[0];
        }
        currentNode = tempNode;

        if (!currentNode.isLeftChildEmpty()) {
            currentNode = currentNode.getLeftChild();
            rightArray = getSortedTreeDesc();
        } else {
            rightArray = new int[0];
        }
        currentNode = tempNode;

        int[] value = new int[1];
        value[0] = currentNode.getValue();
        int[] temp = IntStream.concat(Arrays.stream(leftArray), Arrays.stream(value)).toArray();
        int[] result = IntStream.concat(Arrays.stream(temp), Arrays.stream(rightArray)).toArray();
        return result;
    }
}
