import java.lang.reflect.Array;
import java.util.Arrays;


public class Scheduling {
	public static int interval(WeightInterval[] weight,int t) {
		Arrays.sort(weight);
		int weightvalue = 0;
		for (int i = 0; i < weight.length; i++) {
			if(t < weight[i].getStarttime()) {
				weightvalue +=weight[i].getWeight();
				t = weight[i].getFinishtime();
				System.out.println(t);
			}
		}
		return weightvalue;
	}
	public static void main(String[] args) {
		WeightInterval wil[]={
				new WeightInterval(0, 3, 3),
				new WeightInterval(1, 4, 2),
				new WeightInterval(0, 5, 4),
				new WeightInterval(3, 6, 1),
				new WeightInterval(4, 7, 2),
				new WeightInterval(3, 9, 5),
				new WeightInterval(5, 10, 2),
				new WeightInterval(8, 10, 1)
				
		};
		interval(wil, 0);
	}
}
