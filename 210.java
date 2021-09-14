// https://leetcode.com/problems/course-schedule-ii/

class Solution {
    // standard topological sort
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> []graph = new ArrayList[numCourses];
        int []indegree = new int[numCourses];
        for(int []a : prerequisites) {
            if(graph[a[1]] == null)
                graph[a[1]] = new ArrayList<Integer>();
            graph[a[1]].add(a[0]);
            indegree[a[0]]++;
        }
        Queue<Integer> queue = new LinkedList();
        for(int i = 0 ; i < numCourses ; i++) {
            if(indegree[i] == 0)
                queue.add(i);
        }
        int []res = new int[numCourses];
        int index = 0;
        while(!queue.isEmpty()) {
            int u = queue.poll();
            res[index++] = u;
            if(graph[u] == null) continue;
            for(int v : graph[u]) {
                indegree[v]--;
                if(indegree[v] == 0)
                    queue.add(v);
            }
        }
        return index < numCourses ? new int[0] : res;
    }
}
/*
2
[[1,0]]
4
[[1,0],[2,0],[3,1],[3,2]]
1
[]
2
[[0,1],[1,0]]
*/
