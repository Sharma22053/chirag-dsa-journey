class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<numRows;i++){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j =0;j<=i;j++){
                temp.add(findNCR(i,j));
            }
            result.add(temp);
        }
        return result;
    }

    static int findNCR(int row,int column){
        int result =1;
        for(int i =0;i<column;i++){
            result = result *(row-i);
            result = result / (i+1);

        }
        return result;
    }
}