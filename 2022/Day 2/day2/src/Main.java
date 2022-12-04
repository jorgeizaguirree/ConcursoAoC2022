import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    /*
    X -> Rock       - 1
    Y -> Paper      - 2
    Z -> Scissors   - 3

    A -> Rock
    B -> Paper
    C -> Scissors   
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
                        count = 8;
                    }
                    else if (user == 'X'){
                        count = 4;
                    }else {
                        count = 3;
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
                        count = 7;
                    }
                    else if (user == 'Z'){
                        count = 6;
                    }else{
                        count = 2;
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