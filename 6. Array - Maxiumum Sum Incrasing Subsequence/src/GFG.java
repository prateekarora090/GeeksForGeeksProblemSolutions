import java.util.Scanner;

/**
 * Created by prateek on 12/9/17.
 */
public class GFG {

    public static void main (String[] args) {
        //code
        Scanner sc = new Scanner(System.in);
        String numberOfCases = sc.nextLine();
        int n = Integer.parseInt(numberOfCases);

        for (int i = 0; i < n; i++) {
            sc.nextLine();
            String array = sc.nextLine();
            findMaxIncreasingSubsequence(array);
        }
    }

    public static void findMaxIncreasingSubsequence(String stringsArray) {
        int[] arr = extractArray(stringsArray);
        int[] sum = new int[arr.length];

        sum[0] = arr[0];
        for (int i = 0; i < arr.length; i++) {
            int currMax = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && sum[j] > currMax) {
                    currMax = sum[j];
                }
            }
            sum[i] = currMax + arr[i];
        }

        System.out.println(findMax(sum));
    }

    public static int findMax(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if(max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
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
