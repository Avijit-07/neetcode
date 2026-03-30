class Solution {
    public boolean canJump(int[] nums) {
        int coverage = 0;
        int dest = nums.length - 1;
        
        if(nums.length == 1) return true;

        for (int i = 0; i < nums.length; i++) {

            if(i > coverage) return false;
            
            coverage = Math.max(coverage, i + nums[i]);

            if(i == coverage) {
                if(coverage >= dest)
                    return true;
            }

        }
        return true;
    }
}
