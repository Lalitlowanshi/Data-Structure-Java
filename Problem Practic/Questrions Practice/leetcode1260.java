class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int total = n * m;

        k = k % total; // optimize

        int[] arr = new int[total];

        // convert 2D -> 1D
        int idx = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                arr[idx++] = grid[i][j];
            }
        }

        // shift
        int[] shifted = new int[total];
        for(int i = 0; i < total; i++){
            shifted[(i + k) % total] = arr[i];
        }

        // convert back to 2D list
        List<List<Integer>> result = new ArrayList<>();
        idx = 0;
        for(int i = 0; i < n; i++){
            List<Integer> row = new ArrayList<>();
            for(int j = 0; j < m; j++){
                row.add(shifted[idx++]);
            }
            result.add(row);
        }

        return result;
    }
}
