class Solution {
    public int numDecodings(String s) {
        /**
            For example, "1012" can be mapped into:
            "JAB" with the grouping (10 1 2)
            "JL" with the grouping (10 12)
            1 -> 012
                    -> 0 -> 12 X
                    -> 01 -> 2 X
            10 -> 12
                    -> 1 -> ""
                    -> 12 -> ""
            dp[i] = dp[i - 1] (if single digit is valid) 
                        + dp[i - 2] (if double digit is valid)
        */

        int[] dp = new int[s.length() + 1];

        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        // 1 0 1 2
        for(int i = 2; i <= s.length(); i++) { // 0
            int firstDigit = Integer.valueOf(s.substring(i - 1, i));
            int secondDigit = Integer.valueOf(s.substring(i - 2, i));

            if(firstDigit > 0) {
                dp[i] += dp[i - 1];
            }
            if(secondDigit >=10 && secondDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }
}
