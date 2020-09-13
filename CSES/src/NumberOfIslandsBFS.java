import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

class NumberOfIslandsBFS {

    boolean[][] visited;

    public int numIslands(char[][] grid) {
        int result = 0;

        if(grid.length == 0)
            return result;

        visited = new boolean[grid.length][grid[0].length];


        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                if (!visited[y][x] && grid[y][x] == '1') {
                    Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
                    Pair<Integer, Integer> coordinates = new Pair<>(y, x);
                    queue.add(coordinates);
                    while(!queue.isEmpty()){
                        Pair<Integer, Integer> pair = queue.poll();
                        int row = pair.getKey();
                        int col = pair.getValue();
                        visited[row][col] = true;

                        if(grid[row][col] == '1'){
                            //add adjacent coordinates to the queue
                            if(col < grid[0].length - 1){ //look right
                                pair = new Pair(col + 1, row);
                                queue.add(pair);
                            }
                            if(col > 0){         //look left
                                pair = new Pair<>(col - 1, row);
                                queue.add(pair);
                            }
                            if(row > 0){
                                pair = new Pair<>(col, row -1);
                                queue.add(pair);
                            }
                            if(row < grid.length-1){
                                pair = new Pair<>(col, row + 1);
                                queue.add(pair);
                            }
                        }
                        result++;
                    }

                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        NumberOfIslandsDFS islands = new NumberOfIslandsDFS();
//        char[][] input = {
//                        {'1', '1', '0', '1', '0'},
//                        {'1', '1', '0', '1', '0'},
//                        {'1', '1', '0', '0', '0'},
//                        {'0', '0', '0', '0', '0'}
//        };

        char[][] input = {
                            {'1','1','0','1','0'},
                            {'1','1','0','1','0'},
                            {'1','0','0','0','0'},
                            {'0','1','0','0','1'}
                          };
        System.out.println(islands.numIslands(input));
    }
}
