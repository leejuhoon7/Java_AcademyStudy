package com.yedam.exam;

public class CardPayment implements Payment {

	// 필드
	public double cardRatio;

	// 생성자
	public CardPayment(double cardRatio) {
		this.cardRatio = cardRatio;
	}

	// 메소드
	@Override
	public int online(int price) {
		int pay = (int) (price - (price * (cardRatio + Payment.ONLINE_PAYMENT_RATIO)));
		return pay;
	}

	@Override
	public int offline(int price) {
		int pay = (int) (price - (price * (cardRatio + Payment.OFFLINE_PAYMENT_RATIO)));
		return pay;
	}

	@Override
	public void showInfo() {
		System.out.println("카드결제 시 할인정보");
		System.out.println("온라인 결제 시 총 할인율: " + (cardRatio + Payment.ONLINE_PAYMENT_RATIO));
		System.out.println("오프라인 결제 시 총 할인율: " + (cardRatio + Payment.OFFLINE_PAYMENT_RATIO));
	}

}
