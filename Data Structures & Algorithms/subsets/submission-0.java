class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), 0, nums);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempSet, int start, int[] nums) {
        result.add(new ArrayList<>(tempSet)); // [], [1], [1, 2], [1, 2, 3]

        for(int i = start; i < nums.length; i++){
            tempSet.add(nums[i]); // [1, 2],

            backtrack(result, tempSet, i+1, nums);

            tempSet.remove(tempSet.size() - 1); 
        }
    }
}
