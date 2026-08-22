class Solution {
    public String simplifyPath(String path) {
        int n = path.length();
        Stack<String> st = new Stack<>();

        for(int i=0; i<n; i++){
            String s = new String();
            if(path.charAt(i) != '/'){
                int j = i+1;
                while(j<n && path.charAt(j) != '/')j++;
                s = path.substring(i,j);
                i = j;
            }
            if(s.equals(".")) continue;
            if(s.equals("..")){
                if(!st.isEmpty()) st.pop();
                continue;
            }
            if(s.length() == 0) continue;
            else{
                st.push(s);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(new StringBuilder(st.pop()).reverse());
            sb.append("/");
        }
        if(sb.length() == 0) return "/";
        return sb.reverse().toString();
    }
}