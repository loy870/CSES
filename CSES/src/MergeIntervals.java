import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {


    public int[][] merge(int[][] intervals) {

        List<Interval> intervalList = new ArrayList<>();
        for (int[] interval : intervals) {
            intervalList.add(new Interval(interval[0], interval[1]));
        }

        Collections.sort(intervalList);

        Collections.reverse(intervalList);

        LinkedList<Interval> resultList = new LinkedList<>();

        for (Interval interval : intervalList) {
            if (resultList.isEmpty()) {
                resultList.add(interval);
            } else {
                Interval prev = resultList.getLast();
                if (prev.end >= interval.start) {
                    resultList.removeLast();
                    int minStart = Math.min(interval.start, prev.start);
                    Interval merge = new Interval(minStart, prev.end);
                    resultList.add(merge);
                } else {
                    resultList.add(interval);
                }
            }
        }

        Collections.reverse(resultList);

        int[][] result = new int[resultList.size()][2];
        int count = 0;

        for (Interval interval : resultList) {
            int[] temp = {interval.start, interval.end};
            result[count] = temp;
            count++;
        }


        return result;

    }

    class Interval implements Comparable {
        public int start;
        public int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Object o) {
            Interval that = (Interval) o;
            if (this.end > that.end)
                return 1;
            else if (this.end < that.end)
                return -1;
            if (this.end == that.end) {
                if (this.start > that.start)
                    return 1;
                else
                    return -1;
            }
            return 0;
        }
    }
}
