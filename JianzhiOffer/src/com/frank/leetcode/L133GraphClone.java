package com.frank.leetcode;

import java.util.*;

/**
 * Created by haitao on 7/23/15.
 */
public class L133GraphClone {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node==null)
            return  null;

        Map<Integer,UndirectedGraphNode> map=new HashMap<>();
        return cloneNode(node,map);

    }
    UndirectedGraphNode cloneNode(UndirectedGraphNode anode,Map<Integer,UndirectedGraphNode> map)
    {
        if (map.containsKey(anode.label))
            return  map.get(anode.label);
        UndirectedGraphNode newNode=new UndirectedGraphNode(anode.label);
        map.put(anode.label,newNode);
        for (UndirectedGraphNode n:anode.neighbors)
        {
            newNode.neighbors.add(cloneNode(n,map));
        }
        return newNode;
    }
}
