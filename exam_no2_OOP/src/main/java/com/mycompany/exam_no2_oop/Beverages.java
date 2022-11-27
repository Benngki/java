/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exam_no2_oop;

/**
 *
 * @author User
 */
abstract class Beverages {
    private String nama;
    private int harga;
    private String type;

    public Beverages(String type) {
        this.type = type;
    }
    
    public void setHarga(int harga) {
        this.harga = harga;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getHarga() {
        return harga;
    }

    public String getNama() {
        return nama;
    }

    public String getType() {
        return type;
    }
    
}

class Iced extends Beverages {

    public Iced() {
        super("Iced");
    }
    
}

class Hot extends Beverages {

    public Hot() {
        super("Hot");
    }
    
}



