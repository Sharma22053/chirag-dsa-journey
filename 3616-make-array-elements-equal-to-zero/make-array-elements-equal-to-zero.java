class Solution {
    public int countValidSelections(int[] nums) {
        int count = 0;
        int nonZeros = 0;
        int n = nums.length;
        for(int i: nums) if(i > 0) nonZeros++;
        for(int i=0;i<n;i++){
            if(nums[i] == 0){
               if( helper(nums,nonZeros,i,-1)) count++;
               if(helper(nums,nonZeros,i,1))count++;

            }
        }
        return count;
    }
    private boolean helper(int[] nums,int nonZeros,int i,int direction){
        int n = nums.length;
        int current = i;
        int[] temp = nums.clone();
        while(nonZeros > 0 && current >= 0 && current < n){
            if(temp[current] > 0){
                temp[current]--;
                direction = direction * -1;
                if(temp[current] == 0)nonZeros--;
            }
            current += direction;
        }
        return nonZeros == 0;
    }
}