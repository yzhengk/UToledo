package com.stablemarriage;
public class girl 
{
	String name; String prefer;
	
	public girl()
	{
		name="";
		prefer="";
	}
	
	public girl (String nName, String nPrefer)
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
	
	public void setGirl (String nName, String nPrefer)
	{
		name = nName ; 
		prefer = nPrefer;
	}
	
	
	public String toString ()
	{
		return ("\n"+name + " prefers:" +prefer);
	}
}
