import java.util.Scanner;
import java.math.*;

public class WindChill {
	public static void main(String[] args) {
		double T, V;
		int windChill;
		Scanner input = new Scanner(System.in);

		System.out.print("Enter temperature (Fahrenheit) : ");
		T = input.nextDouble();

		System.out.print("Enter wind speed (mph) : ");
		V = input.nextDouble();

		windChill = (int)(35.74 + 0.6215 * T - 35.75 * Math.pow(V, 0.16) + 0.4275 * T * Math.pow(V, 0.16));
		
		System.out.print("The wind chill index is " + windChill);
		
	}
}
