class Solution {
    public int jump(int[] nums) {
        int coverage = 0;
        int dest = nums.length - 1;
        int jumpCounts = 0, farthestJump = 0;

        if(nums.length == 1) return 0;

        for (int i = 0; i < nums.length; i++) {
            coverage = Math.max(coverage, i + nums[i]);

            if(i == farthestJump) {
                farthestJump = coverage;
                jumpCounts++;

                if(coverage >= dest)
                    return jumpCounts;

            }
        }
        return jumpCounts;   
    }
}
