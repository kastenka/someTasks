import java.util.ArrayList;
import java.util.Random;

public class Main {

    private static int ARRAY_SIZE = 2;
    private static Random RANDOM = new Random();


    public static void merge(ArrayList<Integer> a, ArrayList<Integer> b) {

        int fullSize = 2*a.size();
        int arrayAI = 0, arrayBI = 0;

        ArrayList<Integer> newArr = new ArrayList<>(a.size());
        newArr.addAll(a);
        a.clear();


        for(int i=0; i<fullSize; i++){

            if (arrayAI >= newArr.size()) {
                a.add(b.get(arrayBI));
                arrayBI++;
            }
            else if (arrayBI >= b.size()) {
                a.add(newArr.get(arrayAI));
                arrayAI++;
            }
            else if (newArr.get(arrayAI) <= b.get(arrayBI)) {
                a.add(newArr.get(arrayAI));
                arrayAI++;
            }
            else {
                a.add(b.get(arrayBI));
                arrayBI++;
            }
        }
    }


    private void createArrSize(){
        ARRAY_SIZE = Math.max(ARRAY_SIZE, RANDOM.nextInt(5));
    }

    private static ArrayList<Integer> creareArrList() {
        ArrayList<Integer> newArr = new ArrayList<>();
        int value = 0;

        for (int i = 0; i < ARRAY_SIZE; i++) {
            value += RANDOM.nextInt(10);
            newArr.add(value);
        }

        System.out.println("List: " + newArr);
        return newArr;
    }

    public static void main(String[] args) {
        Main newObj = new Main();
        newObj.createArrSize();

        ArrayList<Integer> a = creareArrList();
        ArrayList<Integer> b = creareArrList();
        merge(a, b);
        System.out.println("Array 'A': " + a);
        System.out.println("Array 'B': " + b);

    }

}