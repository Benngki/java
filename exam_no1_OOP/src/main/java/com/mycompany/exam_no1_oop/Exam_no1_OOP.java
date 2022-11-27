/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.exam_no1_oop;

import java.util.Scanner; 

/**
 *
 * @author User
 */
public class Exam_no1_OOP {
    public static Scanner input = new Scanner(System.in);
    public static String my_str;
    
    public static boolean isVocal(char ch){      
        boolean temp = false;
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' 
            || 
            ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
            temp = true;
        } 
        return temp;
    }
    
    public static void encryptStr(String[][] arr_str){
        for (int i = 0; i < arr_str.length; i++) {
            if (arr_str[i][0] == null) break;
            for (int j = 0; j < arr_str[i].length; j++) {
                if (arr_str[i][j] == null) break;
                
                char ch = arr_str[i][j].charAt(0);
                int ascii = ch;
                
                if (isVocal(ch)) {

                    int temp = i+1+(int) Math.pow(i+1, 2)+ascii;
                    
                    arr_str[i][j] = Integer.toString(temp);
                }
            }        
        }
    }    
    
    public static void display(String[][] arr_str){
        int r=0, c=0;
        while (arr_str[r][0] != null) {
            if (arr_str[r][c] == null){
                r++;c=0;
                System.out.print(" ");
                continue;
            }
            System.out.print(arr_str[r][c]);
            c++;
        }
    }
    
    public static void main(String[] args) {
        
        System.out.print("Masukkan string : ");
        my_str = input.nextLine();     
        
        String arr_str[][] = new String[200][200];
        for (int i = 0, r=0, c=0; i < my_str.length(); i++, c++) {
            if (my_str.charAt(i) == ' ') {
                r++;c=-1;
                continue;
            }
            arr_str[r][c] = Character.toString(my_str.charAt(i));
        }
        
        encryptStr(arr_str); 
        
        display(arr_str);
    }    
}