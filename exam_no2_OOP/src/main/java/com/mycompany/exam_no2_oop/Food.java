/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exam_no2_oop;

/**
 *
 * @author User
 */

//class Food {
//    private String nama;
//    private int harga;
//
//    public int getHarga() {
//        return harga;
//    }
//
//    public String getNama() {
//        return nama;
//    }
//
//    public void setHarga(int harga) {
//        this.harga = harga;
//    }
//
//    public void setNama(String nama) {
//        this.nama = nama;
//    }
//}

abstract class Food {    
    
    private String nama;
    private int harga;
    private String foodType;

    public Food(String foodType) {
        this.foodType = foodType;
    }
    
    public int getHarga() {
        return harga;
    }

    public String getNama() {
        return nama;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }    

    public String getFoodType() {
        return foodType;
    }    
}

class Dessert extends Food {

    public Dessert() {
        super("Dessert");
    }
    
}

class MainCourse extends Food {

    public MainCourse() {
        super("Main Course");
    }
    
}

class Appetizer extends Food {

    public Appetizer() {
        super("Appetizer");
    }
    
}