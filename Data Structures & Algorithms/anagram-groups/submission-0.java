class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for(String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String sortedKey = new String(c);
            map.computeIfAbsent(sortedKey, k -> new ArrayList()).add(s);
        }

        map.forEach((k, v) -> result.add(v));

        return result;
    }
}
