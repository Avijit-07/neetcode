class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> s1Map = new HashMap<>();
        char[] s1Array = s1.toCharArray();

        for(char c : s1Array) {
            if(s1Map.containsKey(c)){
                s1Map.replace(c, s1Map.get(c) + 1);
            } else {
                s1Map.put(c, 1);
            }
        }

        int k = s1.length();
        char[] s2Array = s2.toCharArray();

        for(int i = 0; i <= s2Array.length - k; i++) {
            Map<Character, Integer> s2Map = new HashMap<>();
            int left = i;
            int right = left + k - 1;
            while (left <= right) {
                if(s2Map.containsKey(s2Array[left])){
                    s2Map.replace(s2Array[left], s2Map.get(s2Array[left]) + 1);
                } else {
                    s2Map.put(s2Array[left], 1);
                }
                left++;
            }

            if(s1Map.entrySet().stream()
                    .allMatch(e -> e.getValue().equals(s2Map.get(e.getKey()))))
                return true;
        }


        return false;
    }
}
