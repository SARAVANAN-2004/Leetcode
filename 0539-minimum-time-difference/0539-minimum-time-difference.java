import java.time.LocalTime;
import java.time.Duration;
class Solution {
    public int findMinDifference(List<String> timePoints) {
        int[][] time = new int[timePoints.size()][2];
        int idx = 0;
        for(String s:timePoints){
        String[] a = s.split(":");
        time[idx][0] = Integer.valueOf(a[0]);
        time[idx][1] = Integer.valueOf(a[1]);
        idx++;
        }
        Arrays.sort(time,(a,b) ->
        {
        if (a[0] == b[0]){
            return a[1] - b[1];
        }else{
        return a[0] - b [0];
        }
        });
        int m = Integer.MAX_VALUE;
        for(int i = 0;i<idx;i++){
            int[] a = time[i];
            int[] b;
            if(i == idx-1){
            b = time[0];
            }else{
            b = time[i+1];
            }

        LocalTime start = LocalTime.of(a[0], a[1]);
        LocalTime end = LocalTime.of(b[0], b[1]);
        Duration duration = Duration.between(start, end);
        if (duration.isNegative()) {
            duration = duration.plusHours(24);
        }

        int minutes = (int)(duration.toMinutes());
        m = Math.min(m,minutes);
        }
        return m;
    }
}