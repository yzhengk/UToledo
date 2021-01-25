import java.util.List;
public class Algorithm {

	public static void GaleShapley(List<Person> manList
			,List<Person> womenList){
		
		Person p;
		for(int i = 0; i < manList.size(); i++){
			p = manList.get(i);
			p.setPartnerName(null);
			p.setPriorityIndex(-1);
		}
		for(int i = 0; i < womenList.size(); i++){
			p = womenList.get(i);
			p.setPartnerName(null);
			p.setPriorityIndex(-1);
		}
		
		
		boolean hashManFree = true; 
		while(hashManFree){
			hashManFree = false;
			Person freeMan = null; 
			
			for(int i = 0 ;i < manList.size();i++){
				if(manList.get(i).getPartnerName() == null && manList.get(i).haveNext())
				{
					
					hashManFree = true;
					freeMan = manList.get(i);
				} 
			}
			if(hashManFree){
				
				Person women = freeMan.getNextWomen(womenList);
			
				if(women.getPartnerName() == null){
					freeMan.setPartnerName(women.getName());
					women.setPartnerName(freeMan.getName());
				}
				else {
					List<String> womenPreferences = women.getPreferences();
			
					if(womenPreferences.indexOf(freeMan.getName()) 
							< womenPreferences.indexOf(women.getPartnerName())){
					
						int oldManIndex = manList.indexOf(new Person(women.getPartnerName()));
						Person oldMan = manList.get(oldManIndex);
						oldMan.setPartnerName(null);
						freeMan.setPartnerName(women.getName());
						women.setPartnerName(freeMan.getName());
					}
				}
			}
		}
	}
}
