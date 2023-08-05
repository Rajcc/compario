package com.example.compario;

public class itemlisthome {
    String itemhome,rate1home,rate2home;
    int image;

    public itemlisthome(String itemhome, String rate1home, String rate2home, int image) {
        this.itemhome = itemhome;
        this.rate1home = rate1home;
        this.rate2home = rate2home;
        this.image = image;
    }

    public String getItemhome() {
        return itemhome;
    }

    public void setItemhome(String itemhome) {
        this.itemhome = itemhome;
    }

    public String getRate1home() {
        return rate1home;
    }

    public void setRate1home(String rate1home) {
        this.rate1home = rate1home;
    }

    public String getRate2home() {
        return rate2home;
    }

    public void setRate2home(String rate2home) {
        this.rate2home = rate2home;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
