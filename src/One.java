import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.*;

public class One {
    public static void main(String args[]) throws FileNotFoundException{
        int[] array = new int[200];

        URL url = One.class.getResource("one.txt");
        File text = new File(url.getPath());

        Scanner scanner = new Scanner(text);
        int i = 0;
        while(scanner.hasNextInt()){
            array[i++] = scanner.nextInt();
        }
        //part 1
        for (int first : array) {
            for (int second : array) {
                int sum = first + second;
                if (sum == 2020) {
                    int multiply = first * second;
                    System.out.println(first + " * " + second + " = " + multiply);
                    break;
                }
            }
        }
        //part 2
        for (int first : array) {
            for (int second : array) {
                for (int third : array) {
                    int sum = first + second + third;
                    if (sum == 2020) {
                        int multiply = first * second * third;
                        System.out.println(first + " * " + second + " * " + third + " = " + multiply);
                    }
                }
            }
        }
    }

}
