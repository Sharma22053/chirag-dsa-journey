class Solution {
    private int lowerBound(int[] nums,long target){
        int left =0, right = nums.length;
        while(left < right){
            int mid = (left + right)/2;
            if(nums[mid] < target) left = mid+1;
            else right = mid;
        }
        return left;
    }
    private int upperBound(int[] nums,long target){
        int left =0, right = nums.length;
        while(left < right){
            int mid = (left + right)/2;
            if(nums[mid] <= target) left = mid+1;
            else right = mid;
        }
        return left;
    }
    private int check(int[] nums,int n,int target,int m){
        long nL =n;
        long tL = target;

        int l = lowerBound(nums,nL);
        int h = upperBound(nums,nL);
        int ll = lowerBound(nums,nL-tL);
        int hh = upperBound(nums,nL+tL);
        int result = (hh-h) + (l-ll);
        return Math.min(m,result)+ (h-l);
    }
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Arrays.sort(nums);
        int m = numOperations;
        int answer = 1;
        for(int i=0;i<nums.length-1;i++){
            answer = Math.max(answer,check(nums,nums[i],k,m));
            answer = Math.max(answer,check(nums,nums[i]-k,k,m));
            answer = Math.max(answer,check(nums,nums[i]+k,k,m));
        }
        return answer;
    }
}