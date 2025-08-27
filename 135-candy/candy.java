class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 1;
        right[n-1] = 1;
        for(int i=1;i<n;i++){
             if(ratings[i] > ratings[i-1]){
                left[i] = left[i-1] + 1;
                
            } else {
                left[i] = 1;
            }
        }

        for(int j=n-2;j>=0;j--){
             if(ratings[j] > ratings[j+1]){
                right[j] = right[j+1] + 1;
                
            } else{
                right[j] = 1;
            }
        }
        int result = 0;
        for(int k=0;k<n;k++){
            result += Math.max(left[k],right[k]);
        }
        return result;
    }
}