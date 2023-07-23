import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
class Student{
    private int token;
    private String fname;
    private double cgpa;
    public Student(int id, String fname, double cgpa){
        super();
        this.token = token;
        this.fname = fname;
        this.cgpa = cgpa;
        
    }
    public int getToken(){
        return token;
    }
    public String getFname() {
        return fname;
    }
    public double getCgpa(){
        return cgpa;
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalEvents  = Integer.parseInt(sc.nextLine());
        PriorityQueue<Student> list = new PriorityQueue<>(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2){
                if(s1.getCgpa() != s2.getCgpa())
                return s1.getCgpa() < s2.getCgpa() ? 1:-1;
                
            else{
                if(!s1.getFname().equals(s2.getFname()))
                return s1.getFname().compareTo(s2.getFname());
                else
                return s1.getToken() < s2.getToken() ? 1:-1;
            
                }
            }
        });
    
    while(totalEvents>0){
        String event = sc.next();
        if(event.equals("ENTER")){
            String name = sc.next();
            double gpa = sc.nextDouble();
            int id = sc.nextInt();
            list.add(new Student(id, name, gpa));
            
        }else if(list.size() > 0 && event.equals("SERVED")){
            list.remove();
        }
        totalEvents--;
    }
    if(list.size() == 0){
        System.out.println("EMPTY");
        return;
    }
    while(list.size() > 0 ){
        System.out.println(list.poll().getFname());
    }
    
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
}
