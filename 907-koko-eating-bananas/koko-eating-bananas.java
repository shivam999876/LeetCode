class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1; // Minimum speed
        int right = 0; // Maximum speed
        for (int pile : piles) {
            right = Math.max(right, pile); // Get the maximum pile size
        }

        while (left < right) {
            int mid = left + (right - left) / 2; // Calculate the middle speed
            if (canFinish(piles, mid, h)) {
                right = mid; // Try for a slower speed
            } else {
                left = mid + 1; // Increase the speed
            }
        }
        return left; // The minimum speed at which Koko can finish
    }
    boolean canFinish(int[] piles, int speed, int h) {
        int hoursSpent = 0;
        for (int pile : piles) {
            hoursSpent += (pile + speed - 1) / speed; // Equivalent to Math.ceil(pile / speed)
        }
        return hoursSpent <= h; // Check if total hours spent is within the limit
    }
}