import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class MainA {

    static char[] StringToArray(String line){
        char[] array = new char[line.length()];
        for (int i = 0; i < array.length; i++){
            array[i] = line.charAt(i);
        }
        return array;
    }
    public static void main(String[] args) {
        try {
            char item = ' ';
            int total = 0;
            List<String> allLines = Files.readAllLines(Paths.get("day3.input.txt"));
            for (String line : allLines){
                item = ' ';
                char[] lineChar = StringToArray(line);
                boolean check = false;
                int value = 0;
                for (int i = 0; i < lineChar.length / 2 && !check; i++){
                    for (int pos = lineChar.length - 1; pos >= lineChar.length / 2 && !check; pos--){
                        if (lineChar[i] == lineChar[pos]){
                            item = lineChar[i];
                            check = true;
                        }
                    }
                }
                if (item >= 'a' && item <= 'z'){
                    value = item - 'a' + 1;
                }
                else if (item >= 'A' && item <= 'Z'){
                    value = item - 'A' + 27;
                }
                if (lineChar.length % 2 != 0){
                    System.out.println("odd length");
                }
                total = total + value;
                System.out.println(item + " " + value);
            }
            System.out.println("the sum of the priorities is " + total);



        } catch (IOException e){
            e.printStackTrace();
        }
    }
}