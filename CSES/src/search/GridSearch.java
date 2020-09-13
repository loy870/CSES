package search;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GridSearch {


    // Complete the gridSearch function below.
    static String gridSearch(String[] G, String[] P) {
        char[][] grid = new char[G.length][G[0].length()];

        for (int i = 0; i < G.length; i++) {
            grid[i] = G[i].toCharArray();
        }

        char[][] target = new char[P.length][P[0].length()];

        for (int i = 0; i < P.length; i++) {
            target[i] = P[i].toCharArray();
        }

        for (int row = 0; row <= grid.length - target.length; row++) {
            for (int col = 0; col <= grid[0].length - target[0].length; col++) { //loop through grid

                if(grid[row][col] == target[0][0]) {
                    boolean matches = true;
                    for (int i = 0; i < target.length; i++) {
                        for (int j = 0; j < target[0].length; j++) {
                            if(grid[row+i][col+j] != target[i][j]){
                                matches = false;
                                break;
                            }
                        }
                    }
                  if(matches)
                      return "YES";
                }
            }
        }
        return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] RC = scanner.nextLine().split(" ");

            int R = Integer.parseInt(RC[0]);

            int C = Integer.parseInt(RC[1]);

            String[] G = new String[R];

            for (int i = 0; i < R; i++) {
                String GItem = scanner.nextLine();
                G[i] = GItem;
            }

            String[] rc = scanner.nextLine().split(" ");

            int r = Integer.parseInt(rc[0]);

            int c = Integer.parseInt(rc[1]);

            String[] P = new String[r];

            for (int i = 0; i < r; i++) {
                String PItem = scanner.nextLine();
                P[i] = PItem;
            }

            String result = gridSearch(G, P);

            System.out.println(result);
        }


        scanner.close();
    }
}
