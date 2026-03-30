class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        boolean[] visited = new boolean[nums.length];

        backtrack(result, new ArrayList<>(), nums, visited);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> temp, int[] nums, boolean[] visited) {

        if(temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0; i < nums.length; i++) { // 1
            if(visited[i]) continue;
            visited[i] = true;
            temp.add(nums[i]); // 1, 2
            
            backtrack(result, temp, nums, visited);

            temp.remove(temp.size() - 1);
            visited[i] = false;
        }
    }
}
