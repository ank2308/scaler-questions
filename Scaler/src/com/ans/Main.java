package com.ans;

import java.util.ArrayList;

public class Main {

	public static void main(String [] args) {
		// TODO Auto-generated method stub
		ArrayList<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1, 2));
		intervals.add(new Interval(5, 8));
		intervals.add(new Interval(10, 11));
		intervals.add(new Interval(13, 16));
		intervals.add(new Interval(17, 20));
		Interval interval = new Interval(6,12);
		Solution s = new Solution();
		intervals = s.insert(intervals, interval);
		for (Interval interval2 : intervals) {
			System.out.println(interval2.start +"   "+interval2.end);
		}
	}
}
