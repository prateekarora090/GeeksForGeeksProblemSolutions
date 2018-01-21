/**
 * Created by prateek on 12/7/17.
 */
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main (String[] args) {
        //code
        Scanner sc = new Scanner(System.in);
        String numberOfCases = sc.nextLine();
        int n = Integer.parseInt(numberOfCases);

        for (int i = 0; i < n; i++) {
            sc.nextLine();
            String array = sc.nextLine();
            stockBuyAndSell(array);
        }
    }

    public static void stockBuyAndSell(String stringsArray) {
        int[] stockPrices = extractArray(stringsArray);

        List<Integer> buyIndices = new ArrayList<Integer>();
        List<Integer> sellIndices = new ArrayList<Integer>();

        //Assuming there is a buy index for every input
        boolean lookingForBuy = true;

        for (int i = 1; i < stockPrices.length; i++) {
            //Find buy
            if (lookingForBuy && stockPrices[i-1] <= stockPrices[i]) {
                buyIndices.add(i-1);
                lookingForBuy = false;
            }

            //Find sell
            if (!lookingForBuy) {
                if (stockPrices[i - 1] > stockPrices[i]) {
                    sellIndices.add(i - 1);
                    lookingForBuy = true;
                } else if (stockPrices.length == i + 1) {
                    sellIndices.add(i);
                }
            }
        }

        System.out.println(formResult(buyIndices, sellIndices));
    }

    public static String formResult(List<Integer> buyIndices, List<Integer> sellIndices) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < buyIndices.size(); i++) {
            result.append("(");
            result.append(buyIndices.get(i) + " ");
            result.append(sellIndices.get(i));
            result.append(")");
            result.append(" ");
        }

        if (result.length() > 0) {
            result.setLength(result.length() - 1);
        } else {
            return "No Profit";
        }

        return result.toString();
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
