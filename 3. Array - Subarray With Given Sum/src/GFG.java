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
            sc.nextLine();
            String array = sc.nextLine();
            findMissingNumber(array);
        }
    }

    public static void findMissingNumber(String stringsArray) {
        int[] array = extractArray(stringsArray);
        int sum = 0;
        int n = array.length;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }

        n++;
        System.out.println(n*(n+1)/2 - sum);
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
