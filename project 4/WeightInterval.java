
public class WeightInterval implements Comparable {

	private int starttime;
	private int finishtime;
	private int weight;
	
	
	public WeightInterval() {
	}
	
	public WeightInterval(int starttime, int finishtime, int weight) {
		super();
		this.starttime = starttime;
		this.finishtime = finishtime;
		this.weight = weight;
	}

	public int getStarttime() {
		return starttime;
	}
	public void setStarttime(int starttime) {
		this.starttime = starttime;
	}
	public int getFinishtime() {
		return finishtime;
	}
	public void setFinishtime(int finishtime) {
		this.finishtime = finishtime;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int compareTo(Object o) {
		WeightInterval w = (WeightInterval) o;
		if (this.finishtime > w.getFinishtime()){
			return  1;
			
		}
		else if (this.finishtime == w.getFinishtime())
			return 0;
		else
			return -1;
	}
	
	
}
