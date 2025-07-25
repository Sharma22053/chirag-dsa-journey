class Solution {
    public int maxSum(int[] nums) {
        int mn = Integer.MIN_VALUE;
        int sum = 0;
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i =0;i<nums.length;i++){
           if(!hashSet.contains(nums[i])){
                if(nums[i] > 0){
                    sum += nums[i];
                } else {
                    mn = Math.max(mn,nums[i]);
                }
           }
           hashSet.add(nums[i]);
        }

        if(sum == 0 && !hashSet.contains(0)) return mn;

        return sum;
    }
}