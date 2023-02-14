package com.sparta;

import com.sparta.extensions.ChildNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    @Test
    @DisplayName("Checking No Right Child Exception works")
    void checkNoRightChildException() {
        BinaryTree binTree = new BinaryTree();
        binTree.addElement(12);
        Assertions.assertThrows(ChildNotFoundException.class, () -> binTree.getRightChild(12));
    }

    @Test
    @DisplayName("Checking No Left Child exception works")
    void checkNoLeftChildException() {
        BinaryTree binTree = new BinaryTree();
        binTree.addElement(12);
        Assertions.assertThrows(ChildNotFoundException.class, () -> binTree.getLeftChild(12));
    }
}