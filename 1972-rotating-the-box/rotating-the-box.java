class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length, n = box[0].length;

        for (int i = 0; i < m; ++i) {
            int writePointer = n - 1; 
            for (int j = n - 1; j >= 0; --j) {
                if (box[i][j] == '#') {
                    char temp = box[i][writePointer];
                    box[i][writePointer] = box[i][j];
                    box[i][j] = temp;
                    writePointer--;
                } else if (box[i][j] == '*') {
                    writePointer = j - 1;
                }
            }
        }

        char[][] rotatedBox = new char[n][m];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                rotatedBox[j][m - 1 - i] = box[i][j];
            }
        }

        return rotatedBox;
    }
}