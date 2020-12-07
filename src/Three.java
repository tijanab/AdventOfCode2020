import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Arrays;
import java.util.Scanner;

public class Three {
    public static void main(String args[]) throws FileNotFoundException {
        String[] array = new String[323];

        URL url = One.class.getResource("three.txt");
        File text = new File(url.getPath());

        Scanner scanner = new Scanner(text);
        int i = 0;
        while (scanner.hasNextLine()) {
            array[i++] = scanner.nextLine();
        }

        long trees = travel(array, 1, 1);

        trees = trees * travel(array, 3, 1);
        trees = trees * travel(array, 5,1);
        trees = trees * travel(array, 7, 1);
        trees = trees * travel(array, 1, 2);

        System.out.println("Number of trees: " + trees);
    }

    public static int travel(String[] array, int right, int down){
        int trees = 0;
        int position = 0;

        for(int i = down; i < array.length; i += down){
            String string = array[i];
            String symbol = "#";
            position += right;
            int length = string.length();
            if(position > (length-1)){
                position = position-length;
            }
            if(symbol.indexOf(string.charAt(position)) != -1){
                trees++;
            }
        }
        System.out.println(trees);
        return trees;
    }
}
