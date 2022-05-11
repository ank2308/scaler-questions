import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class MergeIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1,2));
		
		intervals.add(new Interval(12, 16));
		intervals.add(new Interval(14, 20));
		intervals.add(new Interval(3, 8));
		intervals.add(new Interval(9, 13));
		int [][] arr = {{2,6},{1,3}};
		MergeIntervals mi = new MergeIntervals();
		mi.merge1(arr);
	}
	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		intervals.sort((Interval i1, Interval i2) -> i1.start-i2.start);
		ArrayList<Interval> ans = new ArrayList<>();
		int start=0, end=0;
		for (Interval interval : intervals) {
			if(start==0 && end ==0) {
				start = interval.start;
				end = interval.end;
			}
			if(interval.start>end) {
				Interval itemp = new Interval(start, end);
				ans.add(itemp);
				start = interval.start;
				end = interval.end;
			} else if(interval.start<end && interval.end>end) {
				end = interval.end;
			}
		}
		Interval itemp = new Interval(start, end);
		ans.add(itemp);
		return ans;
	}
	
	public int[][] merge1(int[][] arr) {
        int row = arr.length;
        Interval [] intervals = new Interval[row];
        for(int i = 0; i < row;i++){
            Interval interval = new Interval(arr[i][0], arr[i][1]);
            intervals[i] = interval;
        }
        Stack<Interval> intervalsS = new Stack<>();
        Arrays.sort(intervals, (Interval i1, Interval i2) -> i1.start - i2.start);
        System.out.println(Arrays.asList(intervals));
        return arr;
    }
}
