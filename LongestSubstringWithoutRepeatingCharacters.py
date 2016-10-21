class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        if len(s) == 0:
            return 0
        
        i, j, ret = 0, 0, -sys.maxint-1
        letter_map = {}
        
        while j < len(s):
            if s[j] in letter_map:
                m = letter_map[s[j]] + 1
                
                # "abba"
                for index in xrange(i, m):
                    del letter_map[s[index]]
                
                letter_map[s[j]] = j
                i = m 
            
            else:
                letter_map[s[j]] = j
            ret = max(ret, j-i+1)
            j = j + 1
        
        return ret
        
# corner case: "aaaaa", "abba"


def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        curr, res, d = 0, 0, {}
        for i, ch in enumerate(s):
            if ch in d:
                curr = max(curr, d[ch] + 1)
            d[ch] = i
            res = max(res, i - curr + 1)
        return res
