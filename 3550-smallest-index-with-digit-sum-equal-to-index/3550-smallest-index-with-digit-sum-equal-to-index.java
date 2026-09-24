class Solution {
    public int getDigitSum(int i){
        int sum = 0; 
        while(i!=0){
            sum += (i%10);
            i/=10;
        }
        return sum;
    }
    public int smallestIndex(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            if(i == getDigitSum(nums[i])) return i;
        }
        return -1;
    }
}