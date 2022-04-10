import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=731 lang=java
 *
 * [731] My Calendar II
 */

// @lc code=start
class MyCalendarTwo {
    private List<int[]> events = new ArrayList<int[]>();
    // すでに重複している区間を別で管理する
    private List<int[]> overlaps = new ArrayList<int[]>();

    public MyCalendarTwo() {
    }
    
    public boolean book(int start, int end) {
        for (int[] overlap : overlaps) {
            int oStart = overlap[0];
            int oEnd = overlap[1];
            if (oEnd <= start || oStart >= end) {
                // OK
            } else {
                // すでにオーバーラップしている区間にバッティングしたのでアウト
                return false;
            }
        }

        // 今回の変更によりオーバーラップする区間をチェック
        for (int[] event : events) {
            int eStart = event[0];
            int eEnd = event[1];
            if (eStart >= end || eEnd <= start) {
                // OK
            } else {
                overlaps.add(new int[]{Math.max(eStart, start), Math.min(eEnd, end)});
            }
        }
        events.add(new int[]{start, end});
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
// @lc code=end

