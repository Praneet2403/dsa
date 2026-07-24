class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String , List<String>> mp = new HashMap<>();
        for(String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String tingu = new String(arr);


            if(!mp.containsKey(tingu)){
                mp.put(tingu, new ArrayList<>());
            }

            mp.get(tingu).add(s);
        }

        return new ArrayList<>(mp.values());
    }
}