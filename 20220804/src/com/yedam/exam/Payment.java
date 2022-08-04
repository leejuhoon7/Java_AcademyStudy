package com.yedam.exam;

public interface Payment {

//	 상수필드
//  1) 온라인 결제 할인율 (ONLINE_PAYMENT_RATIO), 5%

	public static final double ONLINE_PAYMENT_RATIO = 0.05;

//	2) 오프라인 결제 할인율 (OFFLINE_PAYMENT_RATIO), 3% 
	public static final double OFFLINE_PAYMENT_RATIO = 0.03;

//	 추상메소드
	public int online(int price);
	public int offline(int price);
	public void showInfo();

}
