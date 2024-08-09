package algorithm.dfs.全排列leetcode46;

import java.util.*;

// https://leetcode.cn/problems/permutations/description/
class Solution {
    List<List<Integer>> res;
    private void dfs(boolean[] vis,ArrayList<Integer> choose,int[] nums){
        if(choose.size() == nums.length){
            res.add(new ArrayList(choose));
            return ;
        }
        // 选一个之前dfs层没有选择过的数
        for(int j = 0;j<nums.length;j++){
            if(vis[j]) continue;
            choose.add(nums[j]);
            vis[j] = true;
            dfs(vis,choose,nums);
            vis[j] = false;
            choose.remove(choose.size()-1);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        res =  new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        dfs(vis,new ArrayList<>(),nums);
        return res;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        Integer[] integerArray = Arrays.stream(array).boxed().toArray(Integer[]::new);
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(integerArray));
    }
}

//
//class Solution {
//    List<List<Integer>> res;
//    private void swap(int[] nums,int i,int j){
//        int tmp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = tmp;
//    }
//    private void dfs(int i,int[] nums){
//        if(i == nums.length){
//            List<Integer> cur = new ArrayList();
//            for(int j = 0;j<nums.length;j++) cur.add(nums[j]);
//            res.add(cur);
//            return ;
//        }
//        // 决定index = i应该放哪一个数
//        for(int j = i;j<nums.length;j++){
//            swap(nums,i,j);
//            dfs(i + 1,nums);
//            swap(nums,i,j);
//        }
//    }
//    public List<List<Integer>> permute(int[] nums) {
//        res = new ArrayList<>();
//        dfs(0,nums);
//        return res;
//    }
//}