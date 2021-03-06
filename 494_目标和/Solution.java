/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-05-12 10:37:21
 * @FilePath: \leetcode\494_目标和\Solution.java
 * @LastEditTime: 2020-09-06 10:33:56
 */
class Solution {
    
    int cnt = 0;
    public int findTargetSumWays(int[] nums, int S) {
        dfs(0, nums, S, 0);
        return cnt;
    }
    public void dfs(int k,int[] nums,int S,int sum){
        if(k==nums.length){
            if(sum==S){
                cnt+=1;
            }
            return;
        }
        for(int i=-1;i<2;i+=2){
            int t = i*nums[k];
            sum += t;
            dfs(k+1, nums, S, sum);
            sum -=t;
        }
    }
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        System.out.println(new Solution().findTargetSumWays(nums, 3));
    }
}