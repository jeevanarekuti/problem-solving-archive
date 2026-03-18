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

    public TreeNode constructTree(int[] nums,int low,int high){
        if(low>high){
            return null;
        }
        int max = 0;
        int index = low;
        for(int i=low;i<=high;i++){
            if(max<nums[i]){
                max = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = constructTree(nums,low,index-1);
        root.right = constructTree(nums,index+1,high);
        return root;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        return constructTree(nums,low,high);
    }
}