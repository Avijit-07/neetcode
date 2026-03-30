class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        
        int sum = 0;

        backtrack(result, new ArrayList<>(), nums, 0, sum, target);
        return result;
    }

    private void backtrack(List<List<Integer>> result, 
                            List<Integer> temp,
                            int[] nums, int start, 
                            int sum, int target) {
        
        if(sum > target) return;

        if(sum == target) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]); // 2, 2, 2, 2, 2

            backtrack(result, temp, nums, i, sum + nums[i], target);

            temp.remove(temp.size() - 1);
        }

    }
}
