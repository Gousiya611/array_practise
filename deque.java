import java.io.*;
import java.util.*;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int[] arr = new int[n];
    for(int i=0; i<n;i++){
        arr[i]=sc.nextInt();
    }
    int maxUniqueInteger = findMaxUnique(arr, m );
    System.out.println(maxUniqueInteger);
    
    }
    public static int findMaxUnique(int[] arr,int m){
        if(arr == null || m<=0||m>arr.length){
            return 0;
        }
        int maxUniqueIntegers =0;
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for(int i=0;i<m;i++){
            frequencyMap.put(arr[i],frequencyMap.getOrDefault(arr[i],0)+1);
        }
        maxUniqueIntegers = frequencyMap.size();
        for(int i=m;i<arr.length;i++){
            int elementToRemove = arr[i-m];
            int frequency = frequencyMap.get(elementToRemove);
            if(frequency == 1){
                frequencyMap.remove(elementToRemove);
            }else{
                frequencyMap.put(elementToRemove, frequency -1);
            }
            int newElement = arr[i];
            frequencyMap.put(newElement, frequencyMap.getOrDefault(newElement,0)+1);
            maxUniqueIntegers = Math.max(maxUniqueIntegers, frequencyMap.size());
        }
        return maxUniqueIntegers;
    }
}
