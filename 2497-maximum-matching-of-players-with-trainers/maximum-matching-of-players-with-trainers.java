class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int ways = 0;
        int i = 0;
        int j = 0;
        while(i< players.length && j < trainers.length){
            if(players[i] <= trainers[j]){
                ways++;
                i++;
                j++;
            } else {
                j++;
            }
        }
        return ways;
    }
}