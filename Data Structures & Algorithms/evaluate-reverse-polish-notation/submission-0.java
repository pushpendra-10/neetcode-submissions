class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        int n = tokens.length;
        for(int i=0; i<n; i++){
            String s = tokens[i];
            if(!s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/")){
                int num = Integer.parseInt(s);
                st.push(num);
            }
            else{
                int v1 = st.pop();
                int v2 = st.pop();
                if(s.equals("+")) st.push(v2+v1);
                if(s.equals("-")) st.push(v2-v1);
                if(s.equals("*")) st.push(v2*v1);
                if(s.equals("/")) st.push(v2/v1);
            } 
        }
        return st.pop();
    }
}
