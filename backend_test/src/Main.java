import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;


public class Main {

    private static String countStr = "";
    private static ResultSet rs;
    private static Statement st;
    private static TreeMap<String, Integer> color;


    public static void main(String [] args){

    task1();
    task2();

    }

    public static void task1(){
        try{
            color = new TreeMap<String, Integer>();

            countStr = "SELECT Count(color) as count, color FROM \"public.cats\" GROUP BY color;";
            DatabaseConn.getConn().prepareStatement(countStr).execute();

            st = DatabaseConn.getConn().createStatement();
            rs = st.executeQuery(countStr);

            while (rs.next()){
                color.put(rs.getString("color"),Integer.parseInt(rs.getString("count")));

            }

            for(Map.Entry<String, Integer> item : color.entrySet()){

                countStr = "INSERT INTO \"public.cats_colors_info\" " +
                        "values ('" + item.getKey() + "', " + item.getValue() + " );";

                DatabaseConn.getConn().prepareStatement(countStr).execute();
            }

        }

        catch (Exception ex){
            System.out.println("You have exception in the program =(");
            System.out.println("Exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static void task2(){
        try{

            countStr = "SELECT tail_length as tail, whiskers_length as whiskers FROM public.\"public.cats\";";
            st = DatabaseConn.getConn().createStatement();
            rs = st.executeQuery(countStr);


            ArrayList<Integer> tail = new ArrayList<>();
            ArrayList<Integer> whiskers = new ArrayList<>();


            while (rs.next()){
                tail.add(Integer.parseInt(rs.getString("tail")));
                whiskers.add(Integer.parseInt(rs.getString("whiskers")));
            }

            while (rs.next()){
                color.put(rs.getString("color"),Integer.parseInt(rs.getString("count")));

            }

            int[] tailArr = tail.stream().mapToInt(i -> i).toArray();
            int[] whiskersArr = tail.stream().mapToInt(i -> i).toArray();


            countStr = "INSERT INTO \"public.cats_stat\" values ("
                    + StatClass.calculateAverage(tail) + ", "
                    + StatClass.calculateMedian(tailArr) + ", ARRAY["
                    + StatClass.calculateMode(tailArr) + "], "
                    + StatClass.calculateAverage(whiskers) + ", "
                    + StatClass.calculateMedian(whiskersArr) + ", ARRAY["
                    + StatClass.calculateMode(whiskersArr) + "] );";

            DatabaseConn.getConn().prepareStatement(countStr).execute();

        }

        catch (Exception ex){
            System.out.println("You have exception in the program =(");
            System.out.println("Exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

}
