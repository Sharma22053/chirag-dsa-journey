class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer,Integer> hmap = new HashMap<>();
        for(int i: nums){
            hmap.put(i,hmap.getOrDefault(i,0)+1);
        }
        int max = 0;
        for(Integer value : hmap.values()){
            max = Math.max(value,max);
        }
        int frequency = 0;
        for(int i : hmap.values()){
            if(i == max){
                frequency += i;
            }
        }
        return frequency;
    }
}