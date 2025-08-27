class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        Job[] jobs = new Job[profit.length];

        for(int i=0;i<profit.length;i++){
            jobs[i] = new Job(endTime[i],startTime[i],profit[i]);
        }

        Arrays.sort(jobs,Comparator.comparingInt(job -> job.endTime));
        int[] dp = new int[profit.length+1];

        for(int i=0;i<profit.length;i++){
            int endTimeValue = jobs[i].endTime;
            int startTimeValue = jobs[i].startTime;
            int profitValue = jobs[i].profit;

            int latest = upperBound(jobs,i,startTimeValue);
            dp[i+1] = Math.max(dp[i],dp[latest] + profitValue);
        }

        return dp[profit.length];

    }

    private int upperBound(Job[] jobs,int endIndex, int targetTime){
        int low = 0;
        int high = endIndex;

        while(low < high){
            int mid = (low + high)/2;
            if(jobs[mid].endTime <= targetTime){
                low = mid+1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    private static class Job {
        int endTime;
        int startTime;
        int profit;

        public Job(int endTime,int startTime,int profit) {
            this.endTime = endTime;
            this.startTime = startTime;
            this.profit = profit;
        }
    }
}