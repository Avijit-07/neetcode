class Solution {
    public int minEatingSpeed(int[] piles, int h) {
       // max could be highest number in a pile
       // min could be lowest number in a pile
       // if the mid point of this range is less than allocated hours
       // then the min rate would be in the left side
       // otherwise it'll be in the right side

       int minSpeed = 1;
       int maxSpeed = Integer.MIN_VALUE;

       for(int pile : piles) {
        maxSpeed = Math.max(maxSpeed, pile);
       }

       while (minSpeed <= maxSpeed) {
        int mid = minSpeed + (maxSpeed - minSpeed) / 2;
        long hour = 0;
        for (int pile : piles) {
            hour += (pile + mid - 1) / mid;
        }
        if(hour <= h) {
            maxSpeed = mid - 1;
        } else {
            minSpeed = mid + 1;
         }
       }
       return minSpeed;
    }
}
