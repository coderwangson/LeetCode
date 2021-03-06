/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-04-22 10:27:20
 * @FilePath: \leetcode\557_反转字符串中的单词 III\Solution.java
 * @LastEditTime: 2020-08-30 10:21:22
 */
class Solution {
    
    public String reverseWords(String s) {
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while(i<s.length()){
            StringBuilder t = new StringBuilder(); 
            while(i<s.length() && s.charAt(i)!=' '){
                t.append(s.charAt(i));
                i++;
            }
            if(t.length()>0){
                sb.append(t.reverse());
            }
            while(i<s.length() && s.charAt(i)==' '){
                i++;
            }
            if(i<s.length()){
                sb.append(' ');
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String s = "Let's     take LeetCode contest  ";
        System.out.println(new Solution().reverseWords(s)+"||");
    }
}