class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> freq = new HashMap<>();
        for(char c : t.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        int have = 0, need = freq.size();

        int left = 0, minLen = Integer.MAX_VALUE, start = 0;
        Map<Character, Integer> window = new HashMap<>();

        for(int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if(freq.containsKey(c) && window.get(c).equals(freq.get(c))){
                have++;
            }

            while(have == need) {
                if(right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }
                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);
                if(freq.containsKey(leftChar) && window.get(leftChar) < freq.get(leftChar))
                    have--;
                left++;
            }

        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen); 
    }
}
