class Solution {
    public String smallestPalindrome(String s) {
        int hashMap[] = new int[26];
        for(char c : s.toCharArray()){
            hashMap[c-'a']++;
        }
        StringBuilder result = new StringBuilder();
        String oddNumChar = "";
        for(int i = 0; i < 26; i++){
            char curr = (char)(i + 'a');
            if(hashMap[i]%2!=0){
                oddNumChar = ""+curr;
            }
            int repeatCount = hashMap[i]/2;
            result.append((""+curr).repeat(repeatCount));
        }
        return result.toString() + oddNumChar + result.reverse().toString();
    }
}