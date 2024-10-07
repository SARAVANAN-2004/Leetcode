class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:


        for i in nums:
            x = nums.index(i)
            c = target - i

            if c == i and c in nums[x+1:]:
                y = nums[x+1:].index(c)
                y = y + x + 1
                break
            elif c in nums and x != nums.index(c):
                y = nums.index(c)
                break

        return x,y
