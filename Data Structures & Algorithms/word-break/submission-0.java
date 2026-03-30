class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);

        int maxWordLen = set.stream().mapToInt(str -> str.length()).max().orElse(0);

        boolean[] dp = new boolean[s.length() + 1];

        dp[0] = true;

        for(int i = 1; i <= s.length(); i++) {
            for (int j = Math.max(0, i - maxWordLen); j < i; j++) {
                String sub = s.substring(j, i);
                if(dp[j] && set.contains(sub)) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];

    }
}
