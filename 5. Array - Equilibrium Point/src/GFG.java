import java.util.ArrayList;
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
            findEquilibrium(array);
        }
    }

    public static void findEquilibrium(String stringsArray) {
        int[] arr = extractArray(stringsArray);
        int sum = findSum(arr);

        int leftSum = 0;
        int rightSum = sum;

        for (int i = 0; i < arr.length; i++) {
            rightSum -= arr[i];
            if (leftSum == rightSum) {
                System.out.println(i+1);
                return;
            } else {
                leftSum += arr[i];
            }
        }

        System.out.println("-1");
    }

    public static int findSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum +=arr[i];
        }
        return sum;
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
        strings = (String[]) stringList.toArray(new String[stringList.size()]);

        int[] array = new int[strings.length];
        for (int i = 0; i < array.length; i++) {
            System.out.println("Parsing " + strings[i]);
            array[i] = Integer.parseInt(strings[i]);
        }
        return array;
    }
}
