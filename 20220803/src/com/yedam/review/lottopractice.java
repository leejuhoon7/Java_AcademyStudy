package com.yedam.review;

public class lottopractice {

	public static void main(String[] args) {
		
		
		for(int i = 0; i < 6; i++) {
			int random = (int)(Math.random() * 45) + 1;
			System.out.print(random + " ");
		}
	}

}
