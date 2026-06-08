class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int res[] = new int[n];
        int index = 0;
        int equalCount = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] < pivot) res[index++] = nums[i];
            if(nums[i] == pivot) equalCount++;
        }
        while(equalCount!=0){
            res[index++] = pivot;
            equalCount--;
        }
        for(int i = 0; i < n; i++){
            if(nums[i] > pivot) res[index++] = nums[i];
        }
        return res;
    }
}