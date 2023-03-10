package com.ute.jee_tuthuchanh.beans;

public class Category {
    private int CatID;
    private String CatName;

    public Category() {
    }

    public Category(int catID, String catName) {
        this.CatID = catID;
        this.CatName = catName;
    }
    public Category(String catName) {
        this.CatID = -1;
        this.CatName = catName;
    }

    public int getCatID() {
        return CatID;
    }

    public String getCatName() {
        return CatName;
    }
}
