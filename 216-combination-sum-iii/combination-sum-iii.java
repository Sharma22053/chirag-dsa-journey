class Solution {
    public List<List<Integer>> combinationSum3(int k, int target) {
    
    List<List<Integer>> result = new ArrayList<>();
    generate(result,new ArrayList<Integer>(), k, target,1,0);
    return result;
}

static void generate(List<List<Integer>>result,ArrayList<Integer> temp, int k, int target,int start, int sum){
    if(sum == target && temp.size() == k){
        result.add(new ArrayList<>(temp));
        return;
    }
    if(sum > target) return;
    for(int i = start;i<=9;i++){
        temp.add(i);
        generate(result,temp, k, target,i+1,sum+i);
        temp.remove(temp.size()-1);

    }
}
}