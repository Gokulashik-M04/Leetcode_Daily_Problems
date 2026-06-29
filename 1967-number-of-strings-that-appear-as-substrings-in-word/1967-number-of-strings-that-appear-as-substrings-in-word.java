class Solution {
    public int numOfStrings(String[] patterns, String word) {
        Set<String> set = new HashSet<>();
        int n = word.length();
        int count = 0;
        for(int i = 0; i < n; i++){
            StringBuilder temp = new StringBuilder();
            for(int j = i; j < n; j++){
                temp.append(word.charAt(j));
                set.add(temp.toString());
            }
        }
        for(String s : patterns)
            if(set.contains(s))
                count++;
        return count;
    }
}