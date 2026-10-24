
class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice,
                                 String arriveBob, String leaveBob) {

        int[] days = {0, 31, 59, 90, 120, 151,
                      181, 212, 243, 273, 304, 334};

        int aliceStart = convertToDays(arriveAlice, days);
        int aliceEnd = convertToDays(leaveAlice, days);

        int bobStart = convertToDays(arriveBob, days);
        int bobEnd = convertToDays(leaveBob, days);

        int start = Math.max(aliceStart, bobStart);
        int end = Math.min(aliceEnd, bobEnd);

        return Math.max(0, end - start + 1);
    }

    private int convertToDays(String date, int[] days) {
        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3, 5));

        return days[month - 1] + day;
    }
}
