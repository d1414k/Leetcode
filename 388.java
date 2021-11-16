// https://leetcode.com/problems/longest-absolute-file-path/

class Solution {
    /*
    As per diagram and input we can see that when we see \t column will increase
    so we can save length string at each column
    when we see a file, we will comput path length
    */
    // static int []columnLength = new int[10001]; // length of string at column i
    // public int lengthLongestPath(String input) {
    //     int n = input.length(), maxLength = 0;
    //     String []line = input.split("\n");
    //     for(int i = 0 ; i < line.length ; i++) {
    //         int index = line[i].lastIndexOf("\t") + 1;
    //         int wordLength = line[i].length() - index;
    //         columnLength[index] = wordLength;
    //         if(line[i].contains(".")){
    //             int pathLen = 0;
    //             for(int j = 0 ; j <= index ; j++) {
    //                 pathLen += columnLength[j] + 1; // 1 for /
    //             } 
    //             maxLength = Math.max(pathLen - 1, maxLength);
    //         }
    //     }
    //     return maxLength;
    // }
    
    static int []cummulativePathLength = new int[10001]; // length of string at column i
    public int lengthLongestPath(String input) {
        int n = input.length(), maxLength = 0;
        String []line = input.split("\n");
        for(int i = 0 ; i < line.length ; i++) {
            int index = line[i].lastIndexOf("\t") + 1;
            int wordLength = line[i].length() - index + 1;// 1 for /
            cummulativePathLength[index + 1] = wordLength + cummulativePathLength[index];
            if(line[i].contains(".")){
                maxLength = Math.max(cummulativePathLength[index + 1] - 1, maxLength);
            }
        }
        return maxLength;
    }
    
    
}
