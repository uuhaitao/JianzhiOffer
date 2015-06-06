package com.frank.jianzhi;

public class P_3FindNum {

	public static boolean find(int key, int [][]array){
		int rows=array.length;
		int colums=array[0].length;
		int i=0;int j=colums-1;
		while(i<=rows-1 && j>=0){
			if(array[i][j]==key)
				return true;
			else if(key>array[i][j])
				i++;
			else
				j--;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		int testa[][]={
				{1,2,3},
				{2,5,9}	
		};
		
//		for (int key=0;key<20;key++){
//			System.out.println(""+key+(find(key, testa)?" in":" not in")+" the array");
//		}
		
		System.out.println(find(9, testa));
		
		
	}

}
