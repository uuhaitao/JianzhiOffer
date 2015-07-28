package com.frank.leetcode;

import java.util.ArrayList;
import java.util.List;

public class L56MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
	      List<Interval> res = new ArrayList<Interval>();
			if (intervals.size() == 0)
				return res;

//			intervals.sort(new Comparator<Interval>() {
//				@Override
//				public int compare(Interval o1, Interval o2) {
//					if (o1.start == o2.start)
//						return o1.end - o2.end;
//					return o1.start - o2.start;
//				}
//			});
			int len=intervals.size();
			Interval pre=intervals.get(0);
			for(int i=1;i<len;i++){
				Interval curr=intervals.get(i);
				if(curr.start<=pre.end  && curr.end>pre.end){
					pre.end=curr.end;
				}
				else if(curr.start>pre.end)
				{
					res.add(pre);
					pre=curr;
				}
			}
			res.add(pre);
			return res;
		}

	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		if (intervals.size() == 0) {
			List<Interval> res = new ArrayList<Interval>();
			res.add(newInterval);
			return res;
		}

		intervals.add(newInterval);
		return merge(intervals);
	}
	public static void main(String[] args) {
				Interval l1=new Interval(1, 5);
				Interval l2=new Interval(2, 3);
				List<Interval> res = new ArrayList<Interval>();
				res.add(l1);
				new L56MergeIntervals().insert(res, l2);
	}
	
	
}
