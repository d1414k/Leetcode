// https://leetcode.com/problems/evaluate-division/

class Solution {
    /*
    Create a directed grah with given pairs
    backtrack graph for each query
    */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String,List<Node>> graph = new HashMap();
        int n = equations.size();
        for(int i = 0 ; i < n ; i++) {
            List<String> pair = equations.get(i);
            String src = pair.get(0);
            String des = pair.get(1);
            if(graph.get(src) == null)
                graph.put(src,new ArrayList());
            if(graph.get(des) == null)
                graph.put(des,new ArrayList());
            graph.get(src).add(new Node(des,values[i]));
            graph.get(des).add(new Node(src,1/values[i]));
        }
        int m = queries.size();
        double []res = new double[m]; 
        for(int i = 0 ; i < m ; i++) { 
            List<String> pair = queries.get(i);
            String src = pair.get(0);
            String des = pair.get(1);
            res[i] = backtrack(graph,src,des,new HashSet(),1);
        }
        return res;
    }
    double backtrack(Map<String,List<Node>> graph,String src, String des,HashSet<String> visited, double cur){
        double ans = -1.0;
        if(graph.get(src) == null) return ans;
        if(src.equals(des))
            return cur;
        visited.add(src);
        for(Node adj : graph.get(src)){
            if(!visited.contains(adj.name)){
                ans = backtrack(graph, adj.name, des, visited,cur*(adj.val));
                if(ans != -1.0)
                    return ans;
            }
        }
        visited.remove(src);
        return ans;
    }
    // void p(String s){
    //     System.out.println(s);
    // }
}

class Node {
    String name;
    double val;
    Node(String name, double val) {
        this.name = name;
        this.val = val;
    }
}

/*
[["a","b"],["b","c"]]
[2.0,3.0]
[["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
[["a","b"],["b","c"],["bc","cd"]]
[1.5,2.5,5.0]
[["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
[["a","b"]]
[0.5]
[["a","b"],["b","a"],["a","c"],["x","y"]]
*/
