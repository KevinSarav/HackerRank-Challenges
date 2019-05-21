/*This is one of the warm-up challenges. The reason I felt this was important to share is because it is my first time
using a HashMap in Java. I have used dictionaries before in Python in a university class, but never HashMaps in practical 
use. It was necessary in this assignment because using 2 for loops caused my code to time out in HackerRank, so I needed a 
more efficient way to solve the challenge. The link to the challenge is below.
https://www.hackerrank.com/challenges/pairs/submissions/code/108139126 */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the pairs function below (this is the important part that I made).
    static int pairs(int k, int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i = 0; i < arr.length; i++)
            map.merge(arr[i], 1, Integer::sum);

        int count = 0;
        for(int i = 0; i < arr.length; i++){
            if(map.containsKey(arr[i]-k))
                count += map.get(arr[i]-k);
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = pairs(k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
