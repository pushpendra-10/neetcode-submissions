class Solution {
    public String minWindow(String s, String t) {
        int[] map = new int[123]; 
        for(int i=0; i<t.length(); i++){
            char ch = t.charAt(i);
            map[ch]++;
        }

        int sIndex = -1;
        int minLen = Integer.MAX_VALUE;
        int count = 0;
        int j=0;
        int i=0;
        while(i < s.length()){
            char ch = s.charAt(i);
            map[ch]--;
            if(map[ch] >= 0) count++;

            while(count == t.length()){
                if((i-j+1) < minLen){
                    minLen = i-j+1;
                    sIndex = j;
                }
                char lch = s.charAt(j++);
                map[lch]++;
                if(map[lch] > 0) count--;
            }
            i++;
        }
        if(sIndex == -1) return "";
        return s.substring(sIndex, sIndex+minLen);
    }
}
