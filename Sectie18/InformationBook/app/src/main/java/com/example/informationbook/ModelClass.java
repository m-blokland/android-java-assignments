package com.example.informationbook;

public class ModelClass {

    private final String imageName;
    private final String categoryName;

    public ModelClass(String imageName, String categoryName) {
        this.imageName = imageName;
        this.categoryName = categoryName;
    }

    public String getImageName() {
        return imageName;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
