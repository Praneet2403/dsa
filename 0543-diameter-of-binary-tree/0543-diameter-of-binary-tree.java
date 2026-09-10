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
    int dia =0;
    public int diameterOfBinaryTree(TreeNode root) {
        check(root);
        return dia;
    }
    public int check(TreeNode root) {
        if(root == null ) return 0;
        int x = check(root.left);
        int y = check(root.right);

        dia = Math.max(dia , x+y);
        return 1+ Math.max(x , y);


    }
}