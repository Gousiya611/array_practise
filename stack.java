import java.io.*;
import java.util.*;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            System.out.println(isBalanced(sc.next()));
            
        }
        sc.close();
        
    }
    static boolean isBalanced(String parenthases) {
        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<parenthases.length();i++){
            char ch=parenthases.charAt(i);
            if(ch == '(' || ch =='{' || ch == '['){
                stack.push(ch);
            }
            else if(stack.empty()){
                return false;
            }
            else{
                char top=stack.pop();
                if((top=='(' && ch!=')')||(top == '{' && ch!='}') ||(top == '[' && ch!=']')){
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
