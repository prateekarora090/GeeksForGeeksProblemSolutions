/**
 * Created by prateek on 12/7/17.
 */
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main (String[] args) {
        //code
        Scanner sc = new Scanner(System.in);
        String numberOfCases = sc.nextLine();
        int n = Integer.parseInt(numberOfCases);

        for (int i = 0; i < n; i++) {
            sc.nextLine();
            String array = sc.nextLine();
            findLargestContinuousSubarray(array);
        }
    }

    public static void findLargestContinuousSubarray(String stringsArray) {
        int[] array = extractArray(stringsArray);

        int totalMax = array[0];
        int currTotal = array[0];

        for (int i = 1; i < array.length; i++) {
            currTotal = Math.max(currTotal + array[i], array[i]);
            totalMax = Math.max(currTotal, totalMax);
        }

        System.out.println(totalMax);
    }

    public static int[] extractArray(String stringArray) {
        String[] strings = stringArray.split(" ");
        int[] array = new int[strings.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(strings[i]);
        }
        return array;
    }
}
