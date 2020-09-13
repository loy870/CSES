import java.util.Scanner;

public class RomanNumerals {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        System.out.println(encodeRomanNumerals(input, 0));
    }

    static int encodeRomanNumerals(String s, int value){
        if(s.length() == 0)
            return value;

        if(s.length()>=2 && s.startsWith("IX")){
           return encodeRomanNumerals(s.substring(1, s.length()-1), value + 9);
        }
        if(s.charAt(0) == 'X'){
           return  encodeRomanNumerals(s.substring(1), value + 10);
        }
        if(s.length()==1 && s.charAt(0) == 'V'){
            return value +=5;
        }
        if(s.length()==4 && s.startsWith("VIII")){
            return value += 8;
        }



        return value;

    }
}
