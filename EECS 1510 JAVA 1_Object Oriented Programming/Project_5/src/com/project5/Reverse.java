package com.project5;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

//Are we allowed to use the ArrayList for a array with dynamic length?
public class Reverse {
	public static void main(String []args){
		int[] positive = new int[100];  //默认为输入不超过100个数
		System.out.println("Please enter the integers:");
		Scanner input = new Scanner(System.in);
		int temp, size=0;
		temp = input.nextInt();
		while(temp != -1){
			positive[size] = temp;
			size++;
			temp = input.nextInt();
		}
		
		int[] tempArray = new int[size]; //需要另开一个数组是因为输入的数不一定为100,这样positive中的整数个数小于100
		for(int i=0; i<size; i++){
			tempArray[i] = positive[i]; //这里其实可以直接直接交换得到转换后的数组,但是要求里要用到reverse函数
		}
		reverse(tempArray);
		int total = 0;
		System.out.println("The values in reverse order are");
		for(int i=0; i<size; i++){
			System.out.print("\t" + tempArray[i]);
			total += tempArray[i];
		}
		System.out.print("\nThe average is " + total + "/" + size + "=" );
		double divide = (double)total/size;           //整型转为double型
		DecimalFormat df = new DecimalFormat("#.0");  //保留一位小数
		System.out.println(df.format(divide));
	}
	
	public static void reverse(int[] A){
		int len = A.length-1;
		int half = len/2;
		for(int i=0; i <= half; i++){
			int temp = A[i];
			A[i] = A[len-i];
			A[len-i] = temp;
		}		
	}

}
