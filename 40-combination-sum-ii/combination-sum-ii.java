class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> result = new ArrayList<>();
        generate(result,new ArrayList<>(),0,target,nums,0);
        return result;
    }

    static void generate(ArrayList<List<Integer>> result,
    ArrayList<Integer>temp, int start,int target,int[]nums,int sum ){
        if(sum == target){
            result.add(new ArrayList<>(temp));
            return;
        }

        if(sum > target) return;
        for(int i= start;i<nums.length;i++){
            
            if(i> start && nums[i] == nums[i-1]) continue;
            temp.add(nums[i]);
            generate(result,temp,i+1,target,nums,sum+nums[i]);
            temp.remove(temp.size()-1);
        }
    }
}