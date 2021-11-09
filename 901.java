// https://leetcode.com/problems/online-stock-span/

/*
We can use decreasing stack to hold elements.
We need index as well so that we can get span by substracting with curIndex

TC : 0(n)
SC : 0(n)
*/
class StockSpanner {
    
    Deque<Node> stack;
    int curIndex = 0;
    public StockSpanner() {
        stack = new ArrayDeque<Node>();
    }
    
    public int next(int price) {
        while(!stack.isEmpty() && stack.peek().val <= price)  
            stack.pop();
        int span = stack.isEmpty() ? curIndex + 1 : curIndex - stack.peek().index;
        stack.push(new Node(curIndex,price));
        curIndex++;
        return span;
    }
}
class Node{
    int index, val;
    Node(int index, int val) {
        this.index = index;
        this.val = val;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
