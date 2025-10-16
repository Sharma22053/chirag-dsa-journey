class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int[] frequency = new int[value];
        for(int i : nums){
            int mod = (((i % value)+value)%value);
            frequency[mod]++;
        }

        int mex =0;
        while(true){
            int toFound = mex % value;
            if(frequency[toFound] > 0){
                frequency[toFound]--;
                mex++;
            } else {
                break;
            }
        }
        return mex;
    }
}