/*
 * @lc app=leetcode id=729 lang=java
 *
 * [729] My Calendar I
 */

// @lc code=start
class MyCalendar {
    private List<int[]> calender;

    public MyCalendar() {
        this.calender = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for (int i = 0; i < calender.size(); i++) {
            int[] cal = calender.get(i);
            int cur_start = cal[0];
            int cur_end = cal[1];
            if (cur_end <= start || cur_start >= end) {
                // OK
            } else {
                return false;
            }
        }
        calender.add(new int[]{start,end});
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
// @lc code=end

