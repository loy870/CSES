package Archive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class CountingRooms {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> firstLine = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int height = firstLine.get(0);
        int width = firstLine.get(1);

        char[][] arr = new char[height][width];

        for(int i = 0; i< height; i++){
            arr[i] = bufferedReader.readLine().toCharArray();
        }

        System.out.println(new CountingRooms().countRooms(arr));

    }

    boolean[][] visited;

    public int countRooms(char[][] grid){
        if(grid.length == 0)
            return 0;

        int result = 0;

        visited = new boolean[grid.length][grid[0].length];
        for(int y = 0; y <grid.length; y++){
            for(int x = 0; x<grid[0].length; x++){
                //count how many times this dfs gets invoked
                if(!visited[y][x] && grid[y][x] == '.'){
                    result++;
                    dfs(grid, new Cell(y, x));
                }
            }
        }


        return result;

    }

    private void dfs(char[][]grid, Cell cell){
        Stack<Cell> stack = new Stack<>();
        stack.push(cell);

        while(!stack.isEmpty()) {
            Cell topCell = stack.pop();
            int y = topCell.y;
            int x = topCell.x;

            if (y == grid.length || x == grid[0].length || visited[y][x] == true){
                continue;
            }
            else {
                visited[y][x] = true;

                if (grid[y][x] == '.') {
                    //look left
                    if (x > 0) {
                        stack.push(new Cell(y, x - 1));
                    }
                    //look right
                    if (x < grid[0].length - 1) {
                        stack.push(new Cell(y, x+1));
                    }
                    //look up
                    if (y > 0) {
                        stack.push(new Cell(y - 1, x));
                    }
                    //look down
                    if (y < grid.length - 1){
                        stack.push(new Cell(y + 1, x));
                    }

                }
            }
        }
    }

    class Cell {
        public int x;
        public int y;

        public Cell(int y, int x){
            this.x = x;
            this.y = y;
        }
    }
}
