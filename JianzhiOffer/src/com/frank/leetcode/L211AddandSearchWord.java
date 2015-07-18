package com.frank.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by haitao on 7/18/15.
 */
class SearchTree
{
    char c;
    boolean isLeaf;
    public Map<Character,SearchTree> map=new HashMap<>();
    SearchTree(){}
    SearchTree(char c){
        this.c=c;
    }

}

public class L211AddandSearchWord {
    SearchTree root=new SearchTree();

    // Adds a word into the data structure.
    public void addWord(String word) {
        SearchTree parent=root;
        int i=0;
        while (i<word.length())
        {
            char tmp=word.charAt(i);
            if(parent.map.containsKey(tmp))
                parent=parent.map.get(tmp);
            else
            {
                break;
            }
            i++;

        }
        while (i<word.length())
        {
            char newchar=word.charAt(i);
            SearchTree newnode=new SearchTree(newchar);
            if(i==word.length()-1)
                newnode.isLeaf=true;
            parent.map.put(newchar,newnode);
            parent=newnode;
            i++;
        }
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {

        return find(word,root);
    }

    boolean find(String world, SearchTree node)
    {
        if (node==null)
            return false;
        if(world.length()==0)
            return  node.isLeaf;
        Map<Character,SearchTree> map=node.map;
        SearchTree n=null;
        char c=world.charAt(0);
        if (c=='.')
        {
            for(char key:map.keySet())
                if(find(world.substring(1),map.get(key)))
                    return true;
            return false;
        }
        else if(map.containsKey(c))
            return find(world.substring(1),map.get(c));
        return false;

    }

    public static void main(String []args)
    {
        L211AddandSearchWord tool=new L211AddandSearchWord();
        //addWord("bad")
        tool. addWord("dad");
        tool.addWord("mad");
        System.out.println(tool.search("pad"));
        System.out.println(tool.search("bad"));
        System.out.println(tool.search(".ad"));
        System.out.println(tool.search("b.."));
    }

}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");

