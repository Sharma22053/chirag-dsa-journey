class Solution {
    public int minOperations(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int result =0;
        for(int i : nums){
            while(!list.isEmpty() && list.get(list.size()-1) > i){
                list.remove(list.size()-1);
            }
            if(i == 0) continue;
            if(list.isEmpty() || list.get(list.size() -1 ) < i){
                result++;
                list.add(i);
            }
        }
        return result;
    }
}