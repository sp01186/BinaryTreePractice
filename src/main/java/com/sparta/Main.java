package com.sparta;

public class Main {
    public static void main(String[] args) {
        BinaryTree binTree = new BinaryTree();
        binTree.addElement(17);
        binTree.addElement(13);
        binTree.addElement(4);
        binTree.addElement(9);
        binTree.addElement(22);
        System.out.println(binTree.getNumberOfElements());
        binTree.getRootElement();
        System.out.println(binTree.findElement(17));
        binTree.getRootElement();
        System.out.println(binTree.findElement(3));
        binTree.getRootElement();
        System.out.println(binTree.findElement(4));
        binTree.getRootElement();
        System.out.println(binTree.findElement(22));


    }
}
