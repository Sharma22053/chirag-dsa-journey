class Solution {
    public List<Integer> largestDivisibleSubset(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int[] dp = new int[n];
        int maxi = 1,lastIndex = 0;
        Arrays.fill(dp,1);
        int[] hash = new int[n];
        for(int i=1;i<n;i++){
            hash[i] = i;
            for(int j=0;j<i;j++){
                if(arr[i] % arr[j] == 0 && dp[i] < dp[j] + 1){
                    dp[i] = dp[j] + 1;
                    hash[i] = j;
                }
            }
           if(maxi < dp[i]){
            maxi = dp[i];
            lastIndex = i;
           }
        }
        List<Integer> result = new ArrayList<>();
        result.add(arr[lastIndex]);
        while(hash[lastIndex] != lastIndex){
           
            lastIndex = hash[lastIndex];
             result.add(arr[lastIndex]);

        }
        return result;

    }
}