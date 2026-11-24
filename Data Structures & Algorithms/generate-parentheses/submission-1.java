
class Solution {
    List<String> ans;

    public void generate(int open, int close, int n, StringBuilder str){
        if (str.length() == 2 * n) {
            ans.add(str.toString());
            return;
        }
        
        if (open < n) {
            str.append('(');
            generate(open + 1, close, n, str);
            str.deleteCharAt(str.length() - 1);
        }
        if (close < open) {
            str.append(')');
            generate(open, close + 1, n, str);
            str.deleteCharAt(str.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        generate(0, 0, n, new StringBuilder());
        return ans;
    }
}
