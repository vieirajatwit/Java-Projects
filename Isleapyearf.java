//import java.util.Arrays;
import java.util.Scanner;
public class Isleapyearf {

	
	public static boolean isLeapYear(int inyear) 
	{
		
		
		if (inyear % 4 == 0) 
		{
            if (inyear % 100 != 0 || inyear % 400 == 0) 
            {
                return true;
            }
        }
        return false;
    }
	
	
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		System.out.printf("Enter a year: ");
		 int inyear = input.nextInt();
		 
		 
		 if (isLeapYear(inyear)) 
		 {
	            System.out.println(inyear + " is a leap year.");
	        } 
		 else 
	        {
	            System.out.println(inyear + " is not a leap year.");
	        }
	        
	        
	    }
		

	

}
