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
            String line = sc.nextLine();
            String[] parts = line.split(" ");
            int k = Integer.parseInt(parts[0]);
            String array = sc.nextLine();
            kthInAStream(array, k);
        }
    }

    public static void kthInAStream(String stringsArray, int k) {
        int[] array = extractArray(stringsArray);
        int[] results = new int[array.length];
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k);

        //Add first k elements
        for (int i = 0; i < k; i++) {
            queue.add(array[i]);
            results[i] = i == k - 1 ? queue.peek() : -1;
        }

        for (int i = k; i < array.length; i++) {
            int kthElement = queue.peek() != null? queue.peek() : 0;
            //Else if element is larger than smallest element, insert
            if (array[i] > kthElement){
                queue.remove(kthElement);
                queue.add(array[i]);
            }

            results[i] = queue.peek();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < results.length; i++) {
            sb.append(results[i]);
            sb.append(" ");
        }

        System.out.println(sb.toString());
    }

    public static int[] extractArray(String stringArray) {
        String[] strings = stringArray.split(" ");
        int[] array = new int[strings.length];
        for (int i = 0; i < array.length; i++) {
            if (!strings[i].equals("")) {
                array[i] = Integer.parseInt(strings[i]);
            }
        }
        return array;
    }
}
