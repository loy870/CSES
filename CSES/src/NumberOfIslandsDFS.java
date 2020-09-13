class NumberOfIslandsDFS {

    boolean[][] visited;

    public int numIslands(char[][] grid) {
        int result = 0;

        if(grid.length == 0)
            return result;

        visited = new boolean[grid.length][grid[0].length];


        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                if (!visited[y][x]) {
                    if(grid[y][x] == '1') {
                        //dfs
                        dfs(y, x, grid);
                        result++;
                    }
                }
            }
        }

        return result;
    }

    private void dfs(int y, int x, char[][] grid) {
        if (visited[y][x]) //already visited
            return;
        else {
            visited[y][x] = true;
            if (grid[y][x] == '0')
                return;

            //look right
            if (x < grid[0].length - 1)
                dfs(y, x + 1, grid);
            //look left
            if (x > 0)
                dfs(y, x - 1, grid);
            //look up
            if (y > 0)
                dfs(y - 1, x, grid);
            //look down
            if (y < grid.length - 1)
                dfs(y + 1, x, grid);
        }
    }

    public static void main(String[] args) {
        NumberOfIslandsDFS islands = new NumberOfIslandsDFS();

//        char[][] input = {
//                        {'1', '1', '1', '1', '0'},
//                        {'1', '1', '0', '1', '0'},
//                        {'1', '1', '0', '0', '0'},
//                        {'0', '0', '0', '0', '0'}
//        };
        char[][] input = {};
        System.out.println(islands.numIslands(input));
    }
}
