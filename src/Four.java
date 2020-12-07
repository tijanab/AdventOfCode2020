import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Four {
    public static void main(String[] args) throws FileNotFoundException {
        List<String> list = new ArrayList<>();

        URL url = One.class.getResource("four.txt");
        File text = new File(url.getPath());
        Scanner scanner = new Scanner(text);

        String passport = "";
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("")) {
                list.add(passport);
                passport = "";
            } else {
                passport += " " + line;
            }
        }
        list.add(passport); // adds in last passport found

        int valid = 0;
        int invalid = 0;

        for (String s : list) {
            if (s.contains("byr") && s.contains("iyr") && s.contains("eyr") && s.contains("hgt") && s.contains("hcl") && s.contains("ecl") && s.contains("pid")) {
                valid++;
            } else {
                invalid++;
            }
        }
        System.out.println("Valid: " + valid + " Invalid: " + invalid);
    }
}
