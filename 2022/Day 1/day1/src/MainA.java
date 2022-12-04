import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class MainA {



    public static void main(String[] args) {
        try {
            List<String> allLines = Files.readAllLines(Paths.get("day1.input.txt"));
            int sum = 0;
            int max = 0;
            for (String line : allLines) {
                if (line.length() == 0) {
                    if (sum > max) {
                        max = sum;
                    }
                    sum = 0;
                }else {
                    int number = Integer.parseInt(line);
                    sum = sum + number;
                }
            }
            if (sum > max) {
                max = sum;
            }
            System.out.println("The result is " + max + " calories! ");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}