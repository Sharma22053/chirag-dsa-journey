class Solution {
    public int numSpecial(int[][] mat) {
        int ans = 0;
        int row = mat.length;
        int col = mat[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 0)
                    continue;
                boolean good = true;
                for (int k = 0; k < row; k++) {
                    if (k != i && mat[k][j] == 1) {
                        good = false;
                        break;
                    }
                }

                for (int l = 0; l < col; l++) {
                    if (l != j && mat[i][l] == 1) {
                        good = false;
                        break;
                    } 
                }
                if (good)
                    ans++;
            }
        }
        return ans;
    }
}