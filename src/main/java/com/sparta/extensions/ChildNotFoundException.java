package com.sparta.extensions;

public class ChildNotFoundException extends Exception{

    @Override
    public String getMessage() {
        return "child of this node is not found";
    }
}
