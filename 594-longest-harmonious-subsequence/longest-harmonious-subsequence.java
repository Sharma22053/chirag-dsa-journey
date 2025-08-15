class Solution {
    public int findLHS(int[] nums) {
        HashMap<Integer,Integer> hmap = new HashMap<>();
        int count = 0;
        for(int i=0;i<nums.length;i++){
            hmap.put(nums[i],hmap.getOrDefault(nums[i],0) +1);
        }

        for(int i=0;i<nums.length;i++){
            if(hmap.containsKey(nums[i] + 1)){
                count = Math.max(count , hmap.get(nums[i]) + hmap.get(nums[i] + 1));
            }
        }

        return count;
    }
}