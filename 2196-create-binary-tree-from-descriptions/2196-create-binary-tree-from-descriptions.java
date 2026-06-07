/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer,TreeNode> numToNode = new HashMap<>();
        HashMap<Integer,TreeNode> numToParent = new HashMap<>();
        for(int i[] : descriptions){
            int parent = i[0];
            int child = i[1];
            int isLeft = i[2];
            TreeNode parentNode = numToNode.getOrDefault(parent,new TreeNode(parent));
            TreeNode childNode = numToNode.getOrDefault(child,new TreeNode(child));
            if(isLeft == 1){
                parentNode.left = childNode;
            }else{
                parentNode.right = childNode;
            }
            numToNode.put(parent,parentNode);
            numToNode.put(child,childNode);
            numToParent.put(child,parentNode);
            TreeNode superParent = numToParent.getOrDefault(parent,null);
            if(superParent==null){
                numToParent.put(parent,parentNode);
            }
        }
        TreeNode res = numToParent.get(descriptions[0][0]);
        while(res!=numToParent.get(res.val)){
            res = numToParent.get(res.val);
        }
        return res;
    }
}