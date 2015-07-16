package com.frank.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L207CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		List<List<Integer>> after = new ArrayList<List<Integer>>();
		for (int i = 0; i < numCourses; i++) {
			after.add(new ArrayList<Integer>());
		}
		int []prenum=new int[numCourses];
		for(int i=0;i<prerequisites.length;i++)
		{
			after.get(prerequisites[i][1]).add(prerequisites[i][0]);
			prenum[prerequisites[i][0]]++;
		}
		Queue<Integer> que=new LinkedList<Integer>();
		for(int i=0;i<numCourses;i++)
		{
			if(prenum[i]==0)
				que.add(i);
		}
		int n = numCourses;
		while(!que.isEmpty())
		{
			int ind=que.poll();
			n--;
			for(int i: after.get(ind))
			{
				prenum[i]--;
				if(prenum[i]==0)
					que.add(i);
			}
		}
		return n == 0;
	}
}
