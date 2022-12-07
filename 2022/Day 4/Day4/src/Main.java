import com.sun.jdi.IntegerValue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
public class Main {

    static String showArrayInt(int[] col){
        String array = "";
        for (int i = 0; i < col.length; i++){
            if (i == 0) {
                array = array + col[i];
            } else{
                array = array + "," + col[i];
            }
        }
        return "{" + array + "}";
    }

    static int[] StringToArray(String line){
        int[] array = new int[line.length()];
        String[] pairs = line.split(",", 0);
        String[] individuals = null;
        int count = 0;
        for (int i = 0; i < 2; i++) {
            individuals = pairs[i].split("-", 0);
            for (int j = 0; j < 2; j++){
                array[count] = Integer.parseInt(individuals[j]);
                count++;
            }
        }
        return array;
    }



    public static void main(String[] args) {
        try {
            List<String> allLines = Files.readAllLines(Paths.get("day4.input.txt"));
            String[] allLinesArray = allLines.toArray(new String[0]);
            int count = 0;
            for (int i = 0; i < allLinesArray.length; i++) {
                int[] line = StringToArray(allLinesArray[i]);
                if (line[0] < line[2] && line[1] >= line[3]) {
                    count++;
                }
                if (line[0] > line[2] && line[1] <= line[3]){
                    count++;
                }
                if (line[0] == line[2]){
                    count++;
                }
                System.out.println(showArrayInt(line) + " " + count);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}