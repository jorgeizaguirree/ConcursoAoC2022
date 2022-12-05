import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    static char[] StringToArray(String line){
        char[] array = new char[line.length()];
        for (int i = 0; i < array.length; i++){
            array[i] = line.charAt(i);
        }
        return array;
    }
    public static void main(String[] args) {
        try {
            char item;
            int total = 0;
            int count = 0;
            char[] line1 = null;
            char[] line2 = null;
            char[] line3 = null;
            List<String> allLines = Files.readAllLines(Paths.get("day3.input.txt"));
            for (String line : allLines){
                item = ' ';
                char[] lineChar = StringToArray(line);
                if (count == 0) {
                    line1 = lineChar;
                    count++;
                }else if(count == 1){
                    line2 = lineChar;
                    count++;
                }else if (count == 2) {
                    line3 = lineChar;
                    System.out.println(line3);
                    boolean check = false;
                    for (int i = 0; i < line1.length && !check; i++) {
                        for (int j = 0; j < line2.length && !check; j++) {
                            for (int k = 0; k < line3.length && !check; k++) {
                                if (line1[i] == line2[j] && line1[i] == line3[k]) {
                                    item = line1[i];
                                    check = true;
                                }
                            }
                        }
                    }
                    count = 0;
                    System.out.println(item);
                }
                int value = 0;
                if (item >= 'a' && item <= 'z'){
                    value = item - 'a' + 1;
                }
                else if (item >= 'A' && item <= 'Z'){
                    value = item - 'A' + 27;
                }
                total = total + value;
                line = line + 3;
            }
            System.out.println("the sum of the priorities is " + total);



        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
