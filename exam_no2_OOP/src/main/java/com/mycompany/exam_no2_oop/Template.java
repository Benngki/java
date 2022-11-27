/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exam_no2_oop;

import static com.mycompany.exam_no2_oop.UserManagement.input;
import static com.mycompany.exam_no2_oop.UserManagement.pil;
import static com.mycompany.exam_no2_oop.UserManagement.temp;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Template {
}

clas menu {
    
}

class FoodTemplate {
    
    public static void edit(ArrayList<Food> data){
        if (!data.isEmpty()){
            System.out.println("Edit data nomor :");
            temp = input.nextInt();

            
        }else {
            System.out.println("--- Data kosong ---!");
        }
    }
    
    public static void display(ArrayList<Food> data){
        System.out.println("Menampilkan Data Menu Hot");
        for (int i = 0; i < data.size(); i++) {
            System.out.println(i+1+". "+data.get(i).getNama());
            System.out.println("   "+data.get(i).getHarga());
        }
    }
    
    public static int header(){
        int pil;
        System.out.println("Pilih jenis makanan yang akan dihapus :");
        System.out.println("1. Appetizer"); 
        System.out.println("2. Main Course");
        System.out.println("3. Dessert");
        System.out.print("Masukkan Pilihan : ");
        pil = input.nextInt();
        return pil;
    }
}
