class Solution {
    public List<String> letterCombinations(String digits) {
        // first store the mapping in an array

        String[] map = new String[]{
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
        };

        List<String> result = new ArrayList<>();

        if(digits == null | digits.isEmpty()) return result;

        backtrack(result, new StringBuilder(), 0, map, digits);
        return result;
    }

    private void backtrack(List<String> result,
                            StringBuilder temp, 
                            int index, 
                            String[] map, 
                            String digits) {
        if(temp.length() == digits.length()) {
            result.add(temp.toString());
            return;
        }

        String letters = map[digits.charAt(index) - '0'];

        for(char c : letters.toCharArray()) {
            temp.append(c);
            backtrack(result, temp, index + 1, map, digits);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
