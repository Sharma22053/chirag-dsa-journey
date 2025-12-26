class Solution {
    public int bestClosingTime(String customers) {
        int current = 0;
        for(char ch : customers.toCharArray()){
            if(ch == 'Y') current++;
        }

        int min = current;
        int earliest = 0;
        int i =0;
        for(char ch : customers.toCharArray()){
            if(ch == 'Y') current--;
            else current++;

            if(current < min){
                earliest = i+1;
                min = current;
            }
            i++;
        }
        return earliest;
    }
}