class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int str1Length = str1.length();
        int str2Length = str2.length();

        int[][] dp = new int[str1Length+1][str2Length+1];

        for(int i=0;i<=str1Length;i++){
        for(int j=0;j<=str2Length;j++){
            if(i == 0 || j== 0) dp[i][j] = 0;

            else if (str1.charAt(i-1) == str2.charAt(j-1)){
                dp[i][j] = 1 + dp[i-1][j-1];
            }
            else {
                dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
            }
        }

        }

        StringBuilder sb = new StringBuilder();
        int row = str1Length , column = str2Length;
        while(row > 0 && column >0){
            if(str1.charAt(row-1) == str2.charAt(column-1)){
                sb.append(str1.charAt(row-1));
                row--;
                column--;
            }
            else if(dp[row-1][column] > dp[row][column-1] ){
                sb.append(str1.charAt(row-1));
                row--;
            } else {
                sb.append(str2.charAt(column-1));
                column--;
            }
        }

        while(row > 0){
            sb.append(str1.charAt(row-1));
            row--;
        }

        while(column > 0){
            sb.append(str2.charAt(column-1));
            column--;
        }

        return sb.reverse().toString();
    }
}