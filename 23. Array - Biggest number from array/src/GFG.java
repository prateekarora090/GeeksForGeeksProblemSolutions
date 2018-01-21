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
            largestNumberFromArray(input);
        }
    }

    public static void largestNumberFromArray(String input) {

        boolean result = parenthesisCheck(input);

        if (result) {
            System.out.println("balanced");
        } else {
            System.out.println("not balanced");
        }
    }

    public static boolean parenthesisCheck(String input) {
        int circleCount = 0;
        int squareCount = 0;
        int curlyCount = 0;

        for (char c: input.toCharArray()) {
            switch (c) {
                case '{':
                    curlyCount++;
                    break;
                case '[':
                    squareCount++;
                    break;
                case '(':
                    circleCount++;
                    break;
                case '}':
                    if (curlyCount < 1) {
                        return false;
                    } else {
                        curlyCount--;
                    }
                    break;
                case ']':
                    if (squareCount < 1) {
                        return false;
                    } else {
                        squareCount--;
                    }
                    break;
                case ')':
                    if (circleCount < 1) {
                        return false;
                    } else {
                        circleCount--;
                    }
                    break;
            }
        }

        if (circleCount > 0 || squareCount > 0 || curlyCount > 0) {
            return false;
        }

        return true;
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

