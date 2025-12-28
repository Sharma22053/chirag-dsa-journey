class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;
        for(int[] row : grid){
            count += helper(row);
        }
        return count;
    }

    private int helper(int[] row){
        int low = 0;
        int high = row.length;
        while(low < high){
            int mid = low + (high - low)/2;
            if(row[mid] < 0){
                high = mid;
            }else{
                low = mid+1;
            }
        }
        return row.length - low;
    }
}