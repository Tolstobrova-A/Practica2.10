package com.mirea.kt.ribo.practica2_10;

public class Shop {
    private String name;
    private String address;
    private String timeS;
    private String timeC;

    public Shop(String name, String address, String timeS, String timeC) {
        this.name = name;
        this.address = address;
        this.timeS = timeS;
        this.timeC = timeC;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getTimeS() {
        return timeS;
    }

    public String getTimeC() {
        return timeC;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTimeS(String timeS) {
        this.timeS = timeS;
    }

    public void setTimeC(String timeC) {
        this.timeC = timeC;
    }
}
