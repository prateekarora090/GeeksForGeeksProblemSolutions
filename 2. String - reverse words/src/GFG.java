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
            //sc.nextLine();
            String input = sc.nextLine();
            reverseWords(input);
        }
    }

    public static void reverseWords(String input) {
        String[] words = input.split("\\.");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            sb.append(".");
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
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

