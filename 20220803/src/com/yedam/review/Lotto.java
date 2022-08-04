package com.yedam.review;

import java.util.Scanner;

public class Lotto {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int[] money = null;
		int[] save = new int[6];
		boolean isTrue = true;
		int select = 0;

		System.out.println("메뉴를 선택해 주세요.");
		System.out.println("1.로또생성 2.로또조회 99.프로그램 종료");

		while (isTrue) {
			System.out.println("금액을 투입해주세요.");

			if (select == 1) {
				int input = Integer.parseInt(scn.nextLine());
				money = new int[input];

				for (int i = 1000; i < money.length; i++) {
					int random = (int) (Math.random() * 45) + 1;

					System.out.print(random + " ");
				}
			} else if (select == 2) {
				for (int i = 1000; i < money.length; i++) {
//					System.out.println(random[i]);
				}
			} else if(select == 99) {
				System.out.println("프로그램 종료");
				isTrue = false;
			}
		}
	}
}
