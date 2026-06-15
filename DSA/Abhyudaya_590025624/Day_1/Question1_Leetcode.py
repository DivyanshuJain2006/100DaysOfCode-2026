class Solution(object):
    def missingNumber(self, nums):
        num=0
        for i in range(len(nums)+1):
            if i in nums:
                continue
            else:
                num=i
        return num       
nums = [3, 0, 1]
obj = Solution()
print(obj.missingNumber(nums))