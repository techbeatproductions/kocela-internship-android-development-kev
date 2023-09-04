package com.example.internshipkocelanuntiumnewsapp.learning;

public class Animals {

    String animalImg = "";
    String animalName = "";

    public Animals(String animalImg, String animalName) {
        this.animalImg = animalImg;
        this.animalName = animalName;
    }

    public String getAnimalImg() {
        return animalImg;
    }

    public void setAnimalImg(String animalImg) {
        this.animalImg = animalImg;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }
}
