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

        //part 1
        int valid = 0;
        int valid2 = 0;

        for(int j = 0; j < array.length; j++){
            String miniString = array[j];
            String[] newString = miniString.split(" ");
            String[] numbers = newString[0].split("-");
            int first = Integer.parseInt(numbers[0]);
            int second = Integer.parseInt(numbers[1]);
            String letter = Arrays.toString(newString[1].split(":"));

            String letters = newString[2];

            int count = 0;
            for(int m = 0; m < newString[2].length(); m++){
                if(letter.indexOf(letters.charAt(m)) != -1){
                    count++;
                }
            }
            if(count >= first && count <= second){
                valid++;
            }

            //part 2
            int index1 = first -1;
            int index2 = second -1;

            String charIndex1 = String.valueOf(letters.charAt(index1));
            String charIndex2 = String.valueOf(letters.charAt(index2));
            String letter2 = String.valueOf(letter.charAt(1));

            if((charIndex1.contains(letter2)) ^ (charIndex2.contains(letter2))){
                valid2++;
            }
        }
        System.out.println("Part 1 valid: " + valid);
        System.out.println("Part 2 valid: " + valid2);
    }
}
