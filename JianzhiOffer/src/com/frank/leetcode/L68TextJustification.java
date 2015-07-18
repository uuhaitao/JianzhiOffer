package com.frank.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haitao on 7/18/15.
 */
public class L68TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res=new ArrayList<String>();
        int start=0;
        int len=words[0].length();
        int size=words.length;
        for(int i=1;i<size;i++)
        {
            if(len+words[i].length()+1>maxWidth)
            {
                String line=get(words,start,i,len,maxWidth);
                res.add(line);
                start=i;
                len=words[i].length();
            }
            else
            {
                len+=words[i].length()+1;
            }
        }
        res.add(lastline(words,start,size,maxWidth));

        return  res;

    }
    String get(String[]words, int start, int end,int len,int maxWidth)
    {
        if (maxWidth==1)
            return words[start];
        String line="";
        int wordnum=end-start;
        int spacenum=maxWidth-len;
        if(wordnum==1)
        {
            int c=0;
            line=words[start];
            while (c<spacenum)
            {
                line+=" ";
                c++;
            }
        }
        else
        {
            int spacelen=spacenum/(wordnum-1);
            int leftmore=spacenum%(wordnum-1);
            for (int i=start;i<end-1;i++)
            {
                line+=words[i];
                int c=0;
                while (c<spacelen+1)
                {
                    line+=" ";
                    c++;
                }
                if (leftmore>0)
                {
                    line+=" ";
                    leftmore--;
                }
            }
            line+=words[end-1];
        }
        return line;


    }
    String lastline(String []wors,int start,int end,int max)
    {
        String res=wors[start];
        for (int i=start+1;i<end;i++)
            res+=wors[i]+" ";
        int len=res.length();
        while (len<max)
        {
            res+=" ";
            len++;
        }
        return  res;
    }


    public  static void  main(String []args)
    {
        List<String> res=new L68TextJustification().fullJustify(
                new String[]{"Listen","to","many,","speak","to","a","few."}, 6);
        for (String e:res)
        {
            System.out.println(e);
//            System.out.println(e.length());
        }
    }
}
