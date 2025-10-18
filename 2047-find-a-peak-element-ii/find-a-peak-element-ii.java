class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int low = 0;
        int high = mat[0].length-1;
        while(low<=high){
            int maxRow = 0,mid = low + (high - low)/2;

            for(int j =0;j<mat.length;j++){
                maxRow = mat[j][mid] >= mat[maxRow][mid]?j:maxRow;
            }

    boolean leftIsBig = mid-1 >= low && mat[maxRow][mid-1]>mat[maxRow][mid];
    boolean rightIsBig = mid + 1 <= high && mat[maxRow][mid+1]>mat[maxRow][mid];

            if(!leftIsBig && !rightIsBig){
                return new int[]{maxRow,mid};
            } else if(rightIsBig){
                low = mid+1;
            } else {
                high = mid-1;
            }
        }

        return null;
    }
}