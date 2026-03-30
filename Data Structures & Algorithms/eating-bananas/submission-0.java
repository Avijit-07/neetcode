class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int minSpeed = 1;
        int maxSpeed = Integer.MIN_VALUE;

        for(int pile : piles){
            maxSpeed = Math.max(maxSpeed, pile);
        }

        while(minSpeed <= maxSpeed) {
            int mid = minSpeed + (maxSpeed - minSpeed) / 2;

            int minHour = 0;

            for(int pile: piles) {
                minHour += (pile + mid - 1) / mid;
            }
            if(minHour <= h) {
                maxSpeed = mid - 1;
            } else {
                minSpeed = mid + 1;
            }
        }

        return minSpeed;
    }
}
