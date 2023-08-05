package com.example.compario;

public class itemlist2 {

    String  phone2,rate1,rate2;
    int image;





    public itemlist2(String phone2, String rate1,String rate2,int image) {
        this.phone2 = phone2;

        this.rate1 = rate1;
        this.rate2 = rate2;
        this.image=image;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }



    public String getRate1() {
        return rate1;
    }

    public void setRate1(String rate1) {
        this.rate1 = rate1;
    }

    public String getRate2() {
        return rate2;
    }

    public void setRate2(String rate2) {
        this.rate2 = rate2;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
