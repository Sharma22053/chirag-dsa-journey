class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        if(nums.size() < 2*k) return false;
        for(int i=0;i<=nums.size() - 2 *k;i++){
            boolean first = true;
            boolean second = true;

          if(k > 1){
              for(int j=i;j<i+k-1;j++){
                if(nums.get(j) >= nums.get(j+1)){
                    first = false;
                    break;
                }
            }
          }

            if(k > 1){
                for(int j = i+k;j<i+ 2*k-1;j++){
                if(nums.get(j) >= nums.get(j+1)){
                    second = false;
                    break;
                }
            }
            }

            if(first && second ) return true;
        }
        return false;
    }
}