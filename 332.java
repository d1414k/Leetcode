// https://leetcode.com/problems/reconstruct-itinerary/
class Solution {
    /*
    The input graph is NOT what we call a DAG (Directed Acyclic Graph), since we could find at least a cycle in the graph.
    In addition, the graph could even have some duplicate edges (i.e. we might have multiple flights 
    with the same origin and destination)
    
    We need to find eludian path : visit each edge exactly once
    
    */
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap();
        for(List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            if(graph.get(from) == null)
                graph.put(from, new PriorityQueue());
            graph.get(from).add(to);
        }
        List<String> res = new ArrayList();
        dfs(graph, "JFK", res);
        return res;
    }
    
    void dfs(Map<String, PriorityQueue<String>> m,String from, List<String> res){
        PriorityQueue<String> adj = m.get(from);
        //leaf node
        if(adj == null) {
            res.add(0,from);
            return;
        }
        while(!adj.isEmpty()){
            String to = adj.poll();
            dfs(m,to,res);
        }
        res.add(0,from);
    }
}
/*
[["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
[["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
[["JFK","KUL"],["JFK","NRT"],["NRT","JFK"]]
[["EZE","AXA"],["TIA","ANU"],["ANU","JFK"],["JFK","ANU"],["ANU","EZE"],["TIA","ANU"],["AXA","TIA"],["TIA","JFK"],["ANU","TIA"],["JFK","TIA"]]
*/
