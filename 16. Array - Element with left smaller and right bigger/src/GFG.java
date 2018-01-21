/**
 * Created by prateek on 12/7/17.
 */
import java.util.*;
import java.lang.*;

class GFG {
    public static void main (String[] args) {
        //code
        Scanner sc = new Scanner(System.in);
        String numberOfCases = sc.nextLine();
        int n = Integer.parseInt(numberOfCases);

        for (int i = 0; i < n; i++) {
            sc.nextLine();
            String array = sc.nextLine();
            findElement(array);
        }
    }

    public static void findElement(String stringsArray) {
        int[] array = extractArray(stringsArray);
        int[] max = new int[array.length];
        int[] min = new int[array.length];

        int maxSoFar = -1;
        for (int i = 0; i < array.length; i++) {
            max[i] = maxSoFar;
            if (array[i] > maxSoFar) {
                maxSoFar = array[i];
            }
        }

        int minSoFar = Integer.MAX_VALUE;
        for (int i = array.length - 1; i >= 0; i--) {
            min[i] = minSoFar;
            if (array[i] < minSoFar) {
                minSoFar = array[i];
            }
        }

        for (int i = 1; i < array.length - 1; i++) {
            System.out.println("Min: " + min[i]+ " max: " + max[i] + " element: " + array[i]);
            if (max[i] < array[i] && array[i] < min[i]) {
                System.out.println(array[i]);
                return;
            }
        }

        System.out.println("-1");
    }

    public static int[] extractArray(String stringArray) {
        String[] strings = stringArray.split(" ");
        int[] array = new int[strings.length];
        for (int i = 0; i < array.length; i++) {
            if (!strings[i].equals("")) {
                array[i] = Integer.parseInt(strings[i]);
            }
        }
        return array;
    }
}
