class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if(nums.length % k != 0) return false;
        HashMap<Integer,Integer> hmap = new HashMap<>();
        for(int i : nums){
            hmap.put(i,hmap.getOrDefault(i,0)+1);
        }
        Arrays.sort(nums);
        for(int num : nums){
            if(hmap.get(num) > 0){
                for(int i= num+1 ; i< num+k;i++){
                    if(hmap.getOrDefault(i,0) == 0){
                        return false;
                    }
                    hmap.put(i,hmap.get(i)-1);
                }
                hmap.put(num,hmap.get(num) -1);
            }
        }
        return true;

        // while(!hmap.isEmpty()){
        //     int first = Collections.min(hmap.keySet());
        //     for(int i = first;i<first+k;i++){
        //         if(!hmap.containsKey(i)){
        //             return false;
        //         }
        //         hmap.put(i,hmap.get(i) - 1);
        //         if(hmap.get(i) == 0){
        //             hmap.remove(i);
        //         }
        //     }
        // }

        // return true;
        
    }
}