package test.leetCode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/balanced-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Solution110 {
    public int count=0;

    public boolean isBalanced2(TreeNode root) {
        return depth(root) >= 0;
    }

    private int depth(TreeNode root) {
        int left, right;
        return root == null ? 0:
                (left = depth(root.left)) < 0 ? -1:
                        (right = depth(root.right)) < 0 ? -1:
                                Math.abs(left - right) > 1 ? -1:
                                        Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        Solution110 solution110=new Solution110();
        TreeNode treeNode=new TreeNode(1);
        TreeNode treeNode2=new TreeNode(2);
        TreeNode treeNode3=new TreeNode(2);
        TreeNode treeNode4=new TreeNode(3);
        TreeNode treeNode5=new TreeNode(3);
        TreeNode treeNode6=new TreeNode(3);
        TreeNode treeNode7=new TreeNode(3);
        TreeNode treeNode8=new TreeNode(4);
        TreeNode treeNode9=new TreeNode(4);
        TreeNode treeNode10=new TreeNode(4);
        TreeNode treeNode11=new TreeNode(4);
        TreeNode treeNode12=new TreeNode(4);
        TreeNode treeNode13=new TreeNode(4);
        TreeNode treeNode14=new TreeNode(5);
        TreeNode treeNode15=new TreeNode(5);
        treeNode.right=treeNode3;
        treeNode.left=treeNode2;

        treeNode2.left=treeNode4;
        treeNode2.right=treeNode5;
        treeNode3.left=treeNode6;
        treeNode3.right=treeNode7;

        treeNode4.left=treeNode8;
        treeNode4.right=treeNode9;
        treeNode5.left=treeNode10;
        treeNode5.right=treeNode11;
        treeNode6.left=treeNode12;
        treeNode6.right=treeNode13;

        treeNode8.left=treeNode14;
        treeNode8.right=treeNode15;

        boolean balanced2 = solution110.isBalanced2(treeNode);

        System.out.println(balanced2);
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}