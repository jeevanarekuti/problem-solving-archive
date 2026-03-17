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

    void inOrder(TreeNode root,List<Integer>list){
        if(root==null){
            return;
        }
        inOrder(root.left,list);
        list.add(root.val);
        inOrder(root.right,list);
    }

    public TreeNode createTree(List<Integer>list,int low,int high){
        if(low>high){
            return null;
        }
        int mid = high-(high-low)/2;
        int val = list.get(mid);
        TreeNode root = new TreeNode(val);
        root.left = createTree(list,low,mid-1);
        root.right = createTree(list,mid+1,high);
        return root;
    }

    public TreeNode balanceBST(TreeNode root) {
        List<Integer>list = new ArrayList<>();
        inOrder(root,list);
        return createTree(list,0,list.size()-1);
    }
}