package com.stablemarriage;

import java.util.ArrayList;
import java.util.List;


public class Person {
	private String name;
	private String partner;
	//private Integer priority;
	private Integer number;//ÈËÊý
	private String[] preferences;
	private Integer beProposed; //
	private Integer propose;   //
	Person()
	{}
	Person(String name, int num, String[] nameList)
	{
		this.name = name;
		this.number = num;
		preferences = new String[num];
		for(int i = 0; i < num; i++)
			preferences[i] = nameList[i];
		beProposed = 0;
		propose = 0;
	}

	
	public String getName()
	{
		return this.name;
	}
	
	public void setPartnerName(String name)
	{
		this.partner = name;
	}
	
	//public void setPriorityIndex(Integer priority)
	//{
	//	this.priority = priority;
	//}
	
	public String getPartnerName()
	{
		return this.partner;
	}
	
	public boolean haveNext()
	{
		if(this.beProposed < this.number)
			return true;
		else
			return false;
	}
	
	public void addProposedTime()
	{
		if(this.beProposed < this.number)
			this.beProposed++;
	}
	
	
	public List<String> getPreferences()
	{
		List<String> s = new ArrayList<String>();
		for(int i = 0; i < this.preferences.length; i++)
			s.add(preferences[i]);
		return s;
	}
	
	public String getNextWomen()
	{
		//if(this.propose < this.number)
			return this.preferences[this.propose++];
		//else
			//return null;
	}

}
