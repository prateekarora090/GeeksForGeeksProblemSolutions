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
            trappingRainWater(array);
        }
    }

    public static void trappingRainWater(String stringsArray) {
        int[] levelArray = extractArray(stringsArray);
        int[] waterArray = new int[levelArray.length];
        waterArray[0] = levelArray[0];

        for (int i = 1; i < levelArray.length; i++) {
            int currentLevel = levelArray[i];

            //Find last index that's larger or equal to current
            int prevLevel = -1;
            int prevIndex = -1;
            int prevMax = 0; int maxIndex = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (levelArray[j] > prevMax) {
                    prevMax = levelArray[j];
                    maxIndex = j;
                }
                if (levelArray[j] >= currentLevel) {
                    prevLevel = levelArray[j];
                    prevIndex = j;
                    break;
                }
            }

            //If none found, set previous index to 0
            if (prevIndex == -1 && prevLevel == -1) {
                prevIndex = maxIndex;
                prevLevel = prevMax;
            }

            int level = Math.min(prevLevel, currentLevel);
            updateWaterArray(waterArray, prevIndex, i, level);

        }

        int sum = 0;
        for (int i = 0; i < waterArray.length; i++) {
            sum += waterArray[i] - Math.min(levelArray[i], waterArray[i]);
        }

        System.out.println(sum);
    }

    public static void updateWaterArray(int[] waterArray, int fromIndex, int toIndex, int level) {
        for (int i = fromIndex + 1; i <= toIndex; i++) {
            waterArray[i] = level;
        }
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
