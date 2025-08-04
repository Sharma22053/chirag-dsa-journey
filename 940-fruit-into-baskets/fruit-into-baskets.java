class Solution {
    public int totalFruit(int[] fruits) {
        int i =0 , j = 0;
        int count = 0;
        Map<Integer,Integer> hmap = new HashMap<>();
        while(j<fruits.length){
            hmap.put(fruits[j],hmap.getOrDefault(fruits[j],0)+1);
            if(hmap.size() <=2){
                count = Math.max(count,(j-i+1));
            } else {
                hmap.put(fruits[i],hmap.get(fruits[i]) - 1);
                if(hmap.get(fruits[i]) == 0) {
                    hmap.remove(fruits[i]);
                    
                }
                i++;
            }
            j++;
        }

        return count;

    }
}