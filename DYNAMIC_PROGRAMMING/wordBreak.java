

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
https://leetcode.com/problems/word-break/
Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.



Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
 */
public class wordBreak {
    public boolean wordBreak_tab(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        int max_len = 0;
        for (String word : wordDict) {
            max_len = Math.max(max_len, word.length());
        }

        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j >= Math.max(i - max_len - 1, 0); j--) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
    private boolean helper(String s,Set<String> set,HashMap<String,Boolean> map){
        if(map.containsKey(s))return map.get(s);
        if(set.contains(s)) {
            map.put(s,true);
            return true;
        }
        for(int i=1;i<s.length();i++){
            String left = s.substring(0,i);
            String right=s.substring(i);
            if(set.contains(left) && helper(right,set,map)){
                map.put(s,true);
                return true;
            }
        }
        map.put(s,false);
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict){
        Set<String> set= new HashSet<>(wordDict);
        HashMap<String,Boolean> map = new HashMap<>();
        return helper(s,set,map);
    }
}
