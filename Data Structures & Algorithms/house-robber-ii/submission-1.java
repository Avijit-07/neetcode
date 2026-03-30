class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        else if (nums.length == 1) return nums[0];
        return Math.max(
            rob(nums, 0, nums.length - 2),
            rob(nums, 1, nums.length - 1)
        );

    }

    private int rob(int[] nums, int start, int end) {
        if(start == end) return nums[start];

        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start+1]);

        for(int i = start + 2; i <= end; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[end];
    }
}
