class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        int n = asteroids.length;
        for(int ele: asteroids){
            if(ele < 0){
                while(!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(ele)){
                    st.pop();
                }
                if(!st.isEmpty() && st.peek() > 0 && st.peek() > Math.abs(ele)){
                    continue;
                }
                if(!st.isEmpty() && st.peek() > 0 && st.peek() == Math.abs(ele)){
                    st.pop();
                    continue;
                }
            }
            st.push(ele);
        }
        int m = st.size();
        int[] ans = new int[m];
        int i = m-1;
        while(!st.isEmpty()){
            ans[i--] = st.pop();
        }
        return ans;
    }
}