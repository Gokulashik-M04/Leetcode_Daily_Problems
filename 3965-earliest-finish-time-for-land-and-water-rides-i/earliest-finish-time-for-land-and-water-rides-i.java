class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int minTime = Integer.MAX_VALUE;
        int n = landStartTime.length;
        int m = waterStartTime.length;
        for(int i = 0; i < n; i++){
            int timeTaken = landStartTime[i] + landDuration[i];
            for(int  j = 0; j < m; j++){
                int temp = 0;
                if(!(waterStartTime[j] <= timeTaken)){
                    temp += (waterStartTime[j] - timeTaken);
                }
                temp += waterDuration[j];
                minTime = Math.min(minTime,timeTaken + temp);
            }
        }
        for(int i = 0; i < m; i++){
            int timeTaken = waterStartTime[i] + waterDuration[i];
            for(int  j = 0; j < n; j++){
                int temp = 0;
                if(!(landStartTime[j] <= timeTaken)){
                    temp += (landStartTime[j] - timeTaken);
                }
                temp += landDuration[j];
                minTime = Math.min(minTime,timeTaken + temp);
            }
        }
        return minTime;
    }
}