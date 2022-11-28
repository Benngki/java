/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exam_no2_oop;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Database {
    // staff account
    static ArrayList<Staff> listStaffAccounts = new ArrayList<>(); // list staff account  
            
    // order data
    static ArrayList<String> dataOrdersNama = new ArrayList<>(); // order nama
    static ArrayList<Integer> dataOrdersHarga = new ArrayList<>(); // order harga
    static ArrayList<Integer> dataOrdersQuantity = new ArrayList<>(); // order quantity
        
    // Food
    static ArrayList<Food> listAppetizer = new ArrayList<>();
    static ArrayList<Food> listDessert = new ArrayList<>();
    static ArrayList<Food> listMainCourse = new ArrayList<>();
    
    // Beverages
    static ArrayList<Beverages> listIced = new ArrayList<>();
    static ArrayList<Beverages> listHot = new ArrayList<>();
    
    static int subtotal;
    

    // food display
    
    public static void displayDataDessert(){
        System.out.println("Menampilkan Data Menu Dessert");
        for (int i = 0; i < listDessert.size(); i++) {
            System.out.println(i+1+". "+listDessert.get(i).getNama());
            System.out.println("   "+listDessert.get(i).getHarga());
        }
    }
    
    public static void displayDataMainCourse(){
        System.out.println("Menampilkan Data Menu Main Course");
        for (int i = 0; i < listMainCourse.size(); i++) {
            System.out.println(i+1+". "+listMainCourse.get(i).getNama());
            System.out.println("   "+listMainCourse.get(i).getHarga());
        }
    }
    
    public static void displayDataAppetizer(){
        System.out.println("Menampilkan Data Menu Appetizer");
        for (int i = 0; i < listAppetizer.size(); i++) {
            System.out.println(i+1+". "+listAppetizer.get(i).getNama());
            System.out.println("   "+listAppetizer.get(i).getHarga());
        }
    }
    
    // beverages display
    
    public static void displayDataIcedBeverages(){
        System.out.println("Menampilkan Data Menu Iced Beverages");
        for (int i = 0; i < listIced.size(); i++) {
            System.out.println(i+1+". "+listIced.get(i).getNama());
            System.out.println("   "+listIced.get(i).getHarga());
        }
    }
    
    public static void displayDataHotBeverages(){
        for (int i = 0; i < listHot.size(); i++) {
            System.out.println(i+1+". "+listHot.get(i).getNama());
            System.out.println("   "+listHot.get(i).getHarga());
        }
    }
    
    // display all data
    
    public static void displayAllData(){
        int no = 1;
        
        System.out.println("Menampilkan Data Menu Appetizer");
        for (int i = 0; i < listAppetizer.size(); i++) {
            System.out.println(no+". "+listAppetizer.get(i).getNama());
            System.out.println("> Rp. "+listAppetizer.get(i).getHarga());
            no++;
        }
        
        System.out.println("Menampilkan Data Menu Main Course");
        for (int i = 0; i < listMainCourse.size(); i++) {
            System.out.println(no+". "+listMainCourse.get(i).getNama());
            System.out.println("> Rp. "+listMainCourse.get(i).getHarga());
            no++;
        }   
        
        System.out.println("Menampilkan Data Menu Dessert");
        for (int i = 0; i < listDessert.size(); i++) {
            System.out.println(no+". "+listDessert.get(i).getNama());
            System.out.println("> Rp. "+listDessert.get(i).getHarga());
            no++;
        }             
        
        System.out.println("Menampilkan Data Menu Iced Beverages");
        for (int i = 0; i < listIced.size(); i++) {
            System.out.println(no+". "+listIced.get(i).getNama());
            System.out.println("> Rp. "+listIced.get(i).getHarga());
            no++;
        }
        
        System.out.println("Menampilkan Data Menu Hot");
        for (int i = 0; i < listHot.size(); i++) {
            System.out.println(no+". "+listHot.get(i).getNama());
            System.out.println("> Rp. "+listHot.get(i).getHarga());
            no++;
        }
    }
    
    // display data order
    public static void displayInvoice(){
        boolean temp;
        int unknown_menu = 0;
        
        System.out.println("----------------------------");
        System.out.println("Restaurant Indonesia Invoice");
        System.out.println("----------------------------");
        System.out.println("<< Data pesanan anda >>");
        System.out.println("Harga\tNama Item");
        System.out.println("-----\t---------");
        for (int i = 0; i < dataOrdersNama.size(); i++) {
            temp = false;
            for (int j = 0; j < listAppetizer.size(); j++) {
                if (listAppetizer.get(j).getNama().contains(dataOrdersNama.get(i))){
                    dataOrdersNama.set(i, listAppetizer.get(j).getNama());
                    dataOrdersHarga.add(listAppetizer.get(j).getHarga());

                    System.out.print(dataOrdersHarga.get(i));
                    System.out.println("\t"+dataOrdersNama.get(i));
//                    dataOrdersQuantity.add(listAppetizer.get(j).getNama())
                    subtotal += listAppetizer.get(j).getHarga();

                    temp = true;
                    break;
                }
            }         

            if (temp) continue;

            for (int j = 0; j < listMainCourse.size(); j++) {
                if (listMainCourse.get(j).getNama().contains(dataOrdersNama.get(i))){
                    dataOrdersNama.set(i, listMainCourse.get(j).getNama());
                    dataOrdersHarga.add(listMainCourse.get(j).getHarga());

                    System.out.print(dataOrdersHarga.get(i));
                    System.out.println("\t"+dataOrdersNama.get(i));
//                    dataOrdersQuantity.add(listMainCourse.get(j).getNama())
                    subtotal += listMainCourse.get(j).getHarga();

                    temp = true;
                    break;
                }
            }         

            if (temp) continue;         

            for (int j = 0; j < listDessert.size(); j++) {
                if (listDessert.get(j).getNama().contains(dataOrdersNama.get(i))){
                    dataOrdersNama.set(i, listDessert.get(j).getNama());
                    dataOrdersHarga.add(listDessert.get(j).getHarga());

                    System.out.print(dataOrdersHarga.get(i));
                    System.out.println("\t"+dataOrdersNama.get(i));
//                    dataOrdersQuantity.add(listDessert.get(j).getNama())
                    subtotal += listDessert.get(j).getHarga();

                    temp = true;
                    break;
                }
            }         

            if (temp) continue;         

            for (int j = 0; j < listIced.size(); j++) {
                if (listIced.get(j).getNama().contains(dataOrdersNama.get(i))){
                    dataOrdersNama.set(i, listIced.get(j).getNama());
                    dataOrdersHarga.add(listIced.get(j).getHarga());

                    System.out.print(dataOrdersHarga.get(i));
                    System.out.println("\t"+dataOrdersNama.get(i));
//                    dataOrdersQuantity.add(listIced.get(j).getNama())
                    subtotal += listIced.get(j).getHarga();

                    temp = true;
                    break;
                }
            }         

            if (temp) continue;         

            for (int j = 0; j < listHot.size(); j++) {
                if (listHot.get(j).getNama().contains(dataOrdersNama.get(i))){
                    dataOrdersNama.set(i, listHot.get(j).getNama());
                    dataOrdersHarga.add(listHot.get(j).getHarga());

                    System.out.print(dataOrdersHarga.get(i));
                    System.out.println("\t"+dataOrdersNama.get(i));
    //                    dataOrdersQuantity.add(listHot.get(j).getNama())
                    subtotal += listHot.get(j).getHarga();

                    temp = true;
                    break;
                }
            }         

            if (temp) continue;  

            unknown_menu++;
        }          
        
        System.out.println("----------------------------");
        System.out.println(">> Subtotal = %d ".formatted(subtotal));
        System.out.println("----------------------------");
    }
    
    // food delete
    
    public static void deleteDataAppetizer(int index){
        listAppetizer.remove(index);
    }
    
    public static void deleteDataMainCourse(int index){
        listMainCourse.remove(index);
    }
    
    public static void deleteDataDessert(int index){
        listDessert.remove(index);
    }
    
    // beverages delete
    
    public static void deleteDataIcedBeverages(int index){
        listIced.remove(index);
    }
    
    public static void deleteDataHotBeverages(int index){
        listHot.remove(index);
    }    
}

