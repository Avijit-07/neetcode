class Solution {
    public int characterReplacement(String s, int k) {
        if(s == null || s.length() == 0) return 0;

        char[] arr = s.toCharArray();

        int left = 0, maxWindow = 0, maxFreq = 0;

        Map<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < arr.length; right++) {
            char c = arr[right];

            map.put(c, map.getOrDefault(c, 0) + 1);
            maxFreq = Integer.max(maxFreq, map.get(c));
            
            // check if we're allowed to replace
            int windowSize = (right - left) + 1;

            if(windowSize - maxFreq > k) {
                map.put(arr[left], map.get(arr[left]) - 1);
                left++;
            }

            maxWindow = Integer.max(maxWindow, right - left + 1);
        }
        return maxWindow;
    }
}
