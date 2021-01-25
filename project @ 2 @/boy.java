package com.stablemarriage;

public class boy 
{
	String name; String prefer;
	
	public boy()
	{
		name="";
		prefer="";
	}
	
	public boy (String nName, String nPrefer)
	{
		name = nName;
		prefer = nPrefer;
	}
	
	public String getName ()
	{
		return name;
	}
	
	public String getPrefer()
	{
		return prefer;
	}
	
	public void setName (String nName)
	{
		name = nName;
	}
	
	public void setPrefer (String nPrefer)
	{
		prefer = nPrefer;
	}
	
	public void setBoy (String nName, String nPrefer)
	{
		name = nName ; 
		prefer = nPrefer;
	}
	
	public String toString ()
	{
		return ("\n"+name + " prefers:" +prefer);
	}
}
