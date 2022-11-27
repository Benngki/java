/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exam_no1_oop;

import static com.mycompany.exam_no1_oop.Exam_no1_OOP.isVocal;
import static com.mycompany.exam_no1_oop.Exam_no1_OOP.output_str;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class master {
    //    public static void inputStr(String[] arr_str, ArrayList<ArrayList<String>> arr_char){
    public static void encryptStr(String[] arr_str, char[][] arr_char){
        int index = 0;
        for (int i = 1; i < arr_str.length+1; i++) {
            for (int j = 0; j < arr_str[i-1].length(); j++) {
                char ch = arr_str[i-1].charAt(j);
                int ascii = ch;
                
                if (isVocal(ch)) {

                    int temp = i+(int) Math.pow(i, 2)+ascii;
                    
//                    index++;
//                    arr_char[i-1][index] = ch;
//                    arr_char.add(ch);
    
                    output_str = output_str.concat(Integer.toString(temp));
                }
                else{
                    output_str = output_str.concat(Character.toString(ch));
                }
            }        
            index = 0;
            output_str = output_str.concat(" ");
        }
    }    
    
    // origin v2
//    public static void main(String[] args) {
//        
//        System.out.println("Masukkan string : ");
//        my_str = input.nextLine();     
//        
//        String splitted_str[] = my_str.split("\\s+"); // memisahkan input string by spasi
//        
//        char arr_char[][] = new char[splitted_str.length][];
////        String arr_char[][] = new String[splitted_str.length][];
//        
//        inputStr(splitted_str, arr_char); 
//        
//        System.out.println(output_str);         
//    }
    
//     mod
//    public static void main(String[] args) {
        
//        ArrayList<ArrayList<String>> arr_char = new ArrayList<>(); // array 2 dimensi untuk menyimpan 
//        my_str = input.nextLine();               
//        
//        for (int i = 0; i < my_str.length(); i++) {
//            if (my_str.charAt(i) == ' ') continue;
//            arr_char.get(i).add(my_str.charAt(i))
//        }    
//    }
    
}
}


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
    public static String my_str, output_str = "";
    
    public static boolean isVocal(char ch){      
        boolean temp = false;
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' 
            || 
            ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
            temp = true;
        } 
        return temp;
    }
    
    public static void encryptStr(String[] arr_str, String[][] arr_char){
        int index = 0;
        for (int i = 0; i < arr_str.length; i++) {
            for (int j = 0; j < arr_str[i].length(); j++) {
                char ch = arr_str[i].charAt(j);
                int ascii = ch;
                
                if (isVocal(ch)) {

                    int temp = i+(int) Math.pow(i, 2)+ascii;
                    
                    index++;
                    arr_char[i][j] = Character.toString(ch);
    
                    output_str = output_str.concat(Integer.toString(temp));
                }
                else{
                    output_str = output_str.concat(Character.toString(ch));
                }
            }
            index = 0;
            output_str = output_str.concat(" ");
        }
    }    
    
    public static void main(String[] args) {
        
        System.out.println("Masukkan string : ");
        my_str = input.nextLine();     
        
        String splitted_str[] = my_str.split("\\s+");
        
        String arr_char[][] = new String[200][200];
        
        encryptStr(splitted_str, arr_char); 
        
        System.out.println(output_str);         
    }    
}