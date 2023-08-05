package com.example.compario;

import android.os.Parcel;
import android.os.Parcelable;

public class itemlist {
    String phone;
    public itemlist(String phone) {

        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {

        this.phone = phone;
    }
}
