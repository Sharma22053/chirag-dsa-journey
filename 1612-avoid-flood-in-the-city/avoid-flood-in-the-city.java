class Solution {
    public int[] avoidFlood(int[] rains) {
        Map<Integer,Integer> hmap = new HashMap<>();
        TreeSet<Integer> setZeros = new TreeSet<>();
        int[] result = new int[rains.length];
        Arrays.fill(result,1);
        for(int i=0;i<rains.length;i++){
            if(rains[i] == 0){
                setZeros.add(i);
            } else{
                result[i] = -1;
                if(hmap.containsKey(rains[i])){
                    Integer it = setZeros.ceiling(hmap.get(rains[i]));
                    if(it == null) return new int[0];
                    result[it] = rains[i];
                    setZeros.remove(it);
                }
                hmap.put(rains[i],i);
            }
            

        }
        return result;
    }
}