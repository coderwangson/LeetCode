"""
Created on 2019/3/26 22:03
@File:组合总和 II.py
@author: coderwangson
"""
"#codeing=utf-8"
import copy
class Solution(object):
    def dfs(self,start,candidates,target,out,res):
        if target<0:
            return
        if target ==0:
            res.append(copy.copy(out))
        for i in range(start,len(candidates)):
            # candidates[i-1]==candidates[i] 避免 1 1 2 3 4 比如有了 1 2 4 避免第二个 1 2 4
            if i!=start and candidates[i-1]==candidates[i]:
                continue
            out.append(candidates[i])
            # i+1 避免对同一个位置多次取
            self.dfs(i+1,candidates,target-candidates[i],out,res)
            out.remove(candidates[i])
    def combinationSum2(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """

        out = []
        res = []
        candidates = sorted(candidates)
        self.dfs(0,candidates,target,out,res)
        return res

print(Solution().combinationSum2([10,1,2,7,6,1,5],8))

