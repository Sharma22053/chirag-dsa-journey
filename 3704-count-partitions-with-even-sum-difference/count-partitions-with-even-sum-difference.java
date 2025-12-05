class Solution {
    public int countPartitions(int[] nums) {
        int sum = 0 , n = nums.length;
        for(int i : nums) sum += i;
        int count = 0;
        int iSum = 0 , jSum = 0;
        int i =0 , j =0;
        while(j < n-1){
            iSum += nums[i];
            jSum = sum - iSum;
            if((iSum - jSum) % 2 == 0) count++;
            i++;
            j++;
        }
        return count;
    }
}