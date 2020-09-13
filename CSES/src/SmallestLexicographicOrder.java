import java.io.IOException;
import java.util.Scanner;

public class SmallestLexicographicOrder {



    // Complete the biggerIsGreater function below.
    static String biggerIsGreater(String w) {

        char[] arr = w.toCharArray();
        boolean possible = false;
        String result = "no answer";
        for(int i = arr.length-1; i > 0; i--){
            if(arr[i-1] < arr[i]){
                possible = true;
                char temp = arr[i];
                arr[i] = arr[i-1];
                arr[i-1] = temp;
                break;
            }
        }
        if(possible){
            StringBuilder sb = new StringBuilder();
            for(char c: arr)
                sb.append(c);
            return sb.toString();
        }
        else
            return result;



    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int TItr = 0; TItr < T; TItr++) {
            String w = scanner.nextLine();

            String result = biggerIsGreater(w);

            System.out.println(result);
        }


        scanner.close();
    }
}
