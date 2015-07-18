package com.frank.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haitao on 7/17/15.
 */
public class L60PermutationSequence {

    public String getPermutation(int n, int k) {
        StringBuilder sb=new StringBuilder();
        int []jiecheng=new int[10];
        jiecheng[1]=1;
        for (int i=2;i<10;i++)
        {
            jiecheng[i]=jiecheng[i-1]*i;
        }
        List<Integer> digits=new ArrayList<Integer>();
        for (int i=1;i<=n;i++)
            digits.add(i);
        k=k-1;
        while (k>0 && digits.size()>1)
        {
            int tailnum=jiecheng[digits.size()-1];
            int ind=k/tailnum;
            sb.append(digits.remove(ind));
            k%=tailnum;
        }
        for (Integer e:digits)
            sb.append(e);
        return sb.toString();
    }



    public static void main(String []args){
//        for (int i=1;i<4;i++) {
//            String s = new L60PermutationSequence().getPermutation(3, i);
//            System.out.println(s);
//        }

        String s = new L60PermutationSequence().getPermutation(3, 2);
        System.out.println(s);


//        System.out.println(new L60PermutationSequence().myjiecheng(4));

        //9, 171669
    }
}
