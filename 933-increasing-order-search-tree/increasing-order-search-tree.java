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

    public void inorder(List<Integer>list,TreeNode root){
        if(root==null){
            return;
        }
        inorder(list,root.left);
        list.add(root.val);
        inorder(list,root.right);
    }

    public TreeNode increasingBST(TreeNode root) {
        List<Integer>list = new ArrayList<>();
        inorder(list,root);
        TreeNode roo = new TreeNode(list.get(0));
        TreeNode temp = roo;
        for(int i=1;i<list.size();i++){
            temp.right = new TreeNode(list.get(i));
            temp = temp.right;
        }
        return roo;
    }
}