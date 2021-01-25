package com.project5;

import java.util.Scanner;

public class ScanningText {
	
	
	public static void main(String args[])
	{
		String line, temp;
		System.out.println("Enter a single line of text ");
		Scanner sc = new Scanner(System.in);
		line = sc.nextLine();
		line = line.toLowerCase(); //convert to lowercase	
		line = line.replaceAll("[\\s\\p{Zs}]+", " ");   //make multi space to a whitespace
		line = line.trim();       //omit the whitespace at head and tail

		int ch, count, singleCharCnt=0;
		int ic,MAX = 0;
		int frequency[] = new int[26];
		
		for (ch='a'; ch <= 'z'; ch++){
			count = 0;
			int index = ch - 97;
			frequency[index] = 0;
			for (ic = 0; ic < line.length(); ic++){
				if(line.charAt(ic) == ch)  //count the specific char (a-z)
					count++;
			}
			frequency[index] = count;
			singleCharCnt += count;
		}
	
		String []emitspace = line.split(" "); //divide string into words by whitespace
		for(String item:emitspace){
			if(item.length()> MAX)
				MAX = item.length();		
		}
		
		/**************************** Output ********************************/
		
		System.out.println("\nThe line contains " + singleCharCnt + " letters");
		System.out.println("The line contains " +  emitspace.length + " string tokens");
		System.out.println("The longest token has " + MAX + " letters");
		System.out.println("The frequency of letters is " );
		for(ic = 'a'; ic < 'z'; ic++){
			if(frequency[ic-97] > 0){
				char c = (char)(ic-32);
				System.out.print(c + " -- " + frequency[ic-97]+"\n");
			}
		}
	   
	}

}
