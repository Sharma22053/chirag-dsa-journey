class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long c1 = cost1, c2 = cost2, c3 = costBoth;
        if (c3 <= c1 && c3 <= c2)
            return c3 * Math.max(need1, need2);
        if (c3 <= (c1 + c2)) {
            long answer = c3 * Math.min(need1, need2);
            if (need1 > need2)
                answer += Math.min(c1, c3) * (need1 - need2);
            else if (need2 > need1)
                answer += Math.min(c2, c3) * (need2 - need1);
            return answer;
        }
        return (c1 * need1) + (c2 * need2);

    }
}