class StockSpanner {
    Stack<Integer> st;
    ArrayList<Integer> arr;
    int idx;
    public StockSpanner() {
        st = new Stack<>();
        arr = new ArrayList<>();
        idx=0;
    }
    
    public int next(int price) {
        arr.add(price);
        while(!st.isEmpty() && arr.get(st.peek()) <= price){
            st.pop();
        }
        int output;
        if(st.isEmpty()) output = idx+1;
        else output = idx-st.peek();
        
        st.push(idx++);
        return output;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */