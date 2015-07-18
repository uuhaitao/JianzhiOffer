package com.frank.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by haitao on 7/17/15.
 */
public class L179LargestNumber {
    public String largestNumber(int[] num) {
        String res="";
        if(num==null||num.length==0)
            return  res;

        String[]str=new String[num.length];
        for(int i=0;i<num.length;i++)
        {
            str[i]=String.valueOf(num[i]);
        }
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return (a+b).compareTo(b+a);
            }
        });

        StringBuilder sb=new StringBuilder();
        for(String e:str)
            sb.insert(0,e);
        res=sb.toString();
        int i=0;
        while(i<num.length && res.charAt(i)=='0')
            i++;
        if(i==num.length)
            return "0";

        return  res.substring(i);
    }

    public static void main(String[] args) {
        System.out.println("50".compareTo("5"));
        System.out.println("1".compareTo("2"));
        System.out.println("2".compareTo("1"));

        System.out.println(new L179LargestNumber().largestNumber(new int[]{999999998,999999997,999999999}));
    }
}
