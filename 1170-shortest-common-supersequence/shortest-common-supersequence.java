class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int[][] dp = new int[n+1][m+1];

       
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(i==0 || j==0) dp[i][j] = 0;
                else if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int row = n , column = m;
        while(row > 0 && column >0){
            if(str1.charAt(row-1) == str2.charAt(column-1)){
                sb.append(str1.charAt(row-1));
                row--;
                column--;
            } else if(dp[row-1][column] > dp[row][column-1]){
                sb.append(str1.charAt(row-1));
                row--;
            } else {
                sb.append(str2.charAt(column-1));
                column--;
            }
        }

        while(row>0){
            sb.append(str1.charAt(row-1));
            row--;
        }

        while(column>0){
            sb.append(str2.charAt(column-1));
            column--;
        }

        return sb.reverse().toString();
    }
}