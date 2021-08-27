class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {

        String[] temp1 = play_time.split(":");
        String[] temp2 = adv_time.split(":");
        int play_time_sec = timeToSec(temp1[0], temp1[1], temp1[2]);
        int adv_time_sec = timeToSec(temp2[0], temp2[1], temp2[2]);

        long[] timeTrack = new long[play_time_sec +1]; //0 ~ play_time_sec

        for(String log : logs) {
            String[] temp = log.split("-");
            temp1 = temp[0].split(":");
            temp2 = temp[1].split(":");
            timeTrack[timeToSec(temp1[0], temp1[1], temp1[2])]++;
            timeTrack[timeToSec(temp2[0], temp2[1], temp2[2])]--;
        }

        for (int i = 1; i < timeTrack.length; i++) timeTrack[i] += timeTrack[i-1];
        for (int i = 1; i < timeTrack.length; i++) timeTrack[i] += timeTrack[i-1];

        long max = timeTrack[adv_time_sec -1];
        int advStart = 0;
        for (int i = 1; i <= play_time_sec - adv_time_sec; i++) {
            long timeSum = timeTrack[i + adv_time_sec -1] - timeTrack[i - 1];

            if(timeSum > max) {
                max = timeSum;
                advStart = i;
            }
        }

        return String.format("%02d:%02d:%02d", advStart / 3600, (advStart % 3600) / 60, (advStart % 3600) % 60);
    }

    static int timeToSec(String h, String m, String s) {
        return Integer.parseInt(h) * 3600 + Integer.parseInt(m) * 60 + Integer.parseInt(s);
    }
}