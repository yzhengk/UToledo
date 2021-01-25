import java.util.LinkedList;

public class HashTable {

	private int size;
	private LinkedList<String>[] hashtable;

	private int len;

	/**
	 * Constructor for a hash table of default size: 1000
	 */
	@SuppressWarnings("unchecked")
	public HashTable() {
		size = 1000;
		hashtable = new LinkedList[size];
		for (int i = 0; i < size; i++) {
			hashtable[i] = new LinkedList<String>();
		}
		len = 0;
	}

	/**
	 * Constructor for a hash table of size n
	 * @param size : Array initialization value
	 */
	@SuppressWarnings("unchecked")
	public HashTable(int size) {
		this.size = size;
		hashtable = new LinkedList[size];
		for (int i = 0; i < size; i++) {
			hashtable[i] = new LinkedList<String>();
		}
		len = 0;
	}
	
	/**
	 * Inserts S into the hash table
	 * @param word
	 */
	public void Insert(String word) {
		if(len * 3 >= size){
			//System.out.println("grow " + len + " " + size);
			growHashTable();
		}
		int num = hash(word);
		hashtable[num].add(word);
		len++;
	}
	
	/**
	 * Return true if S is in the table, false otherwise
	 * @param word
	 * @return
	 */
	public boolean Contains (String word){
		if(NumEntries(word)!=-1)return true;
		else return false;
	}
	
	/**
	 * Returns the number of strings stored in the table
	 * @param word
	 * @return
	 */
	public int NumEntries(String word){
		int num = hash(word);
		if(hashtable[num].contains(word))return num;
		else return -1;
	}

	/**
	 * return the hash num
	 * @param word
	 * @return
	 */
	private int hash(String word) {
		if (word == null || word.equals(""))
			return 0;
		int wordLen = word.length();
		int num = 0;
		for (int i = 0; i < wordLen; i = i + 4) {
			num += word.substring(i, (i + 4 < wordLen) ? (i + 4) : wordLen).hashCode();
		}

		return num % size;
	}

	/**
	 * next size (prime value)
	 * @return
	 */
	private int nextSize() {
		int newSize = 0;
		for (int i = size * 2;; i++) {
			if (isPrime(i)) {
				newSize = i;
				break;
			}
		}
		return newSize;
	}
	
	/**
	 *  grow the hash table
	 */
	@SuppressWarnings("unchecked")
	private void growHashTable() {
	   	 int oldsize = size;
	   	 LinkedList<String>[] templist = new LinkedList[oldsize];
	   	 for(int i=0;i<oldsize;i++){
	   		 templist[i] = new LinkedList<String>();
	   		 templist[i].addAll(hashtable[i]);
	   	 }
	   	 size = nextSize();
	   	 len = 0;
	   	 hashtable = new LinkedList[size];
	   	 for(int i=0;i<size;i++){
	   		hashtable[i] = new LinkedList<String>();
	   	 }
	   	 for(int i=0;i<oldsize;i++){
	   		 for(String it:templist[i]){
	   			Insert(it);
	   		 }
	   	 }
	}

	/**
	 * if n is prime return true, else return false
	 * @param n
	 * @return
	 */
	boolean isPrime(int n) {
		if (n % 2 == 0) // check if n is a multiple of 2
			return false;
		else
			for (int i = 3; i * i <= n; i += 2) {
				if (n % i == 0) {
					return false;
				}

			}
		return true;
	}

	/**
	 * 
	 * @return
	 */
	public int getLen(){
		return len;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getSize(){
		return size;
	}
	
	
}
