class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] mat = new int[n][n];
        for(int[] arr : queries){
            addOne(mat,arr[0],arr[1],arr[2],arr[3]);
        }
        return mat;

    }
    private void addOne(int[][] mat,int row1,int column1,int row2,int column2){
        for(int i=row1;i<=row2;i++){
            for(int j= column1;j<=column2;j++){
                mat[i][j] += 1;
            }
        }
    }
}