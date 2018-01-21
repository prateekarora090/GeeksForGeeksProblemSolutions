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
            sc.nextLine();
            String array = sc.nextLine();
            String array2 = sc.nextLine();
            sortAccordingToList(array, array2);
        }
    }

    public static void sortAccordingToList(String stringsArray, String stringsArray2) {
        int[] array = extractArray(stringsArray);
        int[] array2 = extractArray(stringsArray2);

        //element in array2 to count in array1
        HashMap<Integer, Integer> elementToCount = new HashMap<Integer, Integer>();

        //Go through array 2 and populate hashmap keys
        for (int i = 0; i < array2.length; i++){
            elementToCount.put(array2[i], 0);
        }

        //Go through array 1 and update count for each key
        for (Integer num : array) {
            if (elementToCount.containsKey(num)) {
                int count = elementToCount.get(num);
                elementToCount.put(num, count + 1);
            }
        }

        //Populate results by adding nums from array2 and appending others in array1 not from array2
        int[] result = new int[array.length];
        int index = 0;

        //1. Add elements present in array2
        for (Integer num : array2) {
            int count = elementToCount.get(num);
            for (int i = 0; i < count; i++) {
                result[index++] = num;
            }
        }

        //2. Add elements not present in array2
        ArrayList<Integer> restOfElements = new ArrayList<Integer>();
        for (Integer num : array) {
            if (!elementToCount.containsKey(num)) {
                restOfElements.add(num);
            }
        }
        Integer[] restOfElementsArr = restOfElements.toArray(new Integer[restOfElements.size()]);
        Arrays.sort(restOfElementsArr);
        for (Integer num : restOfElementsArr) {
            result[index++] = num;
        }

        System.out.println(formResult(result));
    }

    public static String formResult(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i] + " ");
        }
        return sb.toString();
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
