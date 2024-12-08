import java.util.*;

class Solution {
    public int maxTwoEvents(int[][] events) {
        // PriorityQueue to store pairs (endTime, value), sorted by endTime
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        // Sort events by start time
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

        int maxVal = 0; // Maximum value of any single event processed so far
        int maxSum = 0; // Maximum sum of two non-overlapping events

        for (int[] event : events) {
            // Remove events that end before the current event starts
            while (!pq.isEmpty() && pq.peek()[0] < event[0]) {
                maxVal = Math.max(maxVal, pq.poll()[1]);
            }

            // Update the maximum sum of two non-overlapping events
            maxSum = Math.max(maxSum, maxVal + event[2]);

            // Add the current event to the priority queue
            pq.add(new int[]{event[1], event[2]});
        }

        return maxSum;
    }
}
