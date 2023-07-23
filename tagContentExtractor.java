import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution{
    private static String tagReg = "<(.+)>([^<]+)</\\1>";
    private static Pattern tagPattern = Pattern.compile(tagReg);
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		while(testCases>0){
			String line = in.nextLine();
            Matcher tagMatcher = tagPattern.matcher(line);
            if(tagMatcher.find()){
                do{
                    System.out.println(tagMatcher.group(2));
                }while(tagMatcher.find());
            }else{
                System.out.println("None");
            }
			
          	//Write your code here
			
			testCases--;
		}
	}
}



