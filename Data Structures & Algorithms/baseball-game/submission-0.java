class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();
        int sum = 0;
        for(int i=0; i<operations.length; i++){
            String s = operations[i];
            if(s.equals("C")){
                sum -= st.pop();
            }
            else if(s.equals("D")){
                sum += 2*st.peek();
                st.push(2 * st.peek());

            }
            else if(s.equals("+")){
                int v2 = st.pop();
                int v1 = st.peek();
                sum += v1 + v2;
                st.push(v2);
                st.push(v1+v2);
            }
            else{
                int num = Integer.parseInt(s);
                sum += num;
                st.push(num);
            }
        }
        return sum;
    }
}