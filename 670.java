// https://leetcode.com/problems/maximum-swap/

class Solution {
    public int maximumSwap(int num) {
        // find length of num
        int t = num, n = 0;
        while(t > 0) {
            t /= 10;
            n++;
        }
        // convert integer to digit array
        int []a = new int[n];
        for(int i = n-1; i >= 0; i--) {
            a[i] = num%10;
            num /= 10;
        }
        // try to replace
        for(int i = 0 ; i < n-1 ; i++) {
            int maxIndex = i+1;
            for(int j = i+1 ; j < n ; j++) {
                if(a[maxIndex] <= a[j])
                    maxIndex = j;
            }
            if(a[i] < a[maxIndex]) {
                int temp = a[i];
                a[i] = a[maxIndex];
                a[maxIndex] = temp;
                break;
            }
        }
        // convert back to integer
        for(int i = 0 ; i < n ; i++) {
            num = 10*num + a[i];
        }
        return num;
    }
}
/*
1993
*/
