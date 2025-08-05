class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        int count = 0;
        for(int i = 0;i<fruits.length;i++){
            for(int j=0;j<fruits.length;j++){
                if(fruits[i] <= baskets[j]){
                    count++;
                    baskets[j] = -1;
                    break;
                }
            }
        }

        return baskets.length - count;
    }
}