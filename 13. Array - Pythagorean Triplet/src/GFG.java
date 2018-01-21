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
            isThereAPythagoreanTriplet(array);
        }
    }

    public static void isThereAPythagoreanTriplet(String stringsArray) {
        int[] array = extractArray(stringsArray);
        int[] squaredArray = square(array);
        Arrays.sort(squaredArray);

        for (int i = 0; i <squaredArray.length; i++) {
            int target = squaredArray[i];
            if (doesSumExist(squaredArray, target)) {
                System.out.println("Yes");
                return;
            }
        }

        System.out.println("No");
    }

    public static boolean doesSumExist(int[] array, int target) {
        int leftPointer = 0;
        int rightPointer = array.length - 1;

        while (leftPointer < rightPointer) {
            int actualTotal = array[leftPointer] + array[rightPointer];
            if (actualTotal == target) {
                return true;
            }
            else if (actualTotal > target) {
                rightPointer--;
            } else {
                leftPointer++;
            }
        }
        return false;
    }

    public static int[] square(int[] array) {
        int[] squaredArray = new int[array.length];
        for (int i = 0 ; i < array.length; i++) {
            squaredArray[i] = array[i] * array[i];
        }
        return squaredArray;
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
