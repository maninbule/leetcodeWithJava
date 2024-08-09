package algorithm.dfs.组合总和39;

import java.util.*;

class Solution {
    List<List<Integer>> res;
    private void dfs(int i,int target,ArrayList<Integer> choose,int[] candidates){
        if(target == 0){
            res.add(new ArrayList<>(choose));
            return ;
        }
        if(target < 0 || i >= candidates.length){
            return ;
        }
        // 选
        choose.add(candidates[i]);
        dfs(i,target - candidates[i],choose,candidates);
        choose.remove(choose.size()-1);
        // 不选
        dfs(i + 1,target,choose,candidates);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        dfs(0,target,new ArrayList(),candidates);
        return res;
    }
}