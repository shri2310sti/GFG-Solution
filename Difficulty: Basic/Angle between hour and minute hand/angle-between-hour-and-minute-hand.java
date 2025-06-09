class Solution {
    static int getAngle(int h, int m) {
        // Minute hand angle
        double minute_angle = m * 6;

        // Hour hand angle
        double hour_angle = (h % 12) * 30 + (m * 0.5);

        // Find the absolute difference
        double angle = Math.abs(hour_angle - minute_angle);

        // Return the minimum angle and take floor
        angle = Math.min(angle, 360 - angle);

        return (int)Math.floor(angle);
    }
};
