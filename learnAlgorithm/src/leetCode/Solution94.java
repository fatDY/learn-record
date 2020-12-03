package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 通过次数259,756提交次数353,557
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class Solution94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> integers = new ArrayList<>();
        if (root==null){
                return integers;
        }
        dfs(root,integers);
        return integers;
    }

    private void dfs(TreeNode root, List<Integer> integers) {

        if (root.left!=null){
            dfs(root.left, integers);
        }
        integers.add(root.val);
        if (root.right==null){
           return;
        }
        if (root.right!=null){
            dfs(root.right, integers);
        }

    }

    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode(1);
        treeNode.right=new TreeNode(2);
        treeNode.left=new TreeNode(3);
        Solution94 solution94=new Solution94();
        List<Integer> list = solution94.inorderTraversal(treeNode);
        System.out.println(list);
    }


}

//Definition for a binary tree node.
class TreeNode {
    int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
  }
