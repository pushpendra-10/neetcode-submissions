class Solution {
    public boolean isValid(int[] a, int[] b){
        for(int i=0; i<26; i++){
            if(a[i] != b[i]) return false;
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        int n1 = s1.length();
        for(int i=0; i<n1; i++){
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }
        if(isValid(freq1, freq2)) return true;
        int i = n1;
        while(i<s2.length()){
            freq2[s2.charAt(i) - 'a']++;
            freq2[s2.charAt(i-n1) - 'a']--;
            if(isValid(freq1, freq2)) return true;
            i++;
        }
        return false;
    }
}