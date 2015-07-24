package com.frank.leetcode;

import java.util.*;

/**
 * Created by haitao on 7/22/15.
 */
public class L47PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums){
        List<List<Integer>> res=new LinkedList<>();
        Arrays.sort(nums);
        List<Integer>list=new ArrayList<Integer>();
        for (int e:nums)
            list.add(e);
        res.add(list);
        int lens=nums.length;
        boolean flag=true;
        while (flag)
        {
            int ind=lens-2;
            while(ind>=0)
            {
                if (nums[ind]<nums[ind+1]) //发现第一个nums[i]<nums[i+1]的元素
                {
                    break;
                }
                ind--;
            }
            if (ind<0) //不存在下一个较大的元素
                return res;
            //从后面发现第一个大于nums[ind]的元素 与num[ind]互换
            int last=lens-1;
            for (;last>ind;last--)
            {
                if (nums[last]>nums[ind]){
                    int tmp=nums[ind];
                    nums[ind]=nums[last];
                    nums[last]=tmp;
                    break;
                }
            }
            //将ind后面的数字排序
            Arrays.sort(nums,ind+1,lens);

            List<Integer> next=new ArrayList<>();
            for (int e:nums)
                next.add(e);
            res.add(next);
        }

        return res;
    }

    public static void main(String []args)
    {
        List<List<Integer>> res=new L47PermutationsII().permuteUnique(new int[]{1,1,2,2});
        for (List<Integer> list:res)
        {
            for (Integer e:list)
                System.out.print(e + " ");
            System.out.println();
        }
    }

}
