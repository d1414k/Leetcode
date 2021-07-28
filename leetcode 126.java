//https://leetcode.com/problems/word-ladder-ii/
class Solution {
// using single side bfs    
//     public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//         // use bfs to explore shortest path
//         // as we do not need to generate any path larger than this shortest path
//         // we can save graph generated so for and then use backtracking to generate all paths
//         Set<String> words = new HashSet(wordList);
//         if(!words.contains(endWord)) return new ArrayList();
//         // apply bfs and create graph
//         HashMap<String,Set<String>> graph = new HashMap(); 
//         HashSet<String> visited = new HashSet();
//         Queue<String> queue = new LinkedList();
//         int level = 0; // this represent min level ie, shortest path
//         queue.add(beginWord);
//         visited.add(beginWord); 
//         while(!queue.isEmpty()){
//              // Now remove all elements at last level from wordlist so that we do not have any edge from backward
//             words.removeAll(queue);
//             int size = queue.size();
//             boolean isFound = false;
//             while(size-- > 0){
//                 String root = queue.poll(); //System.out.println(level+" "+root+": "+queue+" "+getAdjacentList(root,words,visited));
//                 if(root.equals(endWord)){ 
//                     isFound = true;
//                     break;
//                 }
//                 // find adjacents
//                 int n = root.length();
//                 for(int i = 0 ; i < n ; i++){
//                     for(char j = 'a' ; j <= 'z' ; j++){
//                         if(j == root.charAt(i)) continue;
//                         String adj = new StringBuilder()
//                             .append(root.substring(0,i))
//                             .append(j)
//                             .append(root.substring(i+1))
//                             .toString();
//                         //String adj = root.substring(0,i) + j + root.substring(i+1);
//                         if(words.contains(adj)){
//                             if(graph.get(root) == null)
//                                 graph.put(root, new HashSet());
//                             graph.get(root).add(adj);
//                             if(!visited.contains(adj))
//                                 queue.add(adj);
//                             visited.add(adj); 
//                         }
                            
//                     }
//                 }
//             }
//             level++;//System.out.println(level+": ");
//             if(isFound) break;
//         } //System.out.println(level+" "+graph);
//         // Now apply backtracking to generate all 'level' length path
//         List<List<String>> res = new ArrayList();
//         generateAllPath(res,new String[level],graph,beginWord,endWord,0,level);
//         return res;
//     }
    // using bfs both end
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // use bfs to explore shortest path
        // as we do not need to generate any path larger than this shortest path
        // we can save graph generated so for and then use backtracking to generate all paths
        Set<String> words = new HashSet(wordList);
        if(!words.contains(endWord)) return new ArrayList();
        // apply bfs and create graph
        HashMap<String,Set<String>> graph = new HashMap(); 
        Queue<String> start = new LinkedList();
        Queue<String> end = new LinkedList();
        Set<String> temp = new HashSet();
        int level = 0; // this represent min level ie, shortest path
        boolean isFound = false, isSwapped = false;
        start.add(beginWord);
        end.add(endWord);
        while(!start.isEmpty()){ //System.out.println("start : "+start+"\n End : "+end);
            temp.clear();
            temp.addAll(end);
             // Now remove all elements at last level from wordlist so that we do not have any edge from backward
            words.removeAll(start);
            int size = start.size();
            while(size-- > 0){
                String root = start.poll(); //System.out.println(level+" "+root+": "+isSwapped);
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
                        if(words.contains(adj)){ //System.out.println(adj);
                            if(!isSwapped){
                                if(graph.get(root) == null)
                                    graph.put(root, new HashSet());
                                graph.get(root).add(adj);
                            }
                            else{
                                if(graph.get(adj) == null)
                                    graph.put(adj, new HashSet());
                                graph.get(adj).add(root);
                            }
                            start.add(adj);                    
                            if(temp.contains(adj)){ 
                                isFound = true;
                                //break;
                            }
                        }
                            
                    }
                }
            }
            level++;//System.out.println(level+": ");
            if(isFound) break;
            // swap so that we can explore smaller one
            if(start.size() > end.size()){
                Queue<String> t = start;
                start = end;
                end = t;
                isSwapped = !isSwapped;
            }
        } //System.out.println(level+" "+graph);
        // Now apply backtracking to generate all 'level' length path
        List<List<String>> res = new ArrayList();
        level++;
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
    void p(String s){
        System.out.println(s);
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
"qa"
"sq"
["si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"]
"qa"
"sq"
["sb","kr","ln","tm","le","ur","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","uh","wm","an","mi","am","be","fm","ta","tb","ni","mr","pa","he","lr","sq"]

1. deque  : 
2. visit :

a b c d 
a e c d

queue :   c
visited : a , b ,e c

a b
a e
b c
e c

a b
a e
e c
b c
c d

wordList
1000 1000 : 10^6
                start
                
               b  c
               
          w   s  a d  e. f 
              
        q   w r  r g r        : q1          
              
     q  s  w r y ui  ii 
              
        s s  w   wd f r g t t t
              
         q w  q r  t r t y u
          w r   end   t y u t t


*/
