// https://leetcode.com/problems/circle-and-rectangle-overlapping/
// https://leetcode.com/problems/circle-and-rectangle-overlapping/discuss/563463/C%2B%2B-with-simple-explanation

class Solution {
    public boolean checkOverlap(int r, int x, int y, int minX, int minY, int maxX, int maxY) {
        // move circle to origin and change rectangle cordinatae
        minX -= x; maxX -= x;
        minY -= y; maxY -= y;
        // now we need to check if there exist a point (x,y) inside rectangle with in inside circle
        // x^2 + y^2 <= r*r
        // ie, min(x^2) + min(y^2) <= r*r
        // if both minX, maxX have different sign means there will be one point as 0 which in min(x^2)
        return (minX*maxX > 0 ? Math.min(minX*minX, maxX*maxX) : 0) 
            +  (minY*maxY > 0 ? Math.min(minY*minY, maxY*maxY) : 0)
            <=  r*r ? true : false;
            
    }
}
// class Solution {// not working for some test case with radious 1203
//     public boolean checkOverlap(int r, int x, int y, int minX, int minY, int maxX, int maxY) {
//         // circle limiting points
//         int [][]c = {
//             {x-r,y},
//             {x+r,y},
//             {x,y-r},
//             {x,y+r}
//         };
//         // rectangle limiting points
//         int [][]rec = {
//             {minX,minY},
//             {maxX,maxY},
//             {minX,maxY},
//             {maxX,minY}
//         };
//         for(int i = 0 ; i < 4 ; i++) {
//               if(isInsideRectangle(minX,minY,maxX,maxY,c[i][0],c[i][1]))
//                   return true;
//         } 
//         for(int i = 0 ; i < 4 ; i++) {
//               if(isInsideCircle(r,x,y,rec[i][0],rec[i][1]))
//                   return true;
//         } 
//         return false;
//     }
    
    
//     boolean isInsideCircle(int r, int x, int y, int x1, int y1) {
//         int d1 = (x-x1)*(x-x1) + (y-y1)*(y-y1);
//         System.out.println(d1+" "+ (x-x1)*(x-x1)+" "+(y-y1)*(y-y1));
//         if(d1 <= r*r) 
//             return true;
//         return false;
//     }
    
//     boolean isInsideRectangle(int minX, int minY, int maxX, int maxY, int x, int y) {
//         if(x >= minX && x <= maxX && y >= minY && y <= maxY)
//             return true;
//         return false; 
//     }
// }
