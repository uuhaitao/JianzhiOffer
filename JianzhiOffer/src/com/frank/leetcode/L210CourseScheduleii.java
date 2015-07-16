package com.frank.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L210CourseScheduleii {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int res[]=new int[numCourses];
		if(prerequisites==null ||prerequisites.length==0 || prerequisites[0].length==0){
			for(int i=0;i<numCourses;i++)
				res[i]=i;
			return res;
		}
		
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
		
		int j=0;
		int n=numCourses;
		while(!que.isEmpty())
		{
			int ind=que.poll();
			res[j++]=ind;
			n--;
			for(int i: after.get(ind))
			{
				prenum[i]--;
				if(prenum[i]==0)
					que.add(i);
			}
		}
		
		return n==0?res:new int[numCourses];
	}
	
	public static void main(String[] args) {
//		new L210CourseScheduleii().findOrder(2, new int[][]{{1,0}});
		int a[]=new int[]{};
		System.out.println(a==null);
		
		System.out.println(a.length==0);
	}
}
