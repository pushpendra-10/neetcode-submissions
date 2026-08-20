class StockSpanner {
    Stack<int[]> st;
    int idx;
    public StockSpanner() {
        st = new Stack<>();
        idx=0;
    }
    
    public int next(int price) {
        while(!st.isEmpty() && st.peek()[1] <= price){
            st.pop();
        }
        int output;
        if(st.isEmpty()) output = idx+1;
        else output = idx-st.peek()[0];
        
        st.push(new int[]{idx++, price});
        return output;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */