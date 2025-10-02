class Solution {
    public int maxBottlesDrunk(int totalBottles, int exchange) {
        int ans = totalBottles;      
        int empty = totalBottles;
        while(empty >= exchange){         
                ans++;
                empty -= exchange - 1;
                exchange++;
            
        }
        return ans;
    }
}