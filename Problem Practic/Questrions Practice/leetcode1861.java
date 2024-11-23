 public char[][] rotateTheBox(char[][] box) {
        int m = box.length;    // Number of rows
        int n = box[0].length; // Number of columns

        // Step 1: Apply gravity for each row
        for (int i = 0; i < m; i++) {
            int emptyPos = n - 1; // Track the position where a stone can fall
            for (int j = n - 1; j >= 0; j--) {
                if (box[i][j] == '#') {
                    // Move the stone to the farthest available empty position
                    box[i][j] = '.';
                    box[i][emptyPos--] = '#';
                } else if (box[i][j] == '*') {
                    // Obstacle resets the empty position
                    emptyPos = j - 1;
                }
            }
        }

        // Step 2: Rotate the box 90 degrees clockwise
        char[][] rotatedBox = new char[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rotatedBox[j][m - 1 - i] = box[i][j];
            }
        }

        return rotatedBox;
    }
