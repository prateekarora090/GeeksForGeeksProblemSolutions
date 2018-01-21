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
            sortByFreq(array);
        }
    }

    public static void sortByFreq(String stringsArray) {
        int[] array = extractArray(stringsArray);

        //Map each number to its frequency
        HashMap<Integer, Integer> numToFreq = new HashMap<Integer, Integer>();
        for (int num : array) {
            if (numToFreq.containsKey(num)) {
                int count = numToFreq.get(num);
                numToFreq.put(num, count + 1);
            } else {
                numToFreq.put(num, 1);
            }
        }

        //Map each frequency to list of nums
        SortedMap<Integer, List<Integer>> freqToNums = new TreeMap<Integer, List<Integer>>();
        for(int num: numToFreq.keySet()) {
            int freq = numToFreq.get(num);
            List<Integer> nums;
            if (freqToNums.containsKey(freq)) {
                nums = freqToNums.get(freq);
                nums.add(num);
            } else {
                nums = new ArrayList<Integer>();
                nums.add(num);
                freqToNums.put(freq, nums);
            }
        }

        //Produce resulting array
        List<Integer> result = new ArrayList<Integer>(array.length);
        Integer[] freqArr = freqToNums.keySet().toArray(new Integer[freqToNums.size()]);
        Arrays.sort(freqArr);
        Arrays.sort(freqArr, Collections.reverseOrder());

        for (int freq : freqArr) {
            //Find nums with this frequency
            List<Integer> nums = freqToNums.get(freq);

            //Sort these nums
            Collections.sort(nums);

            //Add them to the list
            for (Integer num : nums) {
                for (int i = 0; i < freq; i++) {
                    result.add(num);
                }
            }
        }

        System.out.println(formResult(result));
    }

    public static String formResult(List<Integer> array) {
        StringBuilder sb = new StringBuilder();
        for (Integer num : array) {
            sb.append(num + " ");
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
