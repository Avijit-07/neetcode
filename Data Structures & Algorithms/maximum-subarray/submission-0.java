class Solution {
    public int maxSubArray(int[] nums) {
        int totalSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) { 
            totalSum = totalSum + nums[i];
            maxSum = Math.max(maxSum, totalSum);

            if(totalSum < 0) totalSum = 0;
        }
        return maxSum;
    }
}
