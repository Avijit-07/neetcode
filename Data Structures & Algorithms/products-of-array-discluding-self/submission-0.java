class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        int[] leftProduct = new int[len];
        int[] rightProduct = new int[len];

        for (int i = 0; i < len; i++) {
            if(i == 0) {
                leftProduct[i] = 1;
            } else {
                leftProduct[i] = leftProduct[i - 1] * nums[i - 1];
            }
        }

        for (int i = len - 1; i >= 0; i--) {
            if(i == len - 1) {
                rightProduct[i] = 1;
            } else {
                rightProduct[i] = rightProduct[i + 1] * nums[i + 1];
            }
        }

        for(int i = 0; i < len; i++) {
            result[i] = leftProduct[i] * rightProduct[i];
        }

        return result;
    }
}  
