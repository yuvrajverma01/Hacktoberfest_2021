import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
	    Scanner s = new Scanner(System.in);
		String input = s.next();
    	System.out.println(removeConsecutiveDuplicates(input));
	}
	public static String removeConsecutiveDuplicates(String s) {
	
        // bass case 
        if(s.length()== 1)
            return s;
        
        // small calculattions
        String ans = "";
        if(s.charAt(1) != s.charAt(0))
            ans = ans + s.charAt(0);
        // recursive call
        String smallans = removeConsecutiveDuplicates(s.substring(1));
        
        return ans + smallans;

	}
}
