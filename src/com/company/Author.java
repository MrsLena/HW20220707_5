package com.company;

public class Author {
    String fName;
    String lName;

    public Author(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;
    }



    @Override
    public String toString() {
        return "Author: " + fName + " " + lName;
    }
}
