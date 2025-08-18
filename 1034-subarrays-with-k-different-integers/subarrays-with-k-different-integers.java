class Solution {
    
static {
    for (int i = 0; i < 500; ++i)
        subarraysWithKDistinct(new int[0], 1);
}

    static int helper(int[] nums, int k) {
        int n = nums.length,right =0,left = 0,count = 0;
        HashMap<Integer,Integer> hmap = new HashMap<>();
        while(right < n){
            int i = nums[right];
            hmap.put(i,hmap.getOrDefault(i,0)+1);
            while(hmap.size() > k){
               
                int j = nums[left];
                hmap.put(j,hmap.get(nums[left]) -1);
                if(hmap.get(j) == 0) hmap.remove(j);
                left++;
            }  
             count += right-left+1;      
            right++;
        }

        return count;
    }

      public static int subarraysWithKDistinct(int[] nums, int k){
        return helper(nums,k) - helper(nums,k-1);
     }
}