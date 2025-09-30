class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        ArrayList<Integer> list = new ArrayList<>();
        for(int i : nums) list.add(i);
        
        while(list.size() > 1){
            ArrayList<Integer> temp = new ArrayList<>();
           for(int i = 0;i<list.size()-1;i++){
            int sum = list.get(i)+list.get(i+1);
            temp.add(sum%10);
           }
           list = temp;
        }

        return list.get(0);
    }
}