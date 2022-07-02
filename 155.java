class MinStack {
    Node head;
    public MinStack() {}
    
    public void push(int val) {
        Node node = new Node(val, val);
        if (head == null)
            head = node;
        else {
            node.min = Math.min(node.min, head.min);
            node.next = head;
            head = node;
        }
    }
    
    public void pop() {
       head = head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
       return head.min;
    }
}

class Node {
    int val, min;
    Node next;
    Node(int val, int min) {
        this.val = val;
        this.min = min;
    }
}

// class MinStack {
//     Stack<Long> stack;
//     long min = Integer.MAX_VALUE;
//     public MinStack() {
//         stack = new Stack();
//     }
    
//     public void push(long val) {
//         if(stack.empty()) {
//             stack.push(val);
//             min = val;
//         }
//         else if(val < min) {
//             stack.push(2*val - min);
//             min = val;
//         }else{
//             stack.push(val);
//         }       
//     }
    
//     public void pop() {
//         long x = stack.pop();
//         if(x < min) {
//             min = 2*min - x;
//         }
//     }
    
//     public int top() {
//         long x = stack.peek();
//         if(x < min) {
//             return (int)min;
//         }
//         return (int)x;
//     }
    
//     public int getMin() {
//         return (int)min;
//     }
// }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
