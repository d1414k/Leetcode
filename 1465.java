
class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        long maxHeight = 0, maxWidth = 0, prev = 0;
        for(int i = 0 ; i < horizontalCuts.length ; i++) {
            maxHeight = Math.max(maxHeight, horizontalCuts[i] - prev);
            prev = horizontalCuts[i];
        }
        maxHeight = Math.max(maxHeight, h - prev);
        
        prev = 0;
        for(int i = 0 ; i < verticalCuts.length ; i++) {
            maxWidth = Math.max(maxWidth, verticalCuts[i] - prev);
            prev = verticalCuts[i];
        }
        maxWidth = Math.max(maxWidth, w - prev);
        
        return (int)((maxHeight*maxWidth)%1000000007);
    }
}
