package com.project5;
import java.util.Scanner;

public class BinaryConversion {
	
	public static void main(String []args){
		
		String input;	
		while(true){
			System.out.println("Enter a binary number");
			Scanner sc = new Scanner(System.in);
			input = sc.nextLine();
			if(input.equals("-1")){
				System.out.println("All set!");
				break;
			}
			else {
				int result = binaryToDecimal(input);
				System.out.println("Conversion to decimal: " + result);
			}
						
		}
		
	}
	
	public static int binaryToDecimal (String binaryString){
		int size = binaryString.length();
		int i, temp = size;
		int result = 0;
		for(i = 0; i < size; i++){
			temp = temp - 1;
			if(binaryString.charAt(i) == '1'){	
				result += mypow(2, temp);
			}		
		}
		return result;
	}
	
	public static int mypow(int d, int m){
		int result = 1;
		int temp = m;
		while(temp != 0){
			result = result * d;
			temp--;
		}
		return result;
	}

}
