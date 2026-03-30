class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        backtrack(result, new ArrayList<>(), nums, 0);

        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> temp,
                                int[] nums, int index) {
        
        result.add(new ArrayList<>(temp)); // [], [1], [1, 2]

        for (int i = index; i < nums.length ; i++) {
            if(i > index && nums[i] == nums[i-1]) continue;
            temp.add(nums[i]); // [1, 2]

            backtrack(result, temp, nums, i + 1);

            temp.remove(temp.size() - 1);
        }

    }
}
