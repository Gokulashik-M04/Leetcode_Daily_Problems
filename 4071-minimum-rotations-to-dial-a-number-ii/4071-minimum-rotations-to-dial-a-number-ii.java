class Solution {
    private int MAX_NUM = 10;
    private int calculateRotation(int i,int j){
        int rotation = Math.abs(i - j);
        return Math.min(rotation,MAX_NUM - rotation);
    }
    public int minRotations(int n, String s) {
        int suffixSum = 0;
        int prefixSum = 0;
        int suffixSumArr[] = new int[n];
        int prevNum = 0;
        for(int i = n - 1; i >=0; i--){
            int currNum = Integer.parseInt(""+s.charAt(i));
            int temp = calculateRotation(prevNum, currNum);
            suffixSumArr[i] = temp;
            suffixSum += temp;
            prevNum = currNum;
        }
        int ans = suffixSum;
        prevNum = 0;
        int tempSuffixSum = 0;
        int currCal = 0;
        int lastDigit = Integer.parseInt(""+ s.charAt(n - 1));
        for(int i = 0; i < n - 1; i++){
            int currNum = Integer.parseInt(""+s.charAt(i));
            prefixSum += calculateRotation(prevNum, currNum); 
            int temp = calculateRotation(prevNum, currNum);
            tempSuffixSum += suffixSumArr[i];
            // System.out.println("tempsuffix"+tempSuffixSum);
            int diff = suffixSum - tempSuffixSum - suffixSumArr[n - 1];
            ans = Math.min(ans, prefixSum + diff + calculateRotation(currNum, lastDigit));
            // System.out.println(currNum);
            // System.out.println(prefixSum+" "+diff+" "+calculateRotation(currNum, lastDigit));
            prevNum = currNum;
        }
        return ans;

    }
}