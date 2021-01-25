package com.stablemarriage;

import java.util.ArrayList;
import java.util.List;
public class algorithm {
	/**
	 * Gale-Shapely Algorithm
	 * @param manList 
	 * @param womenList 
	 */
    /************************** START. 这一段是给manList 和 womenList赋值  ***********************************/
	static String Man[] = {"John", "Robert", "Brian", "Stephen", "George"};
	
	static String allWomen[] = {"Susan", "Joyce", "Nancy", "Patricia", "Anne",
				                "Nancy", "Anne", "Joyce", "Susan" ,"Patricia",
							    "Patricia", "Susan", "Joyce", "Anne", "Nancy",
				 			    "Joyce","Anne", "Susan", "Nancy", "Patricia",
							    "Nancy", "Joyce", "Patricia", "Susan", "Anne"};
	
	static String Woman[] = {"Nancy", "Joyce", "Patricia", "Anne", "Susan"};
	
	static String allMan[] = {"John", "Brian", "Stephen", "Robert", "George",
					          "George","John",  "Stephen", "Robert","Brian", 
					          "George","Brian", "Robert","Stephen","John",   
					          "George","Stephen", "John", "Brian","Robert", 
					          "Brian", "George","Stephen","John", "Robert"};

	public static List<Person> womenList = new ArrayList<Person>();
	public static List<Person> manList = new ArrayList<Person>();	
	public static  void init()
	{
		
		for(int i = 0; i < 5; i++)
		{
			String[] s = new String[5];
			String name = Man[i];
			int c = 0;
			for(int j = i*5; j < i*5 + 5; j++)
				s[c++] = allWomen[j];
			Person p = new Person(name, 5, s);
			manList.add(p);			
		}
		
		for(int i = 0; i < 5; i++)
		{
			String[] s = new String[5];
			String name = Woman[i];
			int c = 0;
			for(int j = i*5; j < i*5 + 5; j++)
				s[c++] = allMan[j];
			Person p = new Person(name, 5, s);
			womenList.add(p);			
		}
	}
	/***********************************    END   *************************************************************/
	
	public static void GaleShapley(List<Person> manList
			,List<Person> womenList){
		//Initialize each person to be free
		Person p;
		for(int i = 0; i < manList.size(); i++){
			p = manList.get(i);
			p.setPartnerName(null);
			//p.setPriorityIndex(-1);
		}
		for(int i = 0; i < womenList.size(); i++){
			p = womenList.get(i);
			p.setPartnerName(null);
			//p.setPriorityIndex(-1);
		}
		
		//if some man is free and hasn't proposed to every woman,hashManFree is true
		boolean hashManFree = true; 
		while(hashManFree){
			hashManFree = false;
			Person freeMan = null; 
			//find who man is free and hasn't proposed to every woman
			for(int i = 0 ;i < manList.size();i++){
				if(manList.get(i).getPartnerName() == null && manList.get(i).haveNext())
				{
					//exist a man is free and hasn't proposed to every woman
					hashManFree = true;
					freeMan = manList.get(i);//Choose such a man m
					manList.get(i).addProposedTime(); //增加一次这个男人被推荐的次数
				} 
			}
			if(hashManFree){
				//get the woman on men's list to whom m has not yet proposed
				String sw = freeMan.getNextWomen();
				Person women = null;
				for(int i = 0; i < womenList.size(); i++)
					if(womenList.get(i).getName() == sw)
					{
						women = womenList.get(i);  //获得下一个女孩的信息
						break;
					}
				
				if(freeMan.getName() == "John")
					System.out.println("john wants " + women.getName());
					
				//is women is free
				if(women.getPartnerName() == null){
					//System.out.println("remains: " + women.getName());
					freeMan.setPartnerName(women.getName());
					women.setPartnerName(freeMan.getName());
				}
				else {
					List<String> womenPreferences = women.getPreferences();
					// if women prefers this men to her 
					if(womenPreferences.indexOf(freeMan.getName()) 
							< womenPreferences.indexOf(women.getPartnerName())){
						// assign men and women to be engaged, and m' to be free
						
						//int oldManIndex = manList.indexOf(new Person(women.getPartnerName()));
						Person oldMan = null;// = manList.get(oldManIndex);
						for(int i = 0; i < manList.size(); i++)
							if(manList.get(i).getName() == women.getPartnerName())
							{
								oldMan = manList.get(i);
								break;
							}
						oldMan.setPartnerName(null);
						freeMan.setPartnerName(women.getName());
						women.setPartnerName(freeMan.getName());
					}
				}
			}
		}
		Person remainMan = null;
		Person remainWoman = null;
		for(int i = 0; i < manList.size(); i++)
			if(manList.get(i).getPartnerName() == null)
			{
				remainMan = manList.get(i);
				break;
			}
		
		for(int i = 0; i < womenList.size(); i++)
			if(womenList.get(i).getPartnerName() == null)
			{
				remainWoman = womenList.get(i);
				break;
			}
		remainMan.setPartnerName(remainWoman.getName());
		remainWoman.setPartnerName(remainMan.getName());
	}
	
	public static void main(String[] args)
	{
		algorithm.init();
		algorithm.GaleShapley(algorithm.manList, algorithm.womenList);
		for(int i = 0; i < algorithm.manList.size(); i++)
		{
			System.out.print(algorithm.manList.get(i).getName());
			System.out.println(" " + algorithm.manList.get(i).getPartnerName());
		}
	}
}

