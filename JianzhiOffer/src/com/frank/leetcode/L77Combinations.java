package com.frank.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by haitao on 7/23/15.
 *
 *
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

 For example,
 If n = 4 and k = 2, a solution is:

 [
 [2,4],
 [3,4],
 [2,3],
 [1,2],
 [1,3],
 [1,4],
 ]
 *
 */
public class L77Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res=new LinkedList<>();
        LinkedList<Integer> candidates=new LinkedList<>();
        for(int i=1;i<=n;i++)
            candidates.add(i);
        helper(0,k,new LinkedList<Integer>(),candidates,res);

        return  res;
    }

    void helper(int start,int k,List<Integer> pre,List<Integer> candidate,List<List<Integer>> res)
    {
        if(pre.size()==k)
        {
            res.add(pre);
            return;
        }
        for (int i=start;i<candidate.size();i++)
        {
            List<Integer> line = new LinkedList<>(pre);
            line.add(candidate.get(i));
            helper(i+1,k,line,candidate,res);
        }

//        for(Integer ele:candidate) {
//            List<Integer> line = new LinkedList<>(pre);
//            line.add(ele);
//            List<Integer> newcan=new ArrayList<>(candidate);
//            newcan.remove(ele);
//            helper(k, line, newcan, res);
//            helper(start+1;k,line,candidate,res);
//        }
    }

    public static void main(String args[])
    {
        List<List<Integer>> res=new L77Combinations().combine(4,2);
        for(List<Integer> line:res)
        {
            for (Integer e:line)
                System.out.print(e + " ");
            System.out.println();
        }
    }

}
