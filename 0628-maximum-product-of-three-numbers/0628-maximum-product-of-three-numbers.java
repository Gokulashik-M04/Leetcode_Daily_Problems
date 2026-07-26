class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int last = nums[n-1];
        int secondLast = nums[n-2];
        int thirdLast = nums[n-3];
        int first = nums[0];
        int second = nums[1];
        return Math.max((first*second*last),(last*secondLast*thirdLast));
    }
}