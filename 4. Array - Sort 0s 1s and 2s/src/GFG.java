import java.util.Scanner;

/**
 * Created by prateek on 12/8/17.
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
            sort012s(array);
        }
    }

    public static void sort012s(String stringsArray) {
        int[] arr = extractArray(stringsArray);
        int num0s = 0; int num1s = 0; int num2s = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                num0s++;
            } else if (arr[i] == 1) {
                num1s++;
            } else {
                num2s++;
            }
        }

        int j = 0;
        j = setArrValues(arr, j, num0s, 0);
        j = setArrValues(arr, j, num1s, 1);
        j = setArrValues(arr, j, num2s, 2);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i] + " ");
        }
        System.out.println(sb.toString());
    }

    public static int setArrValues(int[] arr, int j, int n, int val) {
        for (int i = 0; i < n; i++) {
            arr[j++] = val;
        }
        return j;
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
