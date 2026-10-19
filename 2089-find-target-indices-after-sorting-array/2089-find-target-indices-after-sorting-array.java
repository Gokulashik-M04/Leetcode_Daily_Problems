class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> res = new LinkedList<>();
        int countLessThanTarget = 0;
        int countTarget = 0;
        for(int i : nums){
            if( i < target) countLessThanTarget++;
            else if(i == target) countTarget++;
        }
        while(countTarget !=0 ){
            res.add(countLessThanTarget++);
            countTarget--;
        }
        return res;
    }
}