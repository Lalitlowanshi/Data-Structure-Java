import java.util.PriorityQueue;

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // Priority queue to store classes with the highest gain first
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        
        // Add all classes to the heap with initial gain
        for (int[] cls : classes) {
            int pass = cls[0], total = cls[1];
            double gain = calculateGain(pass, total);
            maxHeap.offer(new double[]{gain, pass, total});
        }
        
        // Assign each extra student to the class with the highest gain
        while (extraStudents-- > 0) {
            double[] top = maxHeap.poll();
            double gain = top[0];
            int pass = (int) top[1];
            int total = (int) top[2];
            
            // Update the class with one more passing student
            pass++;
            total++;
            gain = calculateGain(pass, total);
            maxHeap.offer(new double[]{gain, pass, total});
        }
        
        // Compute the average pass ratio
        double totalRatio = 0.0;
        while (!maxHeap.isEmpty()) {
            double[] top = maxHeap.poll();
            int pass = (int) top[1];
            int total = (int) top[2];
            totalRatio += (double) pass / total;
        }
        
        return totalRatio / classes.length;
    }

    // Helper method to calculate the gain of adding one student
    private double calculateGain(int pass, int total) {
        return ((double) (pass + 1) / (total + 1)) - ((double) pass / total);
    }
}
