/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exam_no2_oop;

import java.util.Scanner;

/**
 *
 * @author User
 */


public class UserManagement {
    static Scanner input = new Scanner(System.in);     
    static int pil, temp;   
    
    static void addFood(){
        System.out.println("Pilih jenis makanan :");
        System.out.println("1. Appetizer"); 
        System.out.println("2. Main Course");
        System.out.println("3. Dessert");
        System.out.print("Masukkan Pilihan : ");
        pil = input.nextInt();
            
        switch (pil) {
            case 1:                    
                Appetizer ap = new Appetizer();
                
                input.nextLine(); // agar input nama tidak terlewat
                System.out.print("Masukkan nama  : ");
                ap.setNama(input.nextLine());
                System.out.print("Masukkan harga : ");
                ap.setHarga(input.nextInt());
                
                Database.listAppetizer.add(ap);
                break;
            case 2:
                MainCourse mc = new MainCourse();
                
                input.nextLine(); // agar input nama tidak terlewat
                System.out.print("Masukkan nama  : ");
                mc.setNama(input.nextLine());
                System.out.print("Masukkan harga : ");
                mc.setHarga(input.nextInt());
                
                Database.listMainCourse.add(mc);                
                break;
            case 3:
                Dessert ds = new Dessert();
                
                input.nextLine(); // agar input nama tidak terlewat
                System.out.print("Masukkan nama  : ");
                ds.setNama(input.nextLine());
                System.out.print("Masukkan harga : ");
                ds.setHarga(input.nextInt());
                
                Database.listDessert.add(ds);                
                break;
            default:
                System.out.println("--- Pilihan tidak tersedia ---");
        }
    }      
    
    static void addBeverages(){
        System.out.println("Pilih jenis minuman :");
        System.out.println("1. Iced"); 
        System.out.println("2. Hot");
        System.out.print("Masukkan Pilihan : ");
        pil = input.nextInt();
            
        switch (pil) {
            case 1:
                Iced ib = new Iced();
                
                input.nextLine(); // agar input nama tidak terlewat
                System.out.print("Masukkan nama  : ");
                ib.setNama(input.nextLine());
                System.out.print("Masukkan harga : ");
                ib.setHarga(input.nextInt());
                
                Database.listIced.add(ib);
                break;
            case 2:
                Hot hb = new Hot();
                
                input.nextLine(); // agar input nama tidak terlewat
                System.out.print("Masukkan nama  : ");
                hb.setNama(input.nextLine());
                System.out.print("Masukkan harga : ");
                hb.setHarga(input.nextInt());
                
                Database.listIced.add(hb);
                break;
            default:
                System.out.println("--- Pilihan tidak tersedia ---");
        }
    }      
    
    // delete
    
    static void deleteFood() {
        System.out.println("Pilih jenis makanan yang akan dihapus :");
        System.out.println("1. Appetizer"); 
        System.out.println("2. Main Course");
        System.out.println("3. Dessert");
        System.out.print("Masukkan Pilihan : ");
        pil = input.nextInt();
        
        switch (pil) {
            case 1:
                if (!Database.listAppetizer.isEmpty()){
                    Database.displayDataAppetizer();
                    System.out.print("Hapus data nomor :");
                    temp = input.nextInt();

                    Database.deleteDataAppetizer(temp-1);                    
                }else {
                    System.out.println("--- Data kosong ---!");
                }
                break;
            case 2:
                if (!Database.listMainCourse.isEmpty()){
                    Database.displayDataMainCourse();
                    System.out.println("Hapus data nomor :");
                    temp = input.nextInt();

                    Database.deleteDataMainCourse(temp-1);                    
                }else {
                    System.out.println("--- Data kosong ---!");
                }
                break;
            case 3:
                if (!Database.listDessert.isEmpty()){
                    Database.displayDataDessert();
                    System.out.println("Hapus data nomor :");
                    temp = input.nextInt();

                    Database.deleteDataDessert(temp-1);                    
                }else {
                    System.out.println("--- Data kosong ---!");
                }
                break;
            default:
                System.out.println("--- Pilihan tidak tersedia ---");
        }
    }
    
    static void deleteBeverages(){
        System.out.println("Pilih jenis makanan yang akan dihapus :");
        System.out.println("1. Iced"); 
        System.out.println("2. Hot");
        System.out.print("Masukkan Pilihan : ");
        pil = input.nextInt();
        
        switch (pil) {
            case 1 -> {
                if (!Database.listIced.isEmpty()){
                    Database.displayDataIcedBeverages();
                    System.out.println("Hapus data nomor :");
                    temp = input.nextInt();
                    
                    Database.deleteDataIcedBeverages(temp-1);                    
                }else {
                    System.out.println("--- Data kosong ---!");
                }
            }
            default -> System.out.println("--- Pilihan tidak tersedia ---");
        }
    }
    
