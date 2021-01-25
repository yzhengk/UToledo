import java.util.List;


public class Person {

	private String name;
	
	private String partnerName;
	 
	private Integer priorityIndex;

	private List<String> preferences;
	

	public Person(String name){
		this.name = name;
		this.priorityIndex = -1;
	}
	 
	
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		else if(obj instanceof Person){
			if(((Person) obj).getName().equals(this.getName()))
				return true;
		}
		return false;
	}
	
	
	public boolean haveNext(){
		if(this.priorityIndex + 1 < preferences.size()){
			return true;
		}
		return false;
	}
	
	public Person getNextWomen(List<Person> womenList){
		String womenName = preferences.get(++this.priorityIndex);
		int womenIndex = womenList.indexOf(new Person(womenName));
		return womenList.get(womenIndex);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPartnerName() {
		return partnerName;
	}
	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}
	public Integer getPriorityIndex() {
		return priorityIndex;
	}
	public void setPriorityIndex(Integer priorityIndex) {
		this.priorityIndex = priorityIndex;
	}
	public List<String> getPreferences() {
		return preferences;
	}
	public void setPreferences(List<String> preferences) {
		this.preferences = preferences;
	}
	
	
}
