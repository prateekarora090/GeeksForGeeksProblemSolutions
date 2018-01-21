import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by prateek on 1/21/18.
 */
public class GFG {

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
                largestNumberFromArray(array);
            }
        }

        public static void largestNumberFromArray(String stringsArray) {
            Integer[] array = extractArray(stringsArray);

            Arrays.sort(array, new LargestNumberComparator());

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < array.length; i++) {
                sb.append(array[i]);
            }
            System.out.println(sb.toString());
        }

        public static Integer[] extractArray(String stringArray) {
            String[] strings = stringArray.split(" ");
            Integer[] array = new Integer[strings.length];
            for (int i = 0; i < array.length; i++) {
                if (!strings[i].equals("")) {
                    array[i] = Integer.parseInt(strings[i]);
                }
            }
            return array;
        }
    }

    class LargestNumberComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer num1, Integer num2) {

            int num1Length = num1.toString().length();
            int num2Length = num2.toString().length();

            // If length is the same, decide based on value
            if (num1Length == num2Length) {
                return num1 > num2 ? -1 : 1;
            } else {

                int minLength = num1Length > num2Length ? num2Length : num1Length;

                for (int i = 0; i < minLength; i++) {
                    //If first number is different, return the number with larger starting digit
                    int num2FirstDigit = Integer.parseInt(Integer.toString(num2).substring(i, i+1));
                    int num1FirstDigit = Integer.parseInt(Integer.toString(num1).substring(i, i+1));

                    if (num1FirstDigit != num2FirstDigit) {
                        return num1FirstDigit > num2FirstDigit ? -1 : 1;
                    }
                }

                int longerNum = num1Length > num2Length ? num1 : num2;
                int longerLength = num1Length > num2Length ? num1Length : num2Length;
                int longerNumFirstDigit = Integer.parseInt(Integer.toString(longerNum).substring(0, 1));
                int longerNumLastDigit = longerNumFirstDigit;

                while (longerNumLastDigit == longerNumFirstDigit && minLength < longerLength) {
                    longerNumLastDigit = Integer.parseInt(Integer.toString(longerNum).substring(minLength, minLength+1));
                    minLength++;
                }

                if (longerNumLastDigit > longerNumFirstDigit) {
                    return longerNum == num1 ? -1 : 1;
                } else {
                    return num1Length < num2Length ? -1 : 1;
                }
            }
        }
    }

}
