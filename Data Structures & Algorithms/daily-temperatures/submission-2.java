class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int len = temperatures.length;
        int[] res = new int[len];

        for(int i = 0; i < len; i++) {
            // while current temp is WARMER than days waiting in stack
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int idx = stack.pop();
                res[idx] = i - idx; // ✅ current index - waiting index
            }
            stack.push(i);
        }
        return res;
    }
}
