class Solution {
    public long sumAndMultiply(int n) {
        int sum = 0;
        int x = 0;
        for(char i : (""+n).toCharArray()){
            int val = i - '0';
            if(val>0){
                x = ( x*10 ) + val;
            }
            sum += val;
        }
        return (long)sum * x;
    }
}