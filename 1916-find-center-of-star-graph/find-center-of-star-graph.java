class Solution {
    public int findCenter(int[][] edges) {
        Map<Integer,Integer> hmap = new HashMap<>();
        for(int[] edge : edges){
            hmap.put(edge[0], hmap.getOrDefault(edge[0], 0) + 1);
            hmap.put(edge[1], hmap.getOrDefault(edge[1], 0) + 1);
        }

        for(int i : hmap.keySet()){
            if(hmap.get(i) == edges.length){
                return i;
            }
        }
        return -1;
    }
}