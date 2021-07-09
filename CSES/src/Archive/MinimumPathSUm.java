package Archive;

public class MinimumPathSUm {


    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];

        for(int y = 0; y< grid.length; y++){
            for(int x = 0; x< grid[0].length; x++){
                if(x == 0 && y ==0)
                    dp[0][0] = grid[0][0];
                else
                    dp[y][x] = grid[y][x] + Math.min(y==0?Integer.MAX_VALUE-1:dp[y-1][x], x==0?Integer.MAX_VALUE-1:dp[y][x-1]);
            }
        }

        return dp[grid.length-1][grid[0].length-1];
    }


    public static void main(String[] args) {
        int[][] arr = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        MinimumPathSUm sum = new MinimumPathSUm();
        System.out.println(sum.minPathSum(arr));
    }
}
