import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
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

        int legal = 0;
        int valid = 0;

        for(String s : list){
            //part 1
            if(isLegal(s)){
                legal++;
            }
            //part 2
            if(isLegal(s) && isValid(s)){
                valid++;
            }
        }

        System.out.println("Legal: " + legal + " Valid: " + valid);
    }

    public static boolean isLegal(String string){
            if (string.contains("byr") && string.contains("iyr") && string.contains("eyr") && string.contains("hgt") && string.contains("hcl") && string.contains("ecl") && string.contains("pid")) {
                return true;
            }
        return false;
    }

    public static boolean isValid(String string){
//part 2
        //at least 1920 and at most 2020
        String byrReg = "19[2-9][0-9]|200[0-2]";
        //at least 2010 and at most 2020
        String iyrReg = "201[0-9]|2020";
        //at least 2020 and at most 2030
        String eyrReg = "202[0-9]|2030";
        //a number followed with cm or in
        //if cm, at least 150 and at most 193
        //if in, at least 59 and at most 76
        String hgtReg = "1[5-8][0-9]cm|19[0-3]cm|59in|6[0-9]in|7[0-6]in";
        //a # followed by exactly six characters 0-9 or a-f
        String hclReg = "#[0-9a-f]{6}";
        //exactly on of amb, blu, brn, gry, grn, hzl, oth
        String eclReg = "amb|blu|brn|gry|grn|hzl|oth";
        //a nine-digit number, including leading zeroes
        String pidReg = "[0-9]{9}";

        String[] split = string.split(" ");
        for(String s : split){
            //System.out.println(Arrays.toString(split));
            if (s.startsWith("byr") && !s.replace("byr:", "").matches(byrReg)) {
                return false;
            } else if(s.startsWith("iyr") && !s.replace("iyr:", "").matches(iyrReg)){
                return false;
            } else if(s.startsWith("eyr") && !s.replace("eyr:", "").matches(eyrReg)){
                return false;
            } else if(s.startsWith("hgt") && !s.replace("hgt:", "").matches(hgtReg)){
                return false;
            } else if(s.startsWith("hcl") && !s.replace("hcl:", "").matches(hclReg)){
                return false;
            } else if(s.startsWith("ecl") && !s.replace("ecl:", "").matches(eclReg)){
                return false;
            } else if(s.startsWith("pid") && !s.replace("pid:", "").matches(pidReg)){
                return false;
            }
        }
        return true;
    }
}
