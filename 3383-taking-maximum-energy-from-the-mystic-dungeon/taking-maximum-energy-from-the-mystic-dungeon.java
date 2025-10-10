class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int result = Integer.MIN_VALUE;
        for(int i=n-k;i<n;i++){
            int sum = 0;
            for(int j=i;j >=0;j = j-k){
                sum += energy[j];
                result = Math.max(result,sum);
            }
        }
        return result;
    }
}