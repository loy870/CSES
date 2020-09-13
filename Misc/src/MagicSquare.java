public class MagicSquare {
    // Complete the formingMagicSquare function below.
    static int formingMagicSquare(int[][] s) {
        int[][] magicSq = {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}};

        int result = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result += Math.abs(s[i][j] - magicSq[i][j]);
            }
        }

        for (int l = 0; l < 4; l++) {

            rotateMatrix(3, magicSq);
            int nextResult = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    nextResult += Math.abs(s[i][j] - magicSq[i][j]);
                }
            }
            if (nextResult < result)
                result = nextResult;

            nextResult = 0;
            reflectHorizontally(magicSq);

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    nextResult += Math.abs(s[i][j] - magicSq[i][j]);
                }
            }
            if (nextResult < result)
                result = nextResult;

            nextResult = 0;

            reflectVertically(magicSq);
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    nextResult += Math.abs(s[i][j] - magicSq[i][j]);
                }
            }
            if (nextResult < result)
                result = nextResult;

        }


        return result;
    }

    static void rotateMatrix(
            int N, int mat[][]) {
        // Consider all squares one by one
        for (int x = 0; x < N / 2; x++) {
            // Consider elements in group
            // of 4 in current square
            for (int y = x; y < N - x - 1; y++) {
                // Store current cell in
                // temp variable
                int temp = mat[x][y];

                // Move values from right to top
                mat[x][y] = mat[y][N - 1 - x];

                // Move values from bottom to right
                mat[y][N - 1 - x]
                        = mat[N - 1 - x][N - 1 - y];

                // Move values from left to bottom
                mat[N - 1 - x][N - 1 - y] = mat[N - 1 - y][x];

                // Assign temp to left
                mat[N - 1 - y][x] = temp;
            }
        }
    }

    static void reflectHorizontally(int[][] mat){
        for(int i=0;i<3;i++){
            int temp = mat[0][i];
            mat[0][i] = mat[2][i];
            mat[2][i] = temp;
        }
    }

    static void reflectVertically(int[][] mat){
        for(int i=0;i<3;i++){
            int temp = mat[i][0];
            mat[i][0] = mat[i][2];
            mat[i][2] = temp;
        }
    }
}
