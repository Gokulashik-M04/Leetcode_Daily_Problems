class Solution {
    public int findOptimal(int firstTime[],int firstDuration[],int secondTime[],int secondDuration[]){
        int n = firstTime.length;
        int m = secondTime.length;
        int firstMin = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            firstMin = Math.min(firstMin,firstTime[i] + firstDuration[i]);
        }
        int secondMin = Integer.MAX_VALUE;
        for(int j = 0; j < m; j++){
            int temp = 0;
            if(secondTime[j] > firstMin){
                temp+= secondTime[j] - firstMin;
            }
            temp += secondDuration[j];
            secondMin = Math.min(secondMin,firstMin + temp);
        }
        return secondMin;
    }
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        return Math.min(
            findOptimal(landStartTime,landDuration,waterStartTime,waterDuration),
            findOptimal(waterStartTime,waterDuration,landStartTime,landDuration)
        );
    }
}