class Solution {
    public int minimumCost(int[] cost) {
        int minCost = 0;
        int n = cost.length;
        Arrays.sort(cost);
        for(int i = n - 1; i >= 0; i-=3){
            minCost+= cost[i];
            if(i - 1 >= 0) minCost += cost[ i - 1 ];
        }
        return minCost;
    }
}