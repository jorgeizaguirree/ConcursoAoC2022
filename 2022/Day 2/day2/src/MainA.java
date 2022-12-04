import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class MainA {
    /*
    X -> lose       - 0
    Y -> draw       - 3
    Z -> win        - 6

    A -> Rock       - 1
    B -> Paper      - 2
    C -> Scissors   - 3
     */

    public static void main(String[] args) {
        try {
            List<String> allLines = Files.readAllLines(Paths.get("day2.input.txt"));
            int result = 0;
            int count = 0;
            char rival;
            char user;

            for (String line : allLines) {
                count = 0;
                rival = line.charAt(0);
                user = line.charAt(2);
                if (rival == 'A'){
                    if (user == 'Y'){
                        count = 4;
                    }
                    else if (user == 'X'){
                        count = 3;
                    }else {
                        count = 8;
                    }
                }
                else if (rival == 'B'){
                    if (user == 'Z'){
                        count = 9;
                    }
                    else if (user == 'Y'){
                        count = 5;
                    }else{
                        count = 1;
                    }
                }else{
                    if (user == 'X'){
                        count = 2;
                    }
                    else if (user == 'Z'){
                        count = 7;
                    }else{
                        count = 6;
                    }
                }
                result = result + count;
            }
            System.out.println("The total score wil be " + result + " points! ");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}