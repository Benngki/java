/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.exam_no2_oop;

import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author User
 */
public class Exam_no2_OOP {
    static Scanner input = new Scanner(System.in);
    
    static void pay(){
        int pil, int_temp;
        String str_temp;
        
        do {
            System.out.println("Pilihan metode pembayaran :");
            System.out.println("1. Cash");
            System.out.println("2. BCA (Bank Transfer)");
            System.out.println("3. Gopay");
            System.out.print("Masukkan pilihan : ");
            pil = input.nextInt();

            switch (pil) {
                case 1: // cash
                    System.out.print("Masukkan jumlah uang anda : ");
                    int_temp = input.nextInt();

                    if (int_temp < Database.subtotal){
                        System.out.println("--- Maaf, uang anda kurang! ---");
                    }else {
                        System.out.println("Kembalian anda : %d".formatted(int_temp - Database.subtotal));
                        System.out.println("--- Pembayaran berhasil! ---");
                        System.out.println("--- Terima Kasih ---");
                    }
                    
                    break;
                case 2: // BCA bank transfer
                    do {
                        System.out.println("Silahkan transfer ke rekening berikut sesuai dengan total harga pesanan anda!");
                        System.out.print("Sudah transfer [y/t]? ");
                        str_temp = input.next();

                        if (str_temp.equals("y")) {
                            System.out.println("--- Pembayaran berhasil! ---");
                            System.out.println("--- Terima Kasih ---");
                            break;
                        }                  
                    } while (true);
                    break;
                case 3: // gopay
                    input.nextLine();
                    System.out.print("Masukkan no telepon anda yang terdaftar di Gopay :");
                    str_temp = input.nextLine();
                    
                    System.out.println("--- Pembayaran berhasil! ---");
                    System.out.println("--- Terima Kasih ---");
                    break;
                default:
                    throw new AssertionError();
            }
            break;
        } while (true);
    }    
    
    static boolean loginVerify(String username, String password){
        String tempUser, tempPassword;
        for (int i = 0; i < Database.listStaffAccounts.size(); i++) {
            tempUser = Database.listStaffAccounts.get(i).getUsername();
            tempPassword = Database.listStaffAccounts.get(i).getPassword();
            if (username.equals(tempUser) && password.equals(tempPassword)){
                return true;
            }            
        }
        return false;
    }
    
    static void displayMainMenu(){
        int pil;
        
        do {
            System.out.println("=== Restaurant Indonesia ===");
            System.out.println("Masuk sebagai :");
            System.out.println("1. User Management");
            System.out.println("2. Customer");
            System.out.println("3. Exit");
            System.out.print("Masukkan pilihan : ");
            pil = input.nextInt();
            
            do {
                switch (pil) {
                    case 1: // user management
                        String username, password;
                        input.nextLine();
                        System.out.println("--- Silahkan login terlebih dahulu! ---");
                        System.out.print("Masukkan username : ");
                        username = input.nextLine();
                        System.out.print("Masukkan password : ");
                        password = input.nextLine();
                        
                        if (loginVerify(username, password)){
                            System.out.println("User Management Menu :");
                            System.out.println("1. Add menu");
                            System.out.println("2. Delete Menu");
                            System.out.println("3. Edit menu");
                            System.out.print("Masukkan pilihan : ");
                            pil = input.nextInt();     

                            switch (pil) {
                                case 1 -> {  // add menu
                                    System.out.println("1. Food");
                                    System.out.println("2. Drink");
                                    System.out.print("Masukkan pilihan : ");        
                                    pil = input.nextInt();

                                    switch (pil) {
                                        case 1 -> UserManagement.addFood();
                                        case 2 -> UserManagement.addBeverages();
                                    }
                                }
                                case 2 -> {  // delete menu
                                    System.out.println("1. Food");
                                    System.out.println("2. Drink");
                                    System.out.print("Masukkan pilihan : ");        
                                    pil = input.nextInt();

                                    switch (pil) {
                                        case 1 -> UserManagement.deleteFood();
                                        case 2 -> UserManagement.deleteBeverages();
                                    }
                                }
                                case 3 -> {  // edit menu
                                    System.out.println("1. Food");
                                    System.out.println("2. Drink");
                                    System.out.print("Masukkan pilihan : ");        
                                    pil = input.nextInt();

                                    switch (pil) {
                                        case 1 -> UserManagement.editFood();
                                        case 2 -> UserManagement.editBeverages();
                                    }
                                }

                                default -> throw new AssertionError();
                            }
                        }
                        else System.out.println("--- Username atau password salah! ---");
                        
                        break;
                    case 2 : // customer
                        do {
                            String temp;
                            int count=0;
                            
                            System.out.println("== Daftar Menu Restaurant ==");
                            Database.displayAllData();
                            
                            // choose menu 
                            
                            do {
                                if (count > 0) System.out.println("Ketik -1 untuk selesai memesan");  
                                System.out.print("Pilih nama menu : ");
                                if (count == 0) input.nextLine();
                                temp = input.nextLine();
                                
                                if (!temp.equals("-1")) Database.dataOrdersNama.add(temp);
                                
                                count++;
                            } while (!temp.equals("-1"));
                            
                            // display invoice
                            
                            Database.displayInvoice();
                            
                            // pay
                            if (Database.subtotal != 0) pay();
                            else System.out.println("--- Subtotal masih kosong! ---");                            
                            
                            break;
                        } while (true);
                        break;
                    case 3:
                        System.exit(0);
                        System.out.println("--- Terima Kasih ---");
                        break;
                    default:
                        System.out.println("--- Pilihan tidak ada ---");
                        break;
                }
                break;      
            } while (true);
        } while (true);
    }
    
