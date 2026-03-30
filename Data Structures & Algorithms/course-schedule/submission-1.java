class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        List<Integer>[] adjList = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjList[i] = new ArrayList<>();
        }

        /*
            course 0 → nobody requires 0 as prereq → indegree[0] = 0
            course 1 → needs course 0              → indegree[1] = 1
            course 2 → needs course 1              → indegree[2] = 1
            course 3 → needs course 1              → indegree[3] = 1

            indegree = [0, 1, 1, 1]
            index:      0  1  2  3
        */
        int[] indegree = new int[numCourses];
        
        // populate the pre requisite map
        for(int[] prereq : prerequisites) {
            int course = prereq[0];
            int pre = prereq[1];

            indegree[course]++;
            adjList[pre].add(course);
            // adjMap.computeIfAbsent(pre, k -> new ArrayList()).add(course);
        }

        Queue<Integer> queue = new LinkedList<>();
        // populate the queue
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int count = 0;
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            count++;
            for(Integer neighbour : adjList[curr]) {
                indegree[neighbour]--;
                if(indegree[neighbour] == 0) queue.offer(neighbour);
            }
        }

        return count == numCourses;
    }
}
