class Solution {
    public int sumOfN(int n){
        return (n*(n+1))/2;
    }
    public int minimumPushes(String word) {
        //xycdefghij
        //2345678923
        //12
        //8+(2*8)+(3*8)+....
        //len(s) == 26 Q = 2, R = 8 => sumOfN(Q)*8 + R*(Q+1)
        int totalKeys = 8;
        int len = word.length();
        int quotient = len / totalKeys;
        int reminder = len % totalKeys;
        return ( sumOfN(quotient) *  totalKeys ) + ( reminder * (quotient + 1) ); 
    }
}