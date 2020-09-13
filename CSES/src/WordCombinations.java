import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class WordCombinations {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String target = bufferedReader.readLine();
        int numSubstrings = Integer.parseInt(bufferedReader.readLine());

        Set<String> subStrings = new HashSet<>();
        for(int i=0; i<=numSubstrings; i++){
            subStrings.add(bufferedReader.readLine());
        }
    }
}
