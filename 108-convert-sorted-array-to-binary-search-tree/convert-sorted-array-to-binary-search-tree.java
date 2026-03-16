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

    public TreeNode solve(int[] nums,int low,int high){
        if(low>high){
            return null;
        }
        int mid = high-(high-low)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = solve(nums,low,mid-1);
        root.right = solve(nums,mid+1,high);
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        return solve(nums,low,high);
    }
}