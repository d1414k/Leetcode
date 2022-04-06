class Solution {
    int []count = new int[6];
    public int minDominoRotations(int[] tops, int[] bottoms) {
        // find majority element
        Arrays.fill(count, 0);
        for(int i = 0 ; i < tops.length ; i++) {
            count[tops[i]-1]++;
            count[bottoms[i]-1]++;
        }
        int max = count[0], num = 1;
        for(int i = 1 ; i < 6 ; i++) {
            if(count[i] > max) {
                max = count[i];
                num = i+1;
            }
        }
        
        int c1 = 0, c2 = 0; // no of elments not same as num
        for(int i = 0 ; i < tops.length ; i++) {
            if (tops[i] != num)
                    c1++;
            if (bottoms[i] != num)
                    c2++;
        }
        
        // check if we can make one of array as same element
        for(int i = 0 ; i < tops.length ; i++) {
            if (tops[i] != num && bottoms[i] != num)
                return -1;
        }
        return c1 < c2 ? c1 : c2;
    }
}

/*

Approach 2 : 
we can iterate each no form 1 to 6 as all same in one of array.
then find count and return

[2,1,2,4,2,2]
[5,2,6,2,3,2]
[3,5,1,2,3]
[3,6,3,3,4]
[1,2,1,1,1,2,2,2]
[2,1,2,2,2,2,2,2]
[2,2,2,4,4,4]
[4,4,4,2,3,2]
*/
