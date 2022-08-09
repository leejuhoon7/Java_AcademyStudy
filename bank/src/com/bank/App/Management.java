package com.bank.App;

import java.util.Scanner;

import com.bank.Account.AccountService;
import com.bank.Loan.LoanService;
import com.bank.Member.MemberService;

public class Management {

	Scanner sc = new Scanner(System.in);

	MemberService ms = new MemberService();
	AccountService as = new AccountService();
	LoanService ls = new LoanService();

	int menuNo = 0;

	public Management() {
		bankJob();
	}

	private void bankJob() {
		while (true) {
			menuInfo();
			if (MemberService.memberInfo.getRole().equals("1")) {
				if (menuNo == 1) {
					// 고객 등록
					ms.registerCustomer();
					System.out.println("체크1!");
				} else if (menuNo == 2) { // 계좌 개설
					as.makeAccount();
				} else if (menuNo == 3) {
					as.money();
				} else if (menuNo == 4) {
					as.transfer();
				} else if (menuNo == 5) {
					as.deleteAccount();
				} else if (menuNo == 6) {
					System.out.println("1.대출 2.대출정보변경");
					int menu = Integer.parseInt(sc.nextLine());
					if (menu == 1) {
						ls.insertLoan();
					} else if (menu == 2) {
						ls.updateLoan();
					}
				}

			} else if (MemberService.memberInfo.getRole().equals("0")) {
				
				if(menuNo == 1) {
					as.getAccount();
				} else if(menuNo == 2) {
					as.money();
				} else if(menuNo == 3) {
					as.transfer();
				} else if(menuNo == 4) {
					System.out.println("1.상환 2.대출조회");
					int menu = Integer.parseInt(sc.nextLine());
					//상환
					if(menu == 1) {
						ls.updateMoney();
						
						//대출 조회
					} else if(menu == 2) {
						ls.loanInfo();
						
					}
				}

			}

		}
	}

	private void menuInfo() {
		if (MemberService.memberInfo.getRole().equals("1")) {
			System.out.println("1.고객 등록 | 2.계좌 개설 | 3.입출금 | 4.계좌 이체 | 5.계좌 해지 | 6. 대출");
		} else if (MemberService.memberInfo.getRole().equals("0")) {
			System.out.println("1.계좌 조회 | 2.입금 | 3.출금 | 4.계좌 이체| 5. 대출");
		}

		menuNo = Integer.parseInt(sc.nextLine());
	}
}
