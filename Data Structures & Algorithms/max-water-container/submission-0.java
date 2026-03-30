class Solution {
    public int maxArea(int[] heights) {
        
        int maxArea = 0;
        for (int i = 0, j = (heights.length - 1); i != j;) {

            int area = (j - i) * Math.min(heights[i], heights[j]);
            maxArea = Math.max(maxArea, area);

            if (heights[i] < heights[j]) {
                i++;
            }
            else {
                j--;
            }
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