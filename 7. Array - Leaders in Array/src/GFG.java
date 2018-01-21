import java.util.ArrayList;
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
            findEquilibrium(array);
        }
    }

    public static void findEquilibrium(String stringsArray) {
        int[] arr = extractArray(stringsArray);
        ArrayList<Integer> list = new ArrayList<Integer>();

        int max = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] > max) {
                list.add(arr[i]);
                max = arr[i];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i) + " ");
        }

        System.out.println(sb.toString());
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
