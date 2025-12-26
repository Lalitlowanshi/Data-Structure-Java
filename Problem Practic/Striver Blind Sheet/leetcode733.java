class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int originalColor = image[sr][sc];

        // agar color same hai, kuch mat karo
        if (originalColor == color) {
            return image;
        }

        dfs(image, sr, sc, originalColor, color);
        return image;
    }

    void dfs(int[][] image, int r, int c, int original, int color) {

        // boundary + color check
        if (r < 0 || c < 0 || r >= image.length || c >= image[0].length)
            return;

        if (image[r][c] != original)
            return;

        // color fill
        image[r][c] = color;

        // 4 directions
        dfs(image, r + 1, c, original, color); // down
        dfs(image, r - 1, c, original, color); // up
        dfs(image, r, c + 1, original, color); // right
        dfs(image, r, c - 1, original, color); // left
    }
}
