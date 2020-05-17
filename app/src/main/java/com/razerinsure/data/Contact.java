package com.razerinsure.data;

public class Contact {
    private String imagePath;
    private String name;

    public Contact(String imagePath, String name) {
        this.imagePath = imagePath;
        this.name = name;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getName() {
        return name;
    }

}
