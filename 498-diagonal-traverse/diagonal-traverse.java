class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] result = new int[m*n];
        
        int row = 0 , column=0;
        for(int i=0;i<m * n;i++){
           result[i] = mat[row][column];
           if( (row + column) %2 == 0){
            if(column == n-1) row++;
            else if(row == 0) column++;
            else {
                column++;
                row--;
            }
           } else {
            if(row == m-1) column++;
            else if( column == 0) row++;
            else{
                row++;
                column--;
            }
           }
        }

        return result;
    }
}