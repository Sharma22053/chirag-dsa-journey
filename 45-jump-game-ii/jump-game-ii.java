class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int left =0,jump =0;
        int right =0;
        while(right < n-1){
            int farthest = 0;
            for(int i=left;i<=right;i++){
                farthest = Math.max(farthest,i+nums[i]);
            }
            left = right + 1;
            right = farthest;
            jump++;

        }

        return jump;
           
        
    }
}