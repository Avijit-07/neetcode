class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int len = position.length;
        // edge case scenarios
        if(len == 1) return 1;

        // create a 2D array for each car with their position and speed
        int[][] combine = new int[len][2];

        for(int i = 0; i< len; i++) {
            combine[i][0] = position[i];
            combine[i][1] = speed[i];
        }

        Arrays.sort(combine, Comparator.comparingInt(o -> o[0]));

        // initialise the stack
        Stack<Double> stack = new Stack<>();

        for(int i = combine.length - 1; i >= 0; i--) {
            double time = (double) (target - combine[i][0] ) / combine[i][1];
            if(!stack.isEmpty() && time <= stack.peek()) {
                continue;
            } else {
                stack.push(time);
            }
        }
        return stack.size();
    }
}
