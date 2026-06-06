class Solution {
    public int[] leftRightDifference(int[] nums) {
        int sum = 0;
        int n = nums.length;
        int res[] = new int[n];
        for(int i = 0; i< n; i++){
            sum+=nums[i];
            res[i] = sum;
        }
        for(int i = 0; i < n; i++){
            res[i] = Math.abs(res[i] - sum);
            sum -= nums[i];
        }
        return res;
    }
}