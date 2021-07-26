//https://leetcode.com/problems/word-ladder-ii/
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // use bfs to explore shortest path
        // as we do not need to generate any path larger than this shortest path
        // we can save graph generated so for and then use backtracking to generate all paths
        Set<String> words = new HashSet(wordList);
        if(!words.contains(endWord)) return new ArrayList();
        // apply bfs and create graph
        // we will mark visited once will remove from queue
        HashMap<String,Set<String>> graph = new HashMap(); 
        HashSet<String> visited = new HashSet();
        Queue<String> queue = new LinkedList();
        int level = 0; // this represent min level ie, shortest path
        queue.add(beginWord);
        visited.add(beginWord); 
        while(!queue.isEmpty()){
             // Now remove all elements at last level from wordlist so that we do not have any edge from backward
            words.removeAll(queue);
            int size = queue.size();
            boolean isFound = false;
            while(size-- > 0){
                String root = queue.poll(); //System.out.println(level+" "+root+": "+queue+" "+getAdjacentList(root,words,visited));
                if(root.equals(endWord)){ 
                    isFound = true;
                    break;
                }
                // find adjacents
                int n = root.length();
                for(int i = 0 ; i < n ; i++){
                    for(char j = 'a' ; j <= 'z' ; j++){
                        if(j == root.charAt(i)) continue;
                        String adj = new StringBuilder()
                            .append(root.substring(0,i))
                            .append(j)
                            .append(root.substring(i+1))
                            .toString();
                        //String adj = root.substring(0,i) + j + root.substring(i+1);
                        if(words.contains(adj)){
                            if(graph.get(root) == null)
                                graph.put(root, new HashSet());
                            graph.get(root).add(adj);
                            if(!visited.contains(adj))
                                queue.add(adj);
                            visited.add(adj); 
                        }
                            
                    }
                }
            }
            level++;//System.out.println(level+": ");
            if(isFound) break;
        } //System.out.println(level+" "+graph);
        // Now apply backtracking to generate all 'level' length path
        List<List<String>> res = new ArrayList();
        generateAllPath(res,new String[level],graph,beginWord,endWord,0,level);
        return res;
    }
    // applying backtracking in DAG
    void generateAllPath(List<List<String>> res,String []path, HashMap<String,Set<String>> graph,  String root, String endWord, int curLevel,int maxLevel){ 
        if(curLevel >= maxLevel) return;
        path[curLevel] = root;
        if(root.equals(endWord)){//System.out.println(curLevel+" "+root+" "+endWord);
            res.add(new ArrayList(Arrays.asList(path)));
            return;
        }
        if(graph.get(root) == null)  
            return;
        for(String adj : graph.get(root)){
            generateAllPath(res,path,graph,adj,endWord,curLevel+1,maxLevel);
        }
    }
}

/*
"a"
"c"
["a","b","c"]
"hot"
"dog"
["hot","cog","dog","tot","hog","hop","pot","dot"]
"hit"
"cog"
["hot","dot","dog","lot","log","cog"]
"hit"
"cog"
["hot","dot","dog","lot","log"]
"lost"
"miss"
["most","mist","miss","lost","fist","fish"]

*/
