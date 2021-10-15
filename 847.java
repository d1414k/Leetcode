// https://leetcode.com/problems/shortest-path-visiting-all-nodes/
class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length, allVisitedMask = (1<<n)-1;
        if(n == 1)
            return 0;
        Queue<int[]> queue = new ArrayDeque();
        boolean [][]visited = new boolean[n][1<<n];
        for(int i = 0 ; i < n ; i++) {
            queue.add(new int[]{i,1<<i});
            visited[i][1<<i] = true;
        }
        int length = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0 ; i < size ; i++){
                int []a = queue.poll(); //System.out.println(root);
                if(a[1] == allVisitedMask)
                    return length;
                for(int v : graph[a[0]]) {
                    int newMask = a[1] | (1<<v);
                    if(!visited[v][newMask]){
                        queue.add(new int[]{v,newMask});
                        visited[v][newMask] = true;
                    }     
                }
            }
            length++;
        }
        return length;
    }
}
// class Solution {
//     public int shortestPathLength(int[][] graph) {
//         Queue<Node> queue = new ArrayDeque();
//         Set<Node> visited = new HashSet();
//         int n = graph.length, allVisitedMask = (1<<n) -1;
//         if(n == 1)
//             return 0;
//         for(int i = 0 ; i < n ; i++) {
//             Node root = new Node(i,1<<i);
//             queue.add(root);
//             visited.add(root);
//         }
//         int length = 0;
//         while(!queue.isEmpty()) {
//             int size = queue.size();
//             for(int i = 0 ; i < size ; i++){
//                 Node root = queue.poll(); //System.out.println(root);
//                 if(root.mask == allVisitedMask)
//                     return length;
//                 for(int v : graph[root.id]) {
//                     Node adj = new Node(v,root.mask | (1<<v));
//                     if(!visited.contains(adj)){
//                         queue.add(adj);
//                         visited.add(adj);
//                     }     
//                 }
//             }
//             length++;
//         }
//         return length;
//     }
// }
// class Node {
//     int id,mask;
//     Node(int id, int mask) {
//         this.id = id;
//         this.mask = mask;
//     }
    
//     public int hashCode(){
//         return 1331 * mask + 7193 * id;
//     }
    
//     public boolean equals(Object o) {
//         Node other = (Node)o;
//         return this.id == other.id && this.mask == other.mask;
//     }
// }
// class Solution {
//     public int shortestPathLength(int[][] graph) {
//         Queue<Node> queue = new ArrayDeque();
//         Set<String> visited = new HashSet();
//         int n = graph.length, allVisitedMask = (1<<n) -1;
//         if(n == 1)
//             return 0;
//         for(int i = 0 ; i < n ; i++) {
//             Node root = new Node(i,1<<i);
//             queue.add(root);
//             visited.add(root.toString());
//         }
//         int length = 0;
//         while(!queue.isEmpty()) {
//             int size = queue.size();
//             for(int i = 0 ; i < size ; i++){
//                 Node root = queue.poll(); //System.out.println(root);
//                 if(root.mask == allVisitedMask)
//                     return length;
//                 for(int v : graph[root.id]) {
//                     Node adj = new Node(v,root.mask | (1<<v));
//                     if(!visited.contains(adj.toString())){
//                         queue.add(adj);
//                         visited.add(adj.toString());
//                     }     
//                 }
//             }
//             length++;
//         }
//         return length;
//     }
// }
// class Node {
//     int id,mask;
//     Node(int id, int mask) {
//         this.id = id;
//         this.mask = mask;
//     }
    
//     public String toString(){
//         return new StringBuilder()
//             .append(id)
//             .append(":")
//             .append(mask)
//             .toString();
//     }
// }
/*
[[]]
[[1,2,3],[0],[0],[0]]
[[1],[0,2,4],[1,3,4],[2],[1,2]]
[[2,5,7],[2,4],[0,1],[5],[5,6,1],[4,10,8,0,3],[4,9],[0],[5],[6],[5]]
[[2,3,5,7],[2,3,7],[0,1],[0,1],[7],[0],[10],[9,10,0,1,4],[9],[7,8],[7,6]]
*/
