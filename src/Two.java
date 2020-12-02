import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Arrays;
import java.util.Scanner;

public class Two {
    public static void main(String args[]) throws FileNotFoundException {
        String[] array = new String[1000];

        URL url = One.class.getResource("two.txt");
        File text = new File(url.getPath());

        Scanner scanner = new Scanner(text);
        int i = 0;
        while(scanner.hasNextLine()){
            array[i++] = scanner.nextLine();
        }

        for(int j = 0; j < array.length; j++){
            String miniString = array[j];
            String[] newString = miniString.split(" ");
        }
    }
}
