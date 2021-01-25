package GUIPhoneBook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class PhoneBook {
	private static Vector<User> userlist = new Vector<User>();
	
	public PhoneBook()
	{}
	
	
	public void init(String FileName) throws Exception 
	{
		File F;
		F = new File(FileName);
		Scanner S = new Scanner(F);
		if(S == null ) return;
		while (S.hasNextLine()) 
		{
		User temp = new User();
		
		temp.setName(S.next());
		temp.setPhoneNumber(S.next());
		String notes = S.nextLine();
		if(notes.charAt(0) == '\t')		//delete the '\t' character
			notes = notes.substring(1);  
		temp.setNotes(notes); 
		userlist.add(temp);
		}
		S.close();
	}

	
	public boolean add(User src) throws IOException  
	{
		int i;
		Object[] options = {"Yes","No"};

		for(i = 0; i < userlist.size(); i++)
		{
			if(src.getName().compareTo(userlist.get(i).getName()) == 0)  //warning: same name
			{
				int result = JOptionPane.showOptionDialog(null,"Same name exists, still want to add?","Warning",JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE,null,options,options[0]);
				if(0 == result)
					continue;
				else
					break;
			}
			else if(src.getName().compareTo(userlist.get(i).getName())< 0)
			{
				userlist.insertElementAt(src, i);
				return true;
			}
		}
		
		if(i == userlist.size()) //the new entry is located in the last index or the entry list is null
		{
			userlist.add(src);
			return true;
		}
		return false;
		
	}
	
	public Vector<User> list()
	{
//		Iterator<User> it = userlist.iterator();
//		while(it.hasNext())
//		{ 
//			User tmp = new User();
//			tmp = it.next();
//			System.out.println(tmp.getName());
//			System.out.println(tmp.getPhoneNumber());
//			System.out.println(tmp.getNotes()+ "\n");
//		}
		return userlist;
	}
	
	public Vector<User> find(String name)
	{
		Vector<User> temp = new Vector<User>();
		Iterator<User> it = userlist.iterator();
		while(it.hasNext())
		{
			User u = new User();
			u = it.next();
			if(u.getName().compareToIgnoreCase(name) == 0)
			{
				temp.add(u);
			}
		}	
		return temp;
	}
	
	public Vector<User> partialfind(String name)
	{
		Vector<User> temp = new Vector<User>();
		Iterator<User> it = userlist.iterator();
		while(it.hasNext())
		{
			User u = new User();
			u = it.next();
			if(u.getName().toLowerCase().indexOf(name.toLowerCase()) >= 0)
			{
				temp.add(u);
			}
		}	
		return temp;
	}
	
	public boolean delete(String name)
	{
		Iterator<User> it = userlist.iterator();
		boolean flag = false;
		while(it.hasNext())
		{
			if(it.next().getName().equals(name))
			{
				flag = true;
				it.remove();
			}
		}
		
		if(flag) return true;
		else return false;  //delete fails
	}
	
	public void save(String FileName) throws FileNotFoundException
	{
		FileOutputStream out = new FileOutputStream(FileName);
		PrintStream P = new PrintStream( out );

		for (int i=0; i < userlist.size() ; i++) 
		{
		P.println(userlist.get(i).getName() + "\t" + userlist.get(i).getPhoneNumber() +
		"\t" + userlist.get(i).getNotes());
		}
		try {
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}
