class Solution {
    public int trap(int[] height) {
        
        int totalWater = 0;
        int len = height.length;
        // creating left max height array in each position
        int[] max_left = new int[len];
        max_left[0] = 0;
        for (int i = 1; i < len; i++) {
            max_left[i] = Math.max(height[i - 1], max_left[i-1]);
        }

        int[] max_right = new int[len];
        max_right[len - 1] = 0;
        for (int i = len - 2; i >= 0; i--) {
            max_right[i] = Math.max(height[i + 1], max_right[i + 1]);
        }

        for (int i = 0; i < len; i++) {
            totalWater += Math.max(0, Math.min(max_left[i], max_right[i]) - height[i]);
        }

        return totalWater;
    }
}
