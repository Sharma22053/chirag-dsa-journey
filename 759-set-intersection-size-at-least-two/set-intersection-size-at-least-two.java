class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1],b[1]));

        int a = intervals[0][1] -1;
        int b = intervals[0][1];
        int count = 2;

        for(int i=1;i<intervals.length;i++){
            int left = intervals[i][0] , right = intervals[i][1];
            int inside = (a >= left ? 1 : 0) + (b >= left ? 1: 0);
            if(inside == 2) continue;
            if(inside == 1){
                count++;
                if(right == b){
                    a = right -1;
                }else{
                    a = b;
                    b = right;
                }
            } else {
                count += 2;
                a = right -1;
                b = right;
            }
        }
        return count;
    }
}