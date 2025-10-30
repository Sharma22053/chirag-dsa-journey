class Solution {
    public int minNumberOperations(int[] target) {
        int count = target[0];
        for(int i=0;i<target.length-1;i++){
            if(target[i+1] > target[i]){
                count += target[i+1] - target[i];
            }
        }
        return count;
    }
}