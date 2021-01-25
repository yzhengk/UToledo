package com.project5;

import java.util.Scanner;

public class Validate {
	public static void main(String[] args){
		System.out.println("Please enter the phone numbers");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		boolean flag = isValid(input);
		if(flag){
			System.out.println("Yes, it's valid");
		}
		else{
			System.out.println("No, it's invalid");
		}
	}
	
	public static boolean isValid(String inputString){
		int fixedLen = 12;
		String newString = inputString.trim(); //去掉字符串前后的空格
	   if(newString.length()!= fixedLen){
		   return false;
	   }
	   else {
		   for(int i=0; i < fixedLen; i++){
			   char ch = newString.charAt(i);
			   if(ch != '-' && (ch < '0' || ch > '9')){
				   return false;
			   }
			   else if(ch == '-' && (i != 3 && i != 7)){
				   return false;
			   }
		   }
	   }
		   return true;
	}
}
