public class WordSearch {


    boolean globalResult = false;
    public boolean exist(char[][] grid, String word) {

        if(grid.length == 0)
            return false;

        int maxX = grid[0].length;
        int maxY = grid.length;

        char[] arr = word.toCharArray();
        char first = arr[0];

        for(int y = 0; y < maxY; y++){
            for(int x=0; x < maxX; x++){
                if(grid[y][x] == first){
                    //do dfs
                    boolean [][] visited = new boolean[maxY][maxX];
                    globalResult = dfs(arr[0], y, x, grid, arr, 0, visited);

                    if(globalResult == true)
                        return globalResult;
                }
            }
        }

        return globalResult;

    }

    private boolean dfs(char c, int y, int x, char[][] grid, char[] arr, int index, boolean[][] visited){
        int maxX = grid[0].length;
        int maxY = grid.length;

        if(x == maxX || y == maxY || grid[y][x] != c || visited[y][x])
            return false;

        visited[y][x] = true;
        boolean localResult = false;

        if(index == arr.length-1) {
            return true;
        }


        else if(index < arr.length){
            //look right
           localResult =
                dfs(arr[index+1], y, x+1, grid, arr, index+1, visited) ||
           // look left
                dfs(arr[index + 1], y, x-1, grid, arr, index+1, visited) ||
            //look up
                dfs(arr[index + 1], y - 1, x, grid, arr, index+1, visited) ||
            //look down
                dfs(arr[index + 1], y + 1, x, grid, arr, index+1, visited);
        }
        return localResult;

    }
}
