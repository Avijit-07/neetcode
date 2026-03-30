class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
		Map<Character, Integer> stringMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
			int count = 0;
			char key = s.toLowerCase().charAt(i);
			if(stringMap.containsKey(key)) {
				count = stringMap.get(key);
				stringMap.replace(key, count + 1);
			} else {
				stringMap.put(key, count + 1);
			}
		}

		for (int i = 0; i < t.length(); i++) {
			char key = t.toLowerCase().charAt(i);
			if(stringMap.containsKey(key)) {
				int count = stringMap.get(key);
				stringMap.replace(key, count - 1);
			} else {
				return false;
			}
		}

		return stringMap.entrySet().parallelStream().allMatch(map -> map.getValue() == 0);

        
    }
}
