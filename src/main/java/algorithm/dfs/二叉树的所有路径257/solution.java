package algorithm.dfs.二叉树的所有路径257;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    List<String> res;
    private void dfs(TreeNode cur, ArrayList<String> path){
        if(cur.left == null && cur.right == null){
            res.add(String.join("->",path));
            return ;
        }
        if(cur.left != null){
            path.add(String.valueOf(cur.left.val));
            dfs(cur.left,path);
            path.remove(path.size()-1);
        }
        if (cur.right != null){
            path.add(String.valueOf(cur.right.val));
            dfs(cur.right,path);
            path.remove(path.size()-1);
        }
    }
    public List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList<>();
        ArrayList<String> path = new ArrayList<>();
        path.add(String.valueOf(root.val));
        dfs(root,path);
        path.remove(path.size()-1);
        return res;
    }
}