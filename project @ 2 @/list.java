package com.stablemarriage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class list 
{
	public boy [] BoyList;
	public girl [] GirlList;
	public int capacity;
	public int size;

	int i = 0;
	int j = 0;
	
	public list(String filename)
	{
		size = 0;
		capacity=5; 
		BoyList = new boy[capacity];
		GirlList = new girl[capacity];
        Scanner infile = null;
        
        try
        {
            infile = new Scanner (new File (filename));
        }
        catch (FileNotFoundException x)
        {
            System.exit (0);
        }

        
        while (infile.hasNext ( ))
        {
        	String oneLine = "";

        	oneLine = infile.nextLine ( );
        	oneLine = oneLine.trim ( );
        	if (oneLine.equals ("<boys>"))
	               ;
        	else if (oneLine.equals ("</boys>"))
        	return;

        	else if (oneLine.equals ("<boy>"))
        	{
        	
        	   	oneLine = infile.nextLine ( );
           		oneLine = oneLine.trim ( );
           		String name = oneLine.substring(6, oneLine.indexOf("</name>"));
           		//System.out.println(name);
           		oneLine = infile.nextLine ( );
           		oneLine = oneLine.trim ( );
           		String prefer = oneLine.substring(8, oneLine.indexOf("</prefer>"));
           		//System.out.println(preder);
           		
           		boy newBoy = new boy (name, prefer);
           		System.out.println(newBoy);
			
			    BoyList[i]= newBoy;
			    i++;
        	}
        	
        	if (oneLine.equals ("<girls>"))
	               ;
        	else if (oneLine.equals ("</girls>"))
        		return;

        	else if (oneLine.equals ("<girl>"))
        	{
     	
        	   	oneLine = infile.nextLine ( );
           		oneLine = oneLine.trim ( );
           		String name = oneLine.substring(6, oneLine.indexOf("</name>"));
           		//System.out.println(name);
           		oneLine = infile.nextLine ( );
           		oneLine = oneLine.trim ( );
           		String prefer = oneLine.substring(8, oneLine.indexOf("</prefer>"));
           		//System.out.println(preder);
           		
           		girl newGirl = new girl (name, prefer);
           		System.out.println(newGirl);
			
			    GirlList[j]= newGirl;
			    j++;
        	}
        		
        }
        infile.close ( );
        
	}

}
