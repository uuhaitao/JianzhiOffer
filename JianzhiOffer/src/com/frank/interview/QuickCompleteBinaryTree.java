package com.frank.interview;

public class QuickCompleteBinaryTree {

	public String Tobinary(int v, int n) {
		String base = Integer.toBinaryString(v);
		int len = base.length();
		while (len < n) {
			base = "0" + base;
			len++;
		}
		return base;
	}

	public int getNum(TreeNode root, int level) {
		int above = (int) Math.pow(2, level - 1) - 1;
		int down = 0;
		int l = 0;
		int right = above;
		while (l <= right) {
			
			if (right-l==1) {
				boolean found = fund(root, level, right);
				if(found)
					return above+right+1;
				else
				return above + down+l+1;
			}
			int mid = (l + right) / 2;
			
			boolean found = fund(root, level, mid);
			if (found)
				l = mid;
			else
				right = mid;
		}
		return 0;
	}

	boolean fund(TreeNode root, int n, int ind) {
		String direction = Tobinary(ind, n - 1);
		TreeNode curr = root;
		for (int i = 0; i < n - 1; i++) {
			if (direction.charAt(i) == '0')
				curr = curr.left;
			else
				curr = curr.right;
		}
		return curr != null;
	}

	public static void main(String[] args) {

		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		 TreeNode t7=new TreeNode(7);
		 TreeNode t8=new TreeNode(8);
		 TreeNode t9=new TreeNode(9);
		 TreeNode t10=new TreeNode(10);
		 TreeNode t11=new TreeNode(11);

		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		t3.left = t6;
		t3.right=t7;
		t4.left=t8;
		t4.right=t9;
		t5.left=t10;
		t5.right=t11;
		
		
		int n = new QuickCompleteBinaryTree().getNum(t1, 4);
		System.out.println(n);

	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	public TreeNode(int v) {
		val = v;
	}

	public TreeNode() {

	}
}
