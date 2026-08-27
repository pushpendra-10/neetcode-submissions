// tabulation using 1D dp
class Solution { 
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[2][amount+1];

        boolean flag = false;
        for(int i=0; i<coins.length; i++){
            if(flag == false){
                for(int j=0; j<amount+1; j++){
                    int skip = (i>0) ? dp[0][j] : ((j==0) ? 0 : Integer.MAX_VALUE);
                    if(coins[i] > j) dp[1][j] = skip;
                    else{
                        int next = dp[1][j-coins[i]];
                        int pick;
                        if (next == Integer.MAX_VALUE) pick = next;
                        else pick = next+1;
                        dp[1][j] = Math.min(skip, pick);
                    } 
                }
            }
            else{
                for(int j=0; j<amount+1; j++){
                    int skip = (i>0) ? dp[1][j] : ((j==0) ? 0 : Integer.MAX_VALUE);
                    if(coins[i] > j) dp[0][j] = skip;
                    else{
                        int next = dp[0][j-coins[i]];
                        int pick;
                        if (next == Integer.MAX_VALUE) pick = next;
                        else pick = next+1;
                        dp[0][j] = Math.min(skip, pick);
                    } 
                }
            }
            flag = !flag;
        } 

        int ans;
        if(flag == true) ans = dp[1][amount];
        else ans = dp[0][amount];

        if(ans == Integer.MAX_VALUE) return -1;
        return ans;
    }
}
