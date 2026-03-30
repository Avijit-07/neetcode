class Solution {
    public int[] twoSum(int[] numbers, int target) {
        /**
            - non-decreasing order
            Input: numbers = [1,2,3,4], target = 3

            Output: [1,2]
            - no sorting
            - index1 < index2
        */

        int[] result = new int[2];

        int left = 0, right = numbers.length - 1;

        while(left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                result[0] = left + 1;
                result[1] = right + 1;
                break;
            }
            else if( sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return result;
    }
}
