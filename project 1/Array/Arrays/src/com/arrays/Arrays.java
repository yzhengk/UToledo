package com.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class Arrays {



public static void main(String[] args) throws IOException{
	System.out.print("Enter the size:");
	Scanner sc = new Scanner(System.in);
	int size = sc.nextInt();
	int[] arr = new int[size];
	System.out.print("Enter " + size + " integers (end by -1):");
	int num, cnt = 0;
	while(sc.hasNext())
	{
		num = sc.nextInt();
		if(num == -1)
			break;
		arr[cnt++] = num;
	}
	for(int i = 0; i < size/2; i++)
	{
		int tmp = arr[i];
		arr[i] = arr[size - i - 1];
		arr[size - i - 1] = tmp;
	}
	
   System.out.print("Output:");
	for(int i = 0; i < size; i++)
	{
		System.out.print(" " + arr[i]);
	}
		
	
	
	
}
}