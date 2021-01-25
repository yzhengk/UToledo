package GUIPhoneBook;


public class User{
	private String name, phoneNumber, notes;
	
	public User()
	{
		
	}	
	public User(String name, String phoneNumber, String notes)
	{
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.notes = notes;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
	
	public void setNotes(String notes)
	{
		this.notes = notes;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getPhoneNumber()
	{
		return this.phoneNumber;
	}
	
	public String getNotes()
	{
		return this.notes;
	}
	
}
