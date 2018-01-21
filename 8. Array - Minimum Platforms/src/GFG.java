import java.util.*;

/**
 * Created by prateek on 12/10/17.
 */
public class GFG {

    public static void main (String[] args) {
        //code
        Scanner sc = new Scanner(System.in);
        String numberOfCases = sc.nextLine();
        int n = Integer.parseInt(numberOfCases);

        for (int i = 0; i < n; i++) {
            sc.nextLine();
            String arrivals = sc.nextLine();
            String departures = sc.nextLine();
            findEquilibrium(arrivals, departures);
        }
    }

    public static void findEquilibrium(String arrivalString, String departureString) {
        System.out.println("Arrival String " + arrivalString);
        System.out.println("Departure String " + departureString);
        int[] arr = extractArray(arrivalString);
        int[] dept = extractArray(departureString);

        List<TrainSchedule> scheduleList = extractSchedule(arr, dept);
        List<TrainSchedule> arrivalList = new ArrayList<TrainSchedule>(scheduleList);
        Collections.sort(arrivalList, new TrainScheduleArrivalComparator());

        List<TrainSchedule> departureList = new ArrayList<TrainSchedule>(scheduleList);
        Collections.sort(departureList, new TrainScheduleDepartureComparator());

        int deptIndex = 0; int arrIndex = 0; int currNum = 0; int maxNum = 0;

        while (deptIndex < departureList.size() && arrIndex < arrivalList.size()) {
            //Next chronological event: arrival
            if (arrivalList.get(arrIndex).arrival < departureList.get(deptIndex).departure) {
                currNum++;
                arrIndex++;

                if (currNum > maxNum) {
                    maxNum = currNum;
                }
            }

            //Next chronological event: departure
            else if (departureList.get(deptIndex).departure < arrivalList.get(arrIndex).arrival) {
                currNum --;
                deptIndex++;
            }
        }

        System.out.println(maxNum);

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

    public static List<TrainSchedule> extractSchedule(int[] arr, int[] dept) {
        List<TrainSchedule> scheduleList = new ArrayList<TrainSchedule>();
        for (int i = 0; i < arr.length; i++) {
            scheduleList.add(new TrainSchedule(arr[i], dept[i]));
        }
        return scheduleList;
    }

    public static class TrainSchedule {
        public int arrival;
        public int departure;

        public TrainSchedule(int arrival, int departure) {
            this.arrival = arrival;
            this.departure = departure;
        }
    }

    public static class TrainScheduleArrivalComparator implements Comparator<TrainSchedule>
    {
        @Override
        public int compare(TrainSchedule schedule1, TrainSchedule schedule2) {
            if (schedule1.arrival < schedule2.arrival) {
                return -1;
            } else if (schedule1.arrival > schedule2.arrival) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public static class TrainScheduleDepartureComparator implements Comparator<TrainSchedule> {
        @Override
        public int compare(TrainSchedule schedule1, TrainSchedule schedule2) {
            if (schedule1.departure < schedule2.departure) {
                return -1;
            } else if (schedule1.departure > schedule2.departure) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
