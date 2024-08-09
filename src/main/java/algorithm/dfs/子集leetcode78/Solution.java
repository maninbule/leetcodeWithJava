package algorithm.dfs.子集leetcode78;
//https://leetcode.cn/problems/subsets/description/


import java.util.*;

class Solution {
    static List<List<Integer>> res = new ArrayList<>();
    private  static void dfs(int i,ArrayList<Integer> choose,int[] nums){
        if(i == nums.length){
            res.add(new ArrayList<>(choose));
            return;
        }
        // 选
        choose.add(nums[i]);
        dfs(i + 1,choose,nums);
        choose.remove(choose.size()-1);
        // 不选
        dfs(i + 1,choose,nums);
    }
    public List<List<Integer>> subsets(int[] nums) {
        res.clear();
        dfs(0,new ArrayList<>(),nums);
        return res;
    }
}