package com.ans;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		Interval toInsert = new Interval();
		ArrayList<Interval> newIntervals = new ArrayList<>();
        for(Interval interval : intervals) {
            if(interval.start <= newInterval.start && interval.end >= newInterval.start) {
            	toInsert.start = Math.min(interval.start, newInterval.start);
            } else if(interval.start <= newInterval.start && interval.end < newInterval.start){
            	toInsert.start = newInterval.start;
            }

            if(interval.start <= newInterval.end && interval.end >= newInterval.end) {
            	toInsert.end = Math.max(interval.end, newInterval.start);
            } else if(interval.start <= newInterval.end && interval.end < newInterval.end){
            	toInsert.end = newInterval.end;
            }
            if(toInsert.start == 0) {
            	newIntervals.add(interval);
            }
            if(toInsert.end != 0) {
            	newIntervals.add(toInsert);
            	toInsert.start = 0;
            }
        }
        return newIntervals;
    }
}
