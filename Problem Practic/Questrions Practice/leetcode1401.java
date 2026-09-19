class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int closestx = Math.max(x1,Math.min(xCenter, x2));
        int closesty = Math.max(y1,Math.min(yCenter, y2));

        int dx = xCenter - closestx;
        int dy = yCenter - closesty;

        return dx * dx + dy * dy <= radius * radius;
    }
}
