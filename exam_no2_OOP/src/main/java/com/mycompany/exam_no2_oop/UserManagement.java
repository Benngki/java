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
                throw new AssertionError();
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
                throw new AssertionError();
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
                throw new AssertionError();
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
            default -> throw new AssertionError();
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
                    System.out.println("Edit data nomor :");
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
                    System.out.println("Edit data nomor :");
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
                    System.out.println("Edit data nomor :");
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
                throw new AssertionError();
        }
        
    }
    
    static void editBeverages() {
        
    }
    
}

class User{
    private String user;
    private String password;

    public User(String user, String password) {
        this.user = user;
        this.password = password;
    }
    
}

class Login{
    
    public static run(){
        
    }
    
//    String username, password;
//    int pil;
//    System.out.println("Login sebagai :");
//    System.out.println("1. Admin"); // restaurant user
//    System.out.println("2. Customer"); // customer user 
//    System.out.print("Masukkan pilihan : ");
//    pil = input.nextInt();// input pilihan user
//    switch (pil) {
//        case 1:
//            System.out.print("Username :");
//            username = input.nextLine();
//            System.out.print("Password :");
//            password = input.nextLine();
//
//            break;
//        case 2:
//            break;
//        default:
//            System.out.println("=== Pilihan tidak ada ===");
//    }

}