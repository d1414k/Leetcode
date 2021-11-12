// https://leetcode.com/problems/rank-teams-by-votes/

class Solution {
    /*
    We can use basic sorting as per question
    */
    public String rankTeams(String[] votes) {
        int n = votes.length, m = votes[0].length();
        int [][]arr = new int[26][m+1]; // [0,0,0,0... charIndex]
        for(int i = 0 ; i < 26; i++) {
            arr[i][m] = i;
        }
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                arr[votes[i].charAt(j)-'A'][j]++;
            }
        }
        Arrays.sort(arr, (int []a, int []b)->{
            for(int j = 0 ; j < m ; j++) {
                if(a[j] != b[j])
                    return b[j]-a[j];
            }
            return a[m]-b[m];
        });
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < m ; i++) {
            sb.append((char)(arr[i][m]+'A'));
        }
        return sb.toString();
    }
}

class Solution {
    /*
    We can use basic sorting as per question
    */
    public String rankTeams(String[] votes) {
        int n = votes.length, m = votes[0].length();
        Map<Character, int[]> hm = new HashMap();
        for(int j = 0 ; j < m ; j++) {
            hm.put(votes[0].charAt(j), new int[m]);
        }
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                int []a = hm.get(votes[i].charAt(j));
                a[j]++;
            }
        }
        List<Character> list = new ArrayList<Character>(hm.keySet());
        Collections.sort(list, (Character ch1, Character ch2)->{
            int []a = hm.get(ch1);
            int []b = hm.get(ch2);
            for(int j = 0 ; j < m ; j++) {
                if(a[j] != b[j])
                    return b[j]-a[j];
            }
            return ch1-ch2;
        });
        StringBuilder sb = new StringBuilder();
        for(char ch : list) {
            sb.append(ch);
        }
        return sb.toString();
    }
}
