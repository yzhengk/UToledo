package com.Phonebook;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Phonebook {
	public String name, number, notes;
	public static int size = 0, initial;   
	public static Phonebook[] entryList = new Phonebook[200];
	
	
	public static void readPhoneBook (String FileName)
		throws Exception{
		for(int i=0; i<entryList.length; i++){
			entryList[i] = new Phonebook();
		}
		//try {
			String encoding = "GBK";
			File file = new File(FileName);
			if(file.isFile() && file.exists()){
				InputStreamReader read = new InputStreamReader(
				new FileInputStream(file),encoding); 
				
				BufferedReader br = new BufferedReader(read);
				String text = null;
				
				while((text = br.readLine()) != null) {
					//System.out.println(text);
					text = text.trim();
					String[] temp = text.split("\t");	
					
					entryList[size].name = temp[0];
					entryList[size].number = temp[1];
					
					if(temp.length == 3){
						entryList[size].notes = temp[2];	
					}
					else {
						entryList[size].notes = "";
					}
					size++;	
					//System.out.println("Size:" + size);
					
				}
				initial = size; 
				read.close();
			}else{
				System.out.println("Cannot find the file!");
			}
		//} //catch (Exception e){
			//System.out.println("Error when reading the source file!");
			//e.printStackTrace();
	//	}
		
		//finally{
		//	System.out.println(entryList[0].name + entryList[0].number);
		//}
}
	public static int operateEntry()	{
		System.out.print("Command: ");
		Scanner sc = new Scanner(System.in);
		String text = sc.nextLine();
		String[] input = text.split(" "); 
		
		if(input[0].equals("help")){
			System.out.println("\t*************************************************************************");
			System.out.println("\t*\t#1. For adding someone's information, the format is \"e name\"  \t*");
			System.out.println("\t*\twhere 'e' indicate that you want enter, and 'name' is some-  \t*");
			System.out.println("\t*\tone's name you want to add, between 'e' and 'name' there is  \t*");
			System.out.println("\t*\ta space.Then follow the notice to enter the number and notes  \t*");
			System.out.println("\t*\t#2. For finding someone's information, the format is \"f name\"  \t*");
			System.out.println("\t*\twhere the name is case-insensitive, e.g. You can search for   \t*");
			System.out.println("\t*\t\"Johnson\" by entering \"johnson\" or \"JOHNSON\",etc.\t\t*");
			System.out.println("\t*\t#3. For showing all the entries, you need just to enter 'l'  \t*");
			System.out.println("\t*\t#4. Enter 'q' for quit the program, if you have added new \t*");
			System.out.println("\t*\tentry, it will be stored into the sourcefile.\t\t\t*");
			System.out.println("\t*************************************************************************\n");
			return 1;
		}
		else if(input[0].length() > 1){
			System.out.println("Wrong code, please check your input!\n");
			return 1;
		}
			
		char ch = input[0].charAt(0);
		switch(ch) {
		case 'e':
			entryList[size].name = input[1].trim(); 
			System.out.print("Enter number: ");	
			String number = sc.nextLine().trim(); 
			while(!validatePhoneNumber(number)){
				System.out.println("Invalid phone number, please enter again...");
				System.out.print("Enter number: ");	
				number = sc.nextLine();
			}
				entryList[size].number = number;
			System.out.print("Enter notes: ");
			String notes = sc.nextLine();
			if(notes != null)
				entryList[size].notes = notes;
			else
				entryList[size].notes = "";
			
			size++;
			
			break;
		case 'f':
			String name = input[1].trim();	
			name = name.toLowerCase(); 
			boolean found = false;     
			for(int i=0; i<size; i++){
				String temp = entryList[i].name;
				temp = temp.toLowerCase();  
				if(temp.equals(name)){
					found = true;
					System.out.println("-- "+ entryList[i].name);
					System.out.println("-- "+ entryList[i].number);
					if(entryList[i].notes != "")
						System.out.println("-- "+ entryList[i].notes);
				}
			}		
			if(!found)  
				System.out.println("** No entry with code " + name);
			break;
		case 'l':
			listAllEntriess();
			break;
		case 'q':
			return 0;
		default:
			System.out.println("Wrong code, please check your input!");
			break;
		}
		System.out.print("\n");
		return 1;
		
	}

	public static void listAllEntriess(){
		if(size == 0){
			System.out.println("No entry for now.");
			return;
		}
		for(int i=0; i<size; i++){
			System.out.println("## Entry "+ (i+1));
			System.out.println("-- "+ entryList[i].name);
			System.out.println("-- "+ entryList[i].number);
			if(entryList[i].notes != "")
				System.out.println("-- "+ entryList[i].notes); //would not show up if no notes is entered
			System.out.print("\n");
		}
	}
	
	public static void storePhoneBook (String FileName)
	throws Exception{
		PrintStream P = new PrintStream(FileName);
		
		for (int i=0; i <size; i++){
			P.println(entryList[i].name + "\t" +
					  entryList[i].number + "\t" +
					  entryList[i].notes );
		}
		P.close();
		System.out.println("Phonebook stored.");
	}
	
	public static boolean validatePhoneNumber(String phoneNumber){ 
		
		String regex = "(^\\d{3}-\\d{3}-\\d{4}$)|(^\\(\\d{3}\\)\\d{3}-\\d{4}$)|(^\\d{3}-\\d{4}$)" ;
		Pattern pat = Pattern.compile(regex);
		Matcher ma = pat.matcher(phoneNumber);
		boolean rs = ma.find();
		return rs;
	}
	
	public static void main(String[] args){
		String filename = "info1.txt";
		
		try{
			readPhoneBook(filename);
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Codes are entered as 1 to 8 characters.");
		System.out.println("Use \"e\" for enter, \"f\" for find, \"l\" to list, \"q\" to quit, \"help\" for all details.");
		while(operateEntry() == 1);
			 
		try{
		storePhoneBook("info1.txt");
		}catch(Exception e){
			e.printStackTrace(); 
		}
		if(initial != size){ 
			System.out.println("The external file is updated with entries added.");
		}
		
	}
		
}