    // edit
    
    static void editFood() {
        System.out.println("Pilih jenis makanan yang akan dihapus :");
        System.out.println("1. Appetizer"); 
        System.out.println("2. Main Course");
        System.out.println("3. Dessert");
        System.out.print("Masukkan Pilihan : ");
        pil = input.nextInt();
        
        switch (pil) {
            case 1:
                if (!Database.listAppetizer.isEmpty()){
                    Database.displayDataAppetizer();
                    System.out.print("Edit data nomor :");
                    temp = input.nextInt();
                    
                    System.out.println("Masukkan data baru :");
                    input.nextLine(); // agar input nama tidak terlewat
                    System.out.print("Masukkan nama  : ");
                    Database.listAppetizer.get(temp-1).setNama(input.nextLine());
                    System.out.print("Masukkan harga : ");
                    Database.listAppetizer.get(temp-1).setHarga(input.nextInt());                    
                }else {
                    System.out.println("--- Data kosong ---!");
                }
                break;
            case 2:
                if (!Database.listMainCourse.isEmpty()){
                    Database.displayDataMainCourse();
                    System.out.print("Edit data nomor :");
                    temp = input.nextInt();
                    
                    System.out.println("Masukkan data baru :");
                    input.nextLine(); // agar input nama tidak terlewat
                    System.out.print("Masukkan nama  : ");
                    Database.listMainCourse.get(temp-1).setNama(input.nextLine());
                    System.out.print("Masukkan harga : ");
                    Database.listMainCourse.get(temp-1).setHarga(input.nextInt());                    
                }else {
                    System.out.println("--- Data kosong ---!");
                }
                break;
            case 3:
                if (!Database.listDessert.isEmpty()){
                    Database.displayDataDessert();
                    System.out.print("Edit data nomor :");
                    temp = input.nextInt();
                    
                    System.out.println("Masukkan data baru :");
                    input.nextLine(); // agar input nama tidak terlewat
                    System.out.print("Masukkan nama  : ");
                    Database.listDessert.get(temp-1).setNama(input.nextLine());
                    System.out.print("Masukkan harga : ");
                    Database.listDessert.get(temp-1).setHarga(input.nextInt());                    
                }else {
                    System.out.println("--- Data kosong ---!");
                }
                break;
            default:
                System.out.println("--- Pilihan tidak tersedia ---");
        }
        
    }
    
    static void editBeverages() {
        System.out.println("Pilih jenis makanan yang akan diedit :");
        System.out.println("1. Iced"); 
        System.out.println("2. Hot");
        System.out.print("Masukkan Pilihan : ");
        pil = input.nextInt();
        
        switch (pil) {
            case 1 -> {
                if (!Database.listIced.isEmpty()){
                    Database.displayDataIcedBeverages();
                    System.out.print("Edit data nomor :");
                    temp = input.nextInt();
                    
                    System.out.println("Masukkan data baru :");
                    input.nextLine(); // agar input nama tidak terlewat
                    System.out.print("Masukkan nama  : ");
                    Database.listIced.get(temp-1).setNama(input.nextLine());
                    System.out.print("Masukkan harga : ");
                    Database.listIced.get(temp-1).setHarga(input.nextInt());
                }else {
                    System.out.println("--- Data kosong ---!");
                }
            }
            case 2 -> {
                if (!Database.listHot.isEmpty()){
                    Database.displayDataHotBeverages();
                    System.out.print("Edit data nomor :");
                    temp = input.nextInt();
                    
                    System.out.println("Masukkan data baru :");
                    input.nextLine(); // agar input nama tidak terlewat
                    System.out.print("Masukkan nama  : ");
                    Database.listHot.get(temp-1).setNama(input.nextLine());
                    System.out.print("Masukkan harga : ");
                    Database.listHot.get(temp-1).setHarga(input.nextInt());
                }else {
                    System.out.println("--- Data kosong ---!");
                }
            }
            default -> System.out.println("--- Pilihan tidak tersedia ---");
        }
    }
    
}

class Staff{
    private String username;
    private String password;
    private String type;    

    public Staff(String username, String password, String type) {
        this.username = username;
        this.password = password;
        this.type = type;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public String getType() {
        return type;
    }

    public String getUsername() {
        return username;
    }
    
}