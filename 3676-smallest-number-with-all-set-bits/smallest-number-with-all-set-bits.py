class Solution:
    def smallestNumber(self, n: int) -> int:
        l, r = 1, 10
        res = -1
        while l <= r:
            m = (l + r) // 2
            x = 2 ** m - 1
            if x >= n:
                r = m - 1
                res = x
            else:
                l = m + 1
        return res