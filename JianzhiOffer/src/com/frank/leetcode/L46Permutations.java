package com.frank.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by haitao on 7/22/15.
 */
public class L46Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new LinkedList<>();
        if (nums==null || nums.length==0)
            return  res;

        Arrays.sort(nums);
        helper(nums,new ArrayList<Integer>(),new ArrayList<Integer>(),res);

        return res;

    }

    void helper(int []nums,List<Integer> preval,List<Integer> preind,List<List<Integer>> res)
    {
        if(nums.length==preval.size())
        {
            if (!res.contains(preval))
                res.add(preval);
            return;
        }
        for(int i=0;i<nums.length;i++)
        {
            if (preind.contains(i))
                continue;

            List<Integer> tmplist=new ArrayList<>(preval);
            tmplist.add(nums[i]);
            List<Integer> tmpind=new ArrayList<>(preind);
            tmpind.add(i);
            helper(nums, tmplist, tmpind, res);
        }
    }

    public static void main(String []args)
    {
        List<List<Integer>> res=new L46Permutations().permute(new int[]{3,3,1,2,3,2,3,1});
        for (List<Integer> list:res)
        {
            for (Integer e:list)
                System.out.print(e + " ");
            System.out.println();
        }
    }

}
