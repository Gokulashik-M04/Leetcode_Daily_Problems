class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)-> a[0] - b[0]);
        int prev[] = intervals[0];
        int count = 0;
        int n = intervals.length;
        for(int i = 1; i < n; i++){
            if(prev[0] <= intervals[i][0] && intervals[i][1] <= prev[1]){
                count++;
                continue;
            }else if(prev[0] >= intervals[i][0] && intervals[i][1] >= prev[1]){
                count++;
            }
            prev = intervals[i];
        }
        return n - count;
    }
}