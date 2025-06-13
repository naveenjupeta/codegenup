def longest_zigzag(nums):
    n = len(nums)
    dp = [[1 for _ in range(n)] for _ in range(n)]
    for i in range(n - 1):
        for j in range(i + 1, n):
            if (nums[j] > nums[i] and nums[j] > nums[j - 1]) or (nums[j] < nums[i] and nums[j] < nums[j - 1]):
                dp[i][j] = dp[i][j - 1] + 1
            else:
                dp[i][j] = 1