    public static void main(String[] args) {  
        // user managementaccount 
        Staff waiters = new Staff("waiters", "ws123", "Waiters");
        Staff chef = new Staff("cheff", "cf456", "Cheff");
        Staff fnc_dprt = new Staff("fndprt", "fd789", "Financial Depart");
        Database.listStaffAccounts.add(waiters);
        Database.listStaffAccounts.add(chef);
        Database.listStaffAccounts.add(fnc_dprt);
        
        // restaurant menu default
        // food
        
        // appetizer
        Appetizer ap = new Appetizer();
        ap.setNama("Bakwan");
        ap.setHarga(1000);
        Database.listAppetizer.add(ap); // bakwan
        
        ap = new Appetizer();
        ap.setNama("Lumpia");
        ap.setHarga(1000);
        Database.listAppetizer.add(ap); // lumpia
        
        ap = new Appetizer();
        ap.setNama("Martabak Telur");
        ap.setHarga(25000);
        Database.listAppetizer.add(ap); // martabak telur
        
        // main course
        MainCourse mc = new MainCourse();
        mc.setNama("Nasi Goreng");
        mc.setHarga(15000);
        Database.listMainCourse.add(mc); // Nasi Goreng
        
        mc = new MainCourse();
        mc.setNama("Bakso Sapi");
        mc.setHarga(13000);
        Database.listMainCourse.add(mc); // Bakso sapi
        
        mc = new MainCourse();
        mc.setNama("Nasi Rendang Sapi");
        mc.setHarga(16000);
        Database.listMainCourse.add(mc); // Nasi rendang sapi
        
        // dessert
        Dessert ds = new Dessert();
        ds.setNama("Martabak Manis");
        ds.setHarga(25000);
        Database.listDessert.add(ds); // Martabak Manis
        
        ds = new Dessert();
        ds.setNama("Pukis Keju");
        ds.setHarga(17000);
        Database.listDessert.add(ds); // pukis keju
        
        ds = new Dessert();
        ds.setNama("Pisang Goreng");
        ds.setHarga(2000);
        Database.listDessert.add(ds); // Pisang Goreng
        
        
        // Beverages
        
        // iced
        Iced ib = new Iced();
        ib.setNama("Es Teh");
        ib.setHarga(5000);
        Database.listIced.add(ib); // es teh
        
        ib = new Iced();
        ib.setNama("Es Cincau");
        ib.setHarga(5000);
        Database.listIced.add(ib); // Es Cincau
        
        ib = new Iced();
        ib.setNama("Es Cappucino");
        ib.setHarga(8000);
        Database.listIced.add(ib); // Es Cappucino
        
        // hot
        Hot hb = new Hot();
        hb.setNama("Kopi Susu Panas");
        hb.setHarga(7000);
        Database.listHot.add(hb); // kopi susu
        
        hb = new Hot();
        hb.setNama("Teh Hangat");
        hb.setHarga(4000);
        Database.listHot.add(hb); // teh hangat
        
        hb = new Hot();
        hb.setNama("Coklat Panas");
        hb.setHarga(6000);
        Database.listHot.add(hb); // coklat panas
       
        displayMainMenu();
        
    }
}