class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer,Integer> hmap = new HashMap<>();
        for(int i: nums){
            hmap.put(i,hmap.getOrDefault(i,0)+1);
        }
        int max = 0;
        for(Integer value : hmap.values()){
            if(value > max){
                max = value;
            }
        }
        int frequency = 0;
        for(Map.Entry<Integer,Integer> entry : hmap.entrySet()){
            if(entry.getValue() == max){
                frequency += entry.getValue();
            }
        }
        return frequency;
    }
}