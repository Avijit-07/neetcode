class Solution {
    public boolean canJump(int[] nums) {
        int coverage = 0, farJump = 0;
        int dest = nums.length - 1;
        
        if(nums.length == 1) return true;

        for (int i = 0; i < nums.length; i++) {
            
            coverage = Math.max(coverage, i + nums[i]);

            if(i == farJump) {
                farJump = coverage;
                if(coverage >= dest)
                    return true;
            }

            if(i > farJump) return false;
        }
        return true;
    }
}
