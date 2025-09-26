class Solution {
    public int triangleNumber(int[] nums) {
       int n = nums.length , count = 0;
        Arrays.sort(nums);
        for(int i=0;i<n-2;i++){
            int k = i+2;
            for(int j=i+1;j<n-1 && nums[i] != 0;j++){
                k = binarySearch(nums,k,n-1,nums[i]+nums[j]);
                count += k-j-1;
            }
        }
        return count;
    }

    private int binarySearch(int[] nums,int left,int right,int x){
        while(right >= left && right < nums.length){
            int mid = (left+right)/2;
            if(nums[mid] >= x){
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return left;
    }
}