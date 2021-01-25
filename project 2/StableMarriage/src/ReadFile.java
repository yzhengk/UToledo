import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class ReadFile {
	
	public static String readFile(String fileName
			,List<Person> manList
			,List<Person> womenList
			){
		File file;
		BufferedReader bf;
		try{
			String path = ReadFile.class.getResource(fileName).getPath();
		
			file = new File(path);
			String lineTxt;
			if(file.exists()){
				bf = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			
				int n = Integer.parseInt( bf.readLine());
              
				lineTxt = bf.readLine();
				String[] mans = lineTxt.split(" ");
				for(int i = 0 ;i < mans.length ; i++){
					Person person = new Person(mans[i]);
					manList.add(person);
				}
				
				lineTxt = bf.readLine();
				String[] womens = lineTxt.split(" ");
				for(int i = 0 ;i < womens.length ; i++){
					Person person = new Person(womens[i]);
					womenList.add(person);
				} 
		
				for(int i = 0;i < n;i++	){
					lineTxt = bf.readLine().trim();
					if(lineTxt.startsWith("//") || lineTxt.length() < 1){
						i--;
						continue;
					}
					String[] s = lineTxt.split(":");
					String manName = s[0].trim();
					String[] preferences = s[1].trim().split(" ");
					int index = manList.indexOf(new Person(manName));
					Person p =manList.get(index);
					p.setPreferences(new ArrayList<String>());
					for(int j = 0;j < preferences.length; j++){
						p.getPreferences().add(preferences[j]);
					}
				}
			
				for(int i = 0;i < n;i++	){
					lineTxt = bf.readLine().trim();
					if(lineTxt.startsWith("//") || lineTxt.length() < 1){
						i--;
						continue;
					}
					String[] s = lineTxt.split(":");
					String womenName = s[0].trim();
					String[] preferences = s[1].trim().split(" ");
					int index = womenList.indexOf(new Person(womenName));
					Person p =womenList.get(index);
					p.setPreferences(new ArrayList<String>());
					for(int j = 0;j < preferences.length; j++){
						p.getPreferences().add(preferences[j]);
					}
				}
				bf.close();
			}
			else{
				return "file is not exist! file path in the The project home directory /res folder";
			}
		}
		catch(Exception e){
			e.printStackTrace();
			return "read the file error ! please check the file format correct";
		}
		return "true";
	}
	
	public static void main(String[] args){
		String fileName = "inputdata.txt";
		List<Person> manList = new ArrayList<Person>();
		List<Person> womenList = new ArrayList<Person>();
		readFile(fileName,manList,womenList);
		int i=1;
		i++;
		int j =i;
	}

}
