class Solution {
    List<String> ans;
    public void generate(int open, int close, int n, String str){
        if(str.length() == 2*n){
            ans.add(str);
            return;
        }
        if(open < n)generate(open+1, close, n, str+"(");
        if(close < open)generate(open, close+1, n, str+")");
    }
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        generate(0, 0, n, "");
        return ans;
    }
}
