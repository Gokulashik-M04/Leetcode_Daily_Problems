class Solution {

    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        //degree - [0,2,0,0]
        //parent - [2,5,5,5]
        //current- [2,5,6,8]
        //result - [f,f,t,t]
        int degree[] = new int[n];
        int parent[] = new int[n];
        int qlen = queries.length;
        boolean result[] = new boolean[qlen];
        for(int i = 0; i < n; i++) parent[i] = nums[i];
        for(int i = 1; i < n; i++){
            if(nums[i] - nums[i - 1] <= maxDiff){
                parent[i] = parent[i - 1];
                // System.out.println(nums[i - 1]+" "+nums[i]+" "+parent[i - 1]+" "+parent[i]);
            }
        }
        for(int i = 0; i < qlen; i++){
            int u = queries[i][0];
            int v = queries[i][1];
            if(parent[u] == parent[v]) result[i] = true;
        }
        return result;
       
    }
}