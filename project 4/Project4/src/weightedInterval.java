import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class weightedInterval {
	
	public static void main(String[] args) throws FileNotFoundException{
		int i,j;
		String FileName;
		FileName ="weightInterval.txt";
		File f = new File(FileName);
		Scanner fileIn = new Scanner(f);
		int[] Start = new int[100];
		int[] Finish = new int[100];
		int[] Weight = new int[100];
		i=0;
		while (fileIn.hasNext()){
			Start[i]=fileIn.nextInt();
			Finish[i]=fileIn.nextInt();
			Weight[i]=fileIn.nextInt();
			i++;
		}
	    i=0;
	    while(i<9){
	    System.out.println(Start[i]+","+Finish[i]+","+Weight[i]);
	    i++;
	    }
	    
	    int Jobs[]= new int[8];
	    j=0;
	    i=0;
	    while(i!=7){
	    	Jobs[i]=i;
	    	i++;
	    }
	    int M[] = new int[8];
	    int N[] = new int[8];
	    
	    i=0; j=0;
	    while(j!=8){
	    	i=0;
	    while(i!=8){
	    	if (Start[j]>= Finish[i]){
	    		N[j]=Math.max(Finish[i],Start[j]);
	    	}
	    	i++;
	     	}
	        j++;    
	    }
	    j=0;
	    while(j<=7){
	    	if(j==0){M[j] =0;}
	    	if(j>0){M[j]=Math.max(Weight[j]+Weight[N[j]],M[j-1]);}
	    	j++;
	    	
	    }
        System.out.println(Arrays.toString(N));
        System.out.println(Arrays.toString(M));
        System.out.println("Optimal Value:"+ N[7]);
	    	
	    	
	    }
    }


	