class Solution {
    public int getProd(int n){
        if(n%10==0) return 0;
        if(n < 10) return n;
        return (n/10) * (n%10);
    }
    public int smallestNumber(int n, int t) {
        for(int i = n; i  <= 100; i++){
            int prod = getProd(i);
            if(prod  % t == 0) return i;
        }
        return -1;
    }
}