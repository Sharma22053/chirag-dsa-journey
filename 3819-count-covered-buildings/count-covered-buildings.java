class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        Map<Integer,Pair> xToMinMax = new HashMap<>();
        Map<Integer,Pair> yToMinMax = new HashMap<>();

        for(int[] building : buildings){
            int x = building[0];
            int y = building[1];

            if(!xToMinMax.containsKey(x)){
                xToMinMax.put(x,new Pair(Integer.MAX_VALUE,Integer.MIN_VALUE));
            }
             if(!yToMinMax.containsKey(y)){
                yToMinMax.put(y,new Pair(Integer.MAX_VALUE,Integer.MIN_VALUE));
            }
            Pair xPair = xToMinMax.get(x);
            xPair.min = Math.min(xPair.min,y);
            xPair.max = Math.max(xPair.max,y);

            Pair yPair = yToMinMax.get(y);
            yPair.min = Math.min(yPair.min,x);
            yPair.max = Math.max(yPair.max,x);
            
        }
        int count = 0;
        for(int[] building : buildings){
            int x = building[0];
            int y = building[1];

            Pair xPair = yToMinMax.get(y);
            Pair yPair = xToMinMax.get(x);

            if(xPair.min < x &&  x  < xPair.max && yPair.min < y && y < yPair.max){
                count++;
            }
        }
        return count;
    }
}

class Pair {
    
    int min;
    int max;

    Pair(int min, int max) {
        this.min = min;
        this.max = max;
    }
}