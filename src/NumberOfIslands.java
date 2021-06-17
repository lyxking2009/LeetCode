import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    public char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
    };
    private int[][] directions = {
            {1, 0},
            {0, 1},
            {-1, 0},
            {0, -1}
    };

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int countIslands = 0;
        HashSet<Integer> visited = new HashSet<>();
        Queue<int[]> curIsland = new LinkedList<>();

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                //found lands
                if (grid[i][j] == '1') {
                    int[] curGrid = new int[] {i, j};
                    int curGridHash = i * n + j;
                    // hasn't been visited before
                    if (!visited.contains(curGridHash)) {
                        visited.add(curGridHash);
                        curIsland.offer(curGrid);
                        while (!curIsland.isEmpty()) {
                            int[] point = curIsland.poll();
                            int row = point[0];
                            int column = point[1];
                            for (int[] direction : directions) {
                                int r = row + direction[0];
                                int c = column + direction[1];
                                // found valid land tile
                                if (r >= 0 && c >= 0 && r < m && c < n && grid[r][c] == '1') {
                                    curGrid = new int[] {r, c};
                                    curGridHash = r * n + c;
                                    if (!visited.contains(curGridHash)) {
                                        visited.add(curGridHash);
                                        curIsland.offer(curGrid);
                                    }
                                }
                            }
                        }
                        countIslands++;
                    }
                }
            }

        return countIslands;
    }
}
