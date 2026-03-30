class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1) return false;

        else {
            // build the adjacency list for each node

            List<Integer>[] adjList = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                adjList[i] = new ArrayList<>();
            }

            // populate the adjacency list with connected edges
            for(int[] edge : edges) {
                int parentNode = edge[0]; // 0
                int childNode = edge[1]; // 1

                adjList[parentNode].add(childNode);
                adjList[childNode].add(parentNode);
            }

            // populate the queue with n nodes
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(0);

            boolean[] visited = new boolean[n];
            visited[0] = true;

            int count = 0;

            while(!queue.isEmpty()) { 
                Integer currNode = queue.poll();
                count++;
                for(Integer childNode : adjList[currNode]){
                    if(!visited[childNode]) {
                        queue.offer(childNode); 
                        visited[childNode] = true;
                    }
                }
            }
        
        return count == n;

        }
    }

}
