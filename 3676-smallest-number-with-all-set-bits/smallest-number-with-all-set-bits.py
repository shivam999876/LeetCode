class Solution:
    def smallestNumber(self, n: int) -> int:
        res = 1
        while n > res:
            res = (res << 1) | 1
        return res