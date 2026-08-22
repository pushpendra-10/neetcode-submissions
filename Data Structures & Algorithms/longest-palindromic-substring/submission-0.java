class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        int start=0, end=0;
        for(int k=0; k<n; k++){
            int i=0, j=k;
            while(j<n){
                if(i==j){
                    dp[i][j] = 1;
                    start = i;
                    end = j;
                }
                else if(s.charAt(i) == s.charAt(j)){
                    if(j-i+1 == 2){
                        dp[i][j] = 1;
                        start = i;
                        end = j;
                    }
                    else{
                        if(dp[i+1][j-1] == 1){
                            dp[i][j] = 1;
                            start = i;
                            end = j;                           
                        }
                    }
                }
                i++;
                j++;
            }
        }
        return s.substring(start, end+1);
    }
}
