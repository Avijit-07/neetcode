class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];

        // list to store all the neighbours for a certain course
        List<Integer>[] adjList = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++) {
            adjList[i] = new ArrayList<>();
        }

        // store the prereqs count per course
        int[] indegree = new int[numCourses];

        for(int[] prereq : prerequisites) {
            int course = prereq[0];
            int pre = prereq[1];

            indegree[course]++;
            adjList[pre].add(course);
        }

        // indegree = [0 , 2, 1, ...]

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int index = 0;

        while(!queue.isEmpty()) {
            int curr = queue.poll();
            result[index] = curr;

            for (Integer neighbor : adjList[curr]) {
                indegree[neighbor]--;
                if(indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
            index++;
        }

        return index == numCourses ? result : new int[]{};

    }
}
