package com.frank.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by haitao on 7/21/15.
 */
public class L187RepeatedDNASequences {

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new LinkedList<String>();
        if (s==null ||s.length()<10)
            return res;


        Map<Integer,Boolean> isfreq=new HashMap<>();
        for (int i=0;i+10<=s.length();i++)
        {
            String tmp=s.substring(i,i+10);
            int val=toInt(tmp);
            if (isfreq.containsKey(val))
            {
                if(!isfreq.get(val))
                {
                    isfreq.put(val,true);
                    res.add(tmp);
                }
            }
            else
                isfreq.put(val,false);

        }

        return res;
    }

    //A, C, G, and T,

    int toInt(String s)
    {
        String tmp="";
        for (int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if (c=='A') tmp+=0;
            if (c=='C') tmp+=1;
            if (c=='G') tmp+=2;
            if (c=='T') tmp+=3;
        }
        return Integer.parseInt(tmp,4);
    }
    public static void main(String[]args)
    {
        new L187RepeatedDNASequences().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
    }

}
