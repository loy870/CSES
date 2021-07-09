package Archive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class HackerrankDecryption {



    /*
     * Complete the 'decryptPassword' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String decryptPassword(String s) {
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();

        for(int i = 0; i<arr.length; i++){
            if(Character.isDigit(arr[i])){
                for(int j = arr.length-1; j>i; j--){
                    if(arr[j] == '0'){
                        arr[j] = arr[i];
                        arr[i] = '\u0000';
                        break;
                    }
                }

            }
            else if(i+2<arr.length && Character.isUpperCase(arr[i]) && Character.isLowerCase(arr[i+1]) &&
                    arr[i+2] == '*'){
                char temp = arr[i+1];
                arr[i+1] = arr[i];
                arr[i] = temp;
                arr[i+2] = '\u0000';
            }
        }
        sb.append(arr);
        return sb.toString();

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));


        String result = decryptPassword("51Pa*0Lp*0e");

       System.out.println(result);

        bufferedReader.close();

    }


}
