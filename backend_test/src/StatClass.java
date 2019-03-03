import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public class StatClass {

    public static double calculateAverage(List<Integer> list) {
        Integer sum = 0;
        if(!list.isEmpty()) {
            for (Integer item : list) {
                sum += item;
            }
            return sum.doubleValue() / list.size() ;
        }
        return sum;
    }


    public static List<Integer> calculateMode(int[] numbers) {
        List<Integer> modes = new ArrayList<Integer>();
        Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        int max = -1;

        for (int n : numbers) {
            int count = 0;

            if (countMap.containsKey(n)) {
                count = countMap.get(n) + 1;
            } else {
                count = 1;
            }

            countMap.put(n, count);

            if (count > max) {
                max = count;
            }
        }

        for (Map.Entry<Integer, Integer> tuple : countMap.entrySet()) {
            if (tuple.getValue() == max) {
                modes.add(tuple.getKey());
            }
        }
        return modes;
    }


    public static double calculateMedian(int[] list){
        Arrays.sort(list);
        double median=0.0;
        try{
            if (list.length % 2 == 0)
                median = ((double) list[list.length/2] +
                        (double) list[list.length/2 - 1])/2;

            else
                median = (double) list[list.length/2];

        }
        catch (Exception ex) {
            System.out.println("You have exception in the program =(");
            System.out.println("Exception: " + ex.getMessage());
            ex.printStackTrace();
        }

        return median;
    }
}
