class Solution {
    int size;
    Integer[][] dp;

    public int minimumTotal(List<List<Integer>> triangle) {
        size = triangle.size();
        dp = new Integer[size][size];

        return findSum(0, 0, triangle);
    }

    private int findSum(int row, int column, List<List<Integer>> triangle) {
        if (row == size)
            return 0;
        if (dp[row][column] != null)
            return dp[row][column];

        int left = findSum(row + 1, column, triangle);
        int right = findSum(row + 1, column + 1, triangle);

        return dp[row][column] = triangle.get(row).get(column) + Math.min(left, right);
    }
}