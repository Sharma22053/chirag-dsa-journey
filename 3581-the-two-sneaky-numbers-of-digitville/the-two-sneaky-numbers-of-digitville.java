class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int[] result = new int[2];
        int j = 0;
        for(int i : nums){
            if(set.contains(i)){
                result[j++] = i;
            }
        set.add(i);
        }
        return result;
    }
}