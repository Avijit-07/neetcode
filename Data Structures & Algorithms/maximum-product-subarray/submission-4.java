class Solution {
    public int maxProduct(int[] nums) {
        int result = Integer.MIN_VALUE;

        int maxProd = 1, minProd = 1;
        for(int i = 0; i < nums.length; i++) {
            int tempMax = Math.max(nums[i],
                            Math.max(maxProd * nums[i], minProd * nums[i]));
            int tempMin = Math.min(nums[i], 
                            Math.min(maxProd * nums[i], minProd * nums[i]));
            maxProd = tempMax;
            minProd = tempMin;
            result = Math.max(result, maxProd);
        }

        return result;
    }
}
