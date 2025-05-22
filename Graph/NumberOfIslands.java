import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    static int m, n, numberOfIslands;
    static int[][] reach = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private static int islandCount(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == '1') {
                    numberOfIslands++;
                    dfs(grid, r, c);
                }
            }
        }
        return numberOfIslands;
    }

    private static void dfs(char[][] grid, int r, int c) {
        Queue<int[]> connected = new LinkedList<>();
        connected.offer(new int[]{r, c});
        while(!connected.isEmpty()) {
            int[] polled = connected.poll();
            for(int[] dir : reach) {
                r = polled[0] + dir[0];
                c = polled[1] + dir[1];

                if (r < m && r >= 0 && c < n && c >= 0 && grid[r][c] == '1') {
                    grid[r][c] = '0';
                    connected.offer(new int[]{r, c});
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] input = {
                        {'1','1','0','0','0'},
                        {'1','1','0','0','0'},
                        {'0','0','1','0','0'},
                        {'0','0','0','1','1'}
                        };
        System.out.println("Number of island in result set is - " + islandCount(input));
    }
}
