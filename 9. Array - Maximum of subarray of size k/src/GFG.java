import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by prateek on 12/11/17.
 */
public class GFG {

    public static void main (String[] args) {
        //code
        Scanner sc = new Scanner(System.in);
        String numberOfCases = sc.nextLine();
        int n = Integer.parseInt(numberOfCases);

        for (int i = 0; i < n; i++) {
            String argString = sc.nextLine();
            String[] arg = argString.split(" ");
            int k = Integer.parseInt(arg[1]);
            String array = sc.nextLine();
            findMaxInSubset(array, k);
        }
    }

    public static void findMaxInSubset(String stringsArray, int k) {
        int[] arr = extractArray(stringsArray);

        //Ensure size is more than k
        if (arr.length < k) {
            System.out.println("-1");
            return;
        }
        List<Integer> result = new ArrayList<Integer>();
        int currMax = findMax(arr, 0, k-1);
        result.add(currMax);
        int prevMax;
        for (int i = 1; i <= arr.length - k; i++) {
            prevMax = arr[i-1] == currMax ? findMax(arr, i, i + k - 2) : currMax;
            currMax = Math.max(prevMax, arr[i + k - 1]);
            result.add(currMax);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.size(); i++) {
            sb.append(result.get(i) + " ");
        }

        System.out.println(sb.toString());
    }

    public static int findMax(int[] arr, int startIndex, int endIndex) {
        int max = 0;
        for (int i = startIndex; i <= endIndex; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static int[] extractArray(String stringArray) {
        String[] strings = stringArray.split(" ");

        //Parse out "" and " "
        ArrayList<String> stringList = new ArrayList<String>();
        for (int i = 0; i < strings.length; i++) {
            if (!strings[i].equals("") && !strings[i].equals(" ")) {
                stringList.add(strings[i]);
            }
        }
        strings = stringList.toArray(new String[stringList.size()]);

        int[] array = new int[strings.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(strings[i]);
        }
        return array;
    }

}
