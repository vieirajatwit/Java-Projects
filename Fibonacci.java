import java.util.Scanner;
public class Fibonacci {

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		System.out.println("Please enter a positive integer greater than 1: ");
		int n = input.nextInt();
		int count=0;
		int current1=0;
		int current2=1;
		int newcurrent=0;
		
		
		while (count<n) {
			System.out.println(current2);
			newcurrent=current2;
			current2=current1+current2;
			current1=newcurrent;
			count++;		
		}
		
	}
}
