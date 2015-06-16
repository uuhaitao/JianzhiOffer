package com.frank.leetcode;

public class L105ConstructTreefromPreorderandInorder {
	public TreeNode buildTree(int[] preorder, int[] inorder) {  
        return buildPI(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);  
    }  
    public TreeNode buildPI(int[] preorder, int[] inorder, int p_s, int p_e, int i_s, int i_e){  
        if(p_s>p_e)  
            return null;  
        int pivot = preorder[p_s];  
        int i = i_s;  
        for(;i<i_e;i++){  
            if(inorder[i]==pivot)  
                break;  
        }  
        
        TreeNode node = new TreeNode(pivot);  
        int lenLeft = i-i_s;  
        node.left = buildPI(preorder, inorder, p_s+1, p_s+lenLeft, i_s, i-1);  
        node.right = buildPI(preorder, inorder, p_s+lenLeft+1, p_e, i+1, i_e);  
        return node;  
    }  


	public static void main(String[] args) {
		new L105ConstructTreefromPreorderandInorder().buildTree(
				new int[] { -1 }, new int[] { -1 });
	}
}
