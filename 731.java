// https://leetcode.com/problems/my-calendar-ii/
// https://leetcode.com/problems/my-calendar-ii/discuss/109550/Simple-AC-by-TreeMap
class MyCalendarTwo {
    TreeMap<Integer,Integer> tm = null; 
    public MyCalendarTwo() {
        tm = new TreeMap(); 
    }
    
    public boolean book(int start, int end) { // line sweep algorithm
        tm.put(start, tm.getOrDefault(start,0) + 1);
        tm.put(end, tm.getOrDefault(end,0) - 1);
        int count = 0;
        for(Map.Entry<Integer,Integer> entry : tm.entrySet()){
            count += entry.getValue();
            if(count > 2){
                tm.put(start, tm.getOrDefault(start,0) - 1);
                tm.put(end, tm.getOrDefault(end,0) + 1);
                tm.remove(start,0);
                tm.remove(end,0);
                return false;
            }
        }
        return true;
    }
   
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
