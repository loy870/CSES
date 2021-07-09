package Archive;

import java.util.Scanner;

public class WeirdAlgorithm {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();

        long n = Long.parseLong(input);

        StringBuilder s = new StringBuilder();
        s.append(n);

        while(n!=1){
            s.append(" ");
            if(n % 2 == 1){
                n = n*3 + 1;
                s.append(n);
            }
            else{
                n = n/2;
                s.append(n);
            }
        }
        System.out.println(s.toString());
    }
}
