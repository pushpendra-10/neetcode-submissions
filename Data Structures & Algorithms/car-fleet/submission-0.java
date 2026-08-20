class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Double> map = new HashMap<>();

        for(int i=0; i<n; i++){
            map.put(position[i], (double)(target-position[i])/speed[i]);
            st.push(i);
        }
        
        Arrays.sort(position);

        int count = 0;
        while(!st.isEmpty()){
            int top = st.pop();
            while(!st.isEmpty() && map.get(position[top]) >= map.get(position[st.peek()])){
                st.pop();
            }
            count++;
        }

        return count;
    }
}
