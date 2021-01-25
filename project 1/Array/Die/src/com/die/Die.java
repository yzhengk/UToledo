package com.die;
public class Die {
	private int value;
  Die(int val)
  {
	  value = val;
  }
  public void draw()
  {
	  switch(this.value)
	  {
	  case 1:
		  System.out.println("*");
		  break;
	  case 2:
		  System.out.println("*");
		  System.out.println("*");
		  break;
	  case 3:
		  System.out.println(" *");
		  System.out.println("* *");
		  break;
	  case 4:
		  System.out.println("* *");
		  System.out.println("* *");
		  break;
	  case 5:
		  System.out.println("* *");
		  System.out.println(" *");
		  System.out.println("* *");
		  break;
	  case 6:
		  System.out.println("* *");
		  System.out.println("* *");
		  System.out.println("* *");
		  break;
		  
	  }
  }
}
