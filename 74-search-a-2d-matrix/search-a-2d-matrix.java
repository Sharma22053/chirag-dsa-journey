class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int column = matrix[0].length;
        int low = 0;
        int high = (row*column) -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            int rowCordinate = mid/column;
            int columnCordinate = mid % column;

            if(matrix[rowCordinate][columnCordinate] == target){
                return true;
            } else if(matrix[rowCordinate][columnCordinate] > target){
                high = mid - 1;
            } else {
                low = mid+1;
            }
        }
         return false;
    }
}