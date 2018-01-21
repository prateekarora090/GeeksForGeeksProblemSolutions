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
            int[][] array = extract2DArray(sc);
            traverseMatrix(array);
        }
    }

    public static int[][] extract2DArray(Scanner sc) {
        //First row
        int[] array = extractArray(sc.nextLine());
        int[][] matrix = new int[array.length][array.length];
        matrix[0] = array;

        //All other rows
        int size = array.length;
        for (int i = 1 ; i < size; i++) {
            matrix[i] = extractArray(sc.nextLine());
        }

        return matrix;
    }

    public static void traverseMatrix(int[][] matrix) {
        ArrayList<Integer> order = new ArrayList<Integer>();

        int m = matrix.length;

        for (int i = 0;  i < m/2; i++) {
            //Top row
            for (int j = i; j <= m - i - 1; j++) {
                order.add(matrix[i][j]);
            }

            //Right row
            for (int j = i+1; j <= m-i-2; j++) {
                order.add(matrix[j][m-i-1]);
            }

            //Bottom row
            for (int j = m-i-1; j >= i; j--) {
                order.add(matrix[m-i-1][j]);
            }

            //Left row
            for (int j=m-i-2; j>=i+1; j--) {
                order.add(matrix[j][i]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < order.size(); i++) {
            sb.append(order.get(i) + " ");
        }

        System.out.println(sb.toString());
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
