class Solution {
    public boolean isAnagram(String s, String t){
        int n = s.length();
        int m = t.length();
        if(n != m) return false;

        int[] arr = new int[26];

        for(int i=0; i<n; i++){
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }
        for(int ele: arr){
            if(ele != 0) return false;
        }
        return true;
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        HashSet<Integer> set = new HashSet<>();
        List<List<String>> list = new ArrayList<>();
        for(int i=0; i<n; i++){  
            if(set.contains(i)) continue;  
            List<String> arr = new ArrayList<>();
            arr.add(strs[i]);
            for(int j=i+1; j<n; j++){
                if(isAnagram(strs[i],strs[j])){
                    arr.add(strs[j]);
                    set.add(j);
                }    
            }
            list.add(arr);
        }
        return list;
    }
}
