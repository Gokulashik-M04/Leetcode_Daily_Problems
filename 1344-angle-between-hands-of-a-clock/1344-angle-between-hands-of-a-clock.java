class Solution {
    public double angleClock(int hour, int minutes) {
        double minAng = minutes * 6;
        double hourAng = (30 * hour) + (0.5 * (double)minutes);
        double angle = Math.abs(hourAng - minAng);
        return Math.min(angle,360  - angle); 
    }
}