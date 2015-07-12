package com.frank.hihocoder;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ConnectGraph {
	public int val;
	List<ConnectGraph> childred = new LinkedList<ConnectGraph>();
	public int circleval;
	public boolean visited = false;
	public int prefixval=0;
	public boolean iscircle=false;

	public ConnectGraph(int val) {
		this.val = val;
	}

	public void addchild(ConnectGraph node) {
		childred.add(node);
	}

	public void setcircleval(int val) {
		this.circleval = val;
	}

	public static int getmax(ConnectGraph startnode,int preval) {

		if (startnode == null)
			return 0;
		if(startnode.visited){
			startnode.iscircle=true;
			int circletmp=preval-startnode.prefixval-startnode.val;
			if(circletmp>startnode.circleval)
				startnode.circleval=circletmp;
			return Integer.MIN_VALUE;
		}
		startnode.visited = true;
		startnode.prefixval=preval;
		int sonmax = 0;
		if (startnode.childred.size() > 0) {
			for (ConnectGraph child : startnode.childred) {
				int soncount = getmax(child,startnode.val+preval);
				if(soncount==Integer.MIN_VALUE){
					if(!startnode.iscircle)
						return Integer.MIN_VALUE;
				}
				else if (soncount > sonmax)
					sonmax = soncount;
			}
		}
		return sonmax + startnode.val + startnode.circleval;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int nodeNum=in.nextInt();
		int edgeNum=in.nextInt();
		ConnectGraph nodes[]=new ConnectGraph[nodeNum];
		for(int i=0;i<nodeNum;i++){
			nodes[i]=new ConnectGraph(in.nextInt());
		}
		for(int j=0;j<edgeNum;j++){
			int ind1=in.nextInt();
			int ind2=in.nextInt();
			nodes[ind1-1].addchild(nodes[ind2-1]);
		}
		
		int val=getmax(nodes[0],0);
		val=getmax(nodes[0],0);
		System.out.println(val);
	}
}
