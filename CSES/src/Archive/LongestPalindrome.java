package Archive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestPalindrome {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String word = bufferedReader.readLine();

        int result = 0;
        String resultString = "";
        for(int i = 0; i<word.length(); i++){
            for(int j = i; j<word.length();j++){
                String subString = word.substring(i,j+1);
                if(subString.equals(new StringBuilder(subString).reverse().toString())){
                    if(subString.length() > result){
                        result = subString.length();
                        resultString = subString;
                    }
                }
            }
        }

        System.out.println(resultString);
    }
}
