import java.util.Scanner;

/**
 * Created by prateek on 12/7/17.
 */
public class GFG {

    public static void main (String[] args) {
        //code
        Scanner sc = new Scanner(System.in);
        String numberOfCases = sc.nextLine();
        int n = Integer.parseInt(numberOfCases);

        for (int i = 0; i < n; i++) {
            String argumentString = sc.nextLine();
            String[] arguments = argumentString.split(" ");
            int sum = Integer.parseInt(arguments[1]);
            String array = sc.nextLine();
            findSum(array, sum);
        }
    }

    public static void findSum(String stringsArray, int sum) {
        int[] array = extractArray(stringsArray);
        int[] sumArr = sumArray(array);
        if (array.length == 1) {
            System.out.println(sum == array[0] ? "0" : "-1");
        }

        int left = 0;
        int right = 1;

        while (right < array.length) {
            int currSum = sumForIndices(sumArr, left, right);

            if (currSum < sum) {
                right++;
            } else if (currSum > sum) {
                left++;
                if (left == right) {
                    right++;
                }
            } else {
                System.out.println((left+1) + " " + (right+1));
                return;
            }
        }

        System.out.println("-1");

    }

    public static int[] sumArray(int[] a) {
        int sum = 0;
        int[] sumArray = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            sum+=a[i];
            sumArray[i] = sum;
        }
        return sumArray;
    }

    public static int sumForIndices(int[] sum, int left, int right) {
        return left == 0? sum[right] : sum[right] - sum[left -1];
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
