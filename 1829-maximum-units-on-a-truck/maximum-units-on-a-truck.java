class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b) -> 
        Integer.compare(b[1] , a[1])
        );
        for(int[] row : boxTypes ){
            pq.add(row);
        }
        int result = 0;

        while(!pq.isEmpty() && truckSize > 0){
            int[] current = pq.poll();
            int numberOfBoxes = current[0];
            int numberOfUnitsPerBox = current[1];
            if( truckSize >= numberOfBoxes){
                result += numberOfUnitsPerBox * numberOfBoxes;
                truckSize -= numberOfBoxes;
            } else {
                result += truckSize  * numberOfUnitsPerBox;
                truckSize = 0;
            }
        }

        return result;
    }
}