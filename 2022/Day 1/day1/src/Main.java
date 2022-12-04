import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {

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
            int max1 = max;
            sum = 0;
            max = 0;
            for (String line : allLines) {
                if (line.length() == 0) {
                    if (sum > max) {
                        if (sum != max1) {
                            max = sum;
                        }
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
            int max2 = max;
            sum = 0;
            max = 0;
            for (String line : allLines) {
                if (line.length() == 0) {
                    if (sum > max) {
                        if (sum != max1 && sum != max2) {
                            max = sum;
                        }
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
            int max3 = max;
            int total = max1 + max2 + max3;
            System.out.println("The result is " + total + " calories! ");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}