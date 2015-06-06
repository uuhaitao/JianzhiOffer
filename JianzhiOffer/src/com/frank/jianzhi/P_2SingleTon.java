package com.frank.jianzhi;

public class P_2SingleTon {
	
	private static P_2SingleTon instance;
	
	private P_2SingleTon(){
		
	}
	
	public P_2SingleTon getInstance(){
		synchronized (P_2SingleTon.class) {
			if (instance==null){
				synchronized (P_2SingleTon.class) {
					instance=new P_2SingleTon();
				}
			}
			
		}
		
		return instance;
	}
}
