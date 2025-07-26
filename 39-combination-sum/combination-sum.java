class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        generate(result,new ArrayList<Integer>(),0,target,candidates,0);
        return result;
    }

    static void generate(ArrayList<List<Integer>> result,ArrayList<Integer> temp, int start,int target, int[] candidates,int sum){
        if(sum == target){
            result.add(new ArrayList<>(temp));
            return;
        }
        if(sum > target) return;
        for(int i = start;i<candidates.length;i++){
            temp.add(candidates[i]);
            generate(result,temp,i,target,candidates,sum+candidates[i]);
            temp.remove(temp.size() - 1);
        }
    }
}