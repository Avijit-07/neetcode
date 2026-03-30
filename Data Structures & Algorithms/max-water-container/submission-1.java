class Solution {
    public int maxArea(int[] heights) {
        
        int maxArea = 0;
        int len = heights.length;
        int left = 0, right = len - 1;

        while (left < right) {
            int area = Math.min(heights[left], heights[right]) * (right - left);

            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }

            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}

/*
 [1,7,2,5,4,7,6,3]
    i
          j

    (j - i) * min (i, j)
    - 7 * 1 = 7
    - 6 * 3 = 18
    - 5 * 6 = 30
    - 4 * 7 = 28
    - 3 * 2 = 6 | 3 * 4 = 12
*/