
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Random ;
public class Sort {

	
	public number [] arrayNum ;
	public int capacity;
	public int size;
	
	public Sort (String filename)
	{
		size = 0;
		capacity=50; 
		arrayNum = new number[capacity];
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
        	int i = infile.nextInt();
        	
        	
        	arrayNum [size++] = new number (i);
        }
        
        infile.close ( );
        
	}
	
	
	public static void main(String[] args) 
	{
		Sort a = new Sort ("1-50.txt");
		
		System.out.println (a);
		
		Sort b = new Sort ("50-1.txt");
		
		System.out.print(b+"\n");
		
		Sort c = new Sort ("random.txt");
		
		System.out.print(c.arrayNum[0].num);
		
		int []newArray = new int [50];
		
		for (int i=0; i<50; i++)
		{
			newArray[i] = c.arrayNum[i].num;
		
		}
		
		InsertionSort(newArray);
		
		for (int i=49; i>=0; i--)
		{
			System.out.print("\n"+newArray[i]);
		}
		
		
	}
	
	public String toString ( )
    {
       String outstring = "";
       for (int i = 0; i <50 ; i++)
       {
           outstring += arrayNum[i];
          
       }
       return outstring;
    }

	public static void InsertionSort(int [ ] list)
	{
	     int j;                    
	     int key;                
	     int i;  

	     for (j = 1; j < list.length; j++)    
	    {
	           key = list[j];
	           for(i = j - 1; (i >= 0) && (list[i] < key); i--)   
	          {
	                list[i+1] = list[i]; 
	          }
               
	          list[i+1] = key;   
	        
	     }
	}
	
	
	
}

