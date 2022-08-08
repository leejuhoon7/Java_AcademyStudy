package com.bank.Member;

import java.util.Scanner;


import com.bank.App.MemberManage;

public class MemberService {

	public static Member memberInfo = null;
	Scanner sc = new Scanner(System.in);

	// 로그인
	public void doLogin() {

		Member member = new Member();
		System.out.println("id: ");
		String id = sc.nextLine();

		System.out.println("pw: ");
		String pw = sc.nextLine();

		member = MemberManage.getInstance().loginInfo(id);

		// DB조회한 저보와 내가 입력한 pw 비교
		if (member.getMemberPw().equals(pw)) {
			memberInfo = member;

		} else {
			System.out.println("로그인 실패");
		}

	}

	public void logout() {

		if (memberInfo != null) {
			memberInfo = null;

		}

		// 고객 등록
	}

	public void registerCustomer() {
		Member member = new Member();

		System.out.println("고객 ID: ");
		String id = sc.nextLine();

		System.out.println("고객 PW: ");
		String pw = sc.nextLine();

		System.out.println("고객 이름: ");
		String name = sc.nextLine();

		member.setMemberId(id);
		member.setMemberPw(pw);
		member.setMemberName(name);
		member.setRole("0");

		int result = MemberManage.getInstance().registCustomer(member);

		if (result == 1) {
			System.out.println("완료!");
		}
	}
	
	
}
