class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();

        backTrack(resultList,new ArrayList<>(),nums,0);
        return resultList;
    }

    private void backTrack(List<List<Integer>> resultSet,ArrayList<Integer> tempList,int[] nums, int start){
        
        resultSet.add(new ArrayList<>(tempList));
        for(int i = start;i<nums.length;i++){
            tempList.add(nums[i]);

            backTrack(resultSet,tempList,nums,i+1);
            tempList.remove(tempList.size()-1);
            
        }
    }
}