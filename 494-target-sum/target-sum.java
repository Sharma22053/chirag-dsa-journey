
class Solution {
    Integer[][]dp;
    public int findTargetSumWays(int[] arr, int d) {
        // code here
        
        int totalSum = 0;
        for(int i: arr){
            totalSum += i;
        }
        if((totalSum - d) < 0 || (totalSum - d) % 2 != 0 ) return 0;
        int target = (totalSum - d) / 2;
        dp = new Integer[arr.length+1][target+1];
        return helper(arr,target,0,0);
        
    }
    private int helper(int[] arr,int target,int sum,int index){
        if(index == arr.length) return sum == target ? 1 : 0 ;
       
        if(dp[index][sum] != null) return dp[index][sum];
        
        int take = 0;
        if(sum + arr[index] <= target){
            take =  helper(arr,target,sum+arr[index],index+1);
        }
        int leave = helper(arr,target,sum,index+1);
        return dp[index][sum] = take + leave;
    }
}
