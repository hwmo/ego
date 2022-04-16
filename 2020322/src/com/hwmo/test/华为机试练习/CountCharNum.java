package com.hwmo.test.华为机试练习;

import java.util.Scanner;

public class CountCharNum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String c = scanner.nextLine();


        int count = 0;

        char[] chars = str.toCharArray();

        for(int i = 0; i < chars.length; i++){
            if(c.equalsIgnoreCase(chars[i]+"")){
                count++;
            }
        }
        System.out.println(count);
    }

    public static boolean matchLetterDigit(String str){
        if(str == null){
            return false;
        }
        String regex = "^[a-z0-9A-Z]+$";
        return str.matches(regex);
    }

}
