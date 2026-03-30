class Solution {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        boolean result = false;

        while(left < right) {
            if(!Character.isLetterOrDigit(s.charAt(left))) {
                    left++;
                    continue;
            } if(!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
                continue;
            }
            char leftLC = Character.toLowerCase(s.charAt(left));
            char rightLC = Character.toLowerCase(s.charAt(right));

            if(leftLC != rightLC) {
                return false;
            }
                left++;
                right--;
        }
        return true;
    }
}
