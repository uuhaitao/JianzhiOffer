package com.frank.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haitao on 7/23/15.
 */
public class UndirectedGraphNode {

    int label;
    List<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x)
    {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }

}
