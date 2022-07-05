// #1
class Solution {
    public static int solve(int N, int a, int[] x) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(2); // max 2 elements
        minHeap.add(x[0]);
        minHeap.add(x[1]);
        // min 2 elements
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(2, Collections.reverseOrder());
        maxHeap.add(x[0]);
        maxHeap.add(x[1]);
        for(int i = 2 ; i< N ; i++) {
            if(x[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(x[i]);
            }
            if(x[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.add(x[i]);
            }
        }
        int []temp = new int[4];
        temp[2] = minHeap.poll();
        temp[3] = minHeap.poll();
        temp[1] = maxHeap.poll();
        temp[0] = maxHeap.poll();
    
        return Math.max(Math.abs(a-temp[0]) + Math.abs(a- temp[1]),
            Math.max(Math.abs(a-temp[2]) + Math.abs(a-temp[3]), 
            Math.abs(a-temp[0]) + Math.abs(a-temp[3])));
    }
}

// #2
class Solution 
{
    long colosseum(int N,int A[]) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(N);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(N, Collections.reverseOrder());
        long sum = 0, topNSum[] = new long[N+1], bottomNSum[] = new long[N+1];
        for(int i = 0 ; i < N ; i++) {
            minHeap.add(A[i]);
            sum += A[i]; 
        }
        topNSum[0] = sum;
        for(int i = N ; i < 2*N ; i++) {
            if(A[i] > minHeap.peek()) {
                sum -= minHeap.poll();
                sum += A[i];
                minHeap.add(A[i]);
            }
            topNSum[i-N + 1] = sum;
        }
        sum = 0;
        for(int i = 3*N-1 ; i >= 2*N ; i--) {
            maxHeap.add(A[i]);
            sum += A[i]; 
        }
        bottomNSum[N] = sum;
        for(int i = 2*N -1 ; i >= N ; i--) {
            if(A[i] < maxHeap.peek()) {
                sum -= maxHeap.poll();
                sum += A[i];
                maxHeap.add(A[i]);
            }
            bottomNSum[i - N] = sum;
        }
        // System.out.println(""+Arrays.toString(topNSum));
        // System.out.println(""+Arrays.toString(bottomNSum));
        long maxDiff = Integer.MIN_VALUE;
        for(int i = 0 ; i <= N; i++) {
           maxDiff = Math.max(maxDiff, topNSum[i] - bottomNSum[i]); 
        }
        return maxDiff;
    }
}

// #3
class Solution 
{
    long colosseum(int N,int A[]) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(N);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(N, Collections.reverseOrder());
        long sum = 0, topNSum[] = new long[N+1], bottomNSum[] = new long[N+1];
        for(int i = 0 ; i < N ; i++) {
            minHeap.add(A[i]);
            sum += A[i]; 
        }
        topNSum[0] = sum;
        for(int i = N ; i < 2*N ; i++) {
            if(A[i] > minHeap.peek()) {
                sum -= minHeap.poll();
                sum += A[i];
                minHeap.add(A[i]);
            }
            topNSum[i-N + 1] = sum;
        }
        sum = 0;
        for(int i = 3*N-1 ; i >= 2*N ; i--) {
            maxHeap.add(A[i]);
            sum += A[i]; 
        }
        bottomNSum[N] = sum;
        for(int i = 2*N -1 ; i >= N ; i--) {
            if(A[i] < maxHeap.peek()) {
                sum -= maxHeap.poll();
                sum += A[i];
                maxHeap.add(A[i]);
            }
            bottomNSum[i - N] = sum;
        }

        long maxDiff = Integer.MIN_VALUE;
        for(int i = 0 ; i <= N; i++) {
           maxDiff = Math.max(maxDiff, topNSum[i] - bottomNSum[i]); 
        }
        return maxDiff;
    }
}